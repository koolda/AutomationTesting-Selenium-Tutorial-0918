package com.javalearning.library;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ExcelFileReader {
    private Logger logger = LogManager.getLogger(ExcelFileReader.class);
    private DataFormatter dataFormatter = new DataFormatter();

    /*
     * @param filePath: excel file path which contains information that we are looking for our type T objects.
     * @param sheetName: name of sheet in @filePath excel file which contains information for our type T objects.
     * @param clazz: target class type into which we are mapping data from excel file.
     * @return list of T type objects
     * */
    <T> List<T> parse(String filePath, String sheetName, Class<T> clazz){
        Gson gson = new Gson();
        JsonObject jsonObject = getExcelDataAsJsonObject(new File(filePath), sheetName);
        logger.info("Now converting json object into "+clazz.getSimpleName()+" object...");
        List<T> results = gson.fromJson(jsonObject.get(sheetName).toString(), TypeToken.getParameterized(List.class, clazz).getType());
        logger.info("Done converting json object into "+clazz.getSimpleName()+" object.\n");
        return results;
    }

    private JsonObject getExcelDataAsJsonObject(File excelFile, String sheetName)  {
        logger.info("Started reading excel file "+ excelFile.getName()+"...");
        JsonObject sheetsJsonObject = new JsonObject();
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(excelFile);
            JsonArray sheetArray = new JsonArray();
            List<String> columnNames = new ArrayList<>();
            Sheet sheet = workbook.getSheet(sheetName);
            for (Row currentRow : sheet) {
                JsonObject jsonObject = new JsonObject();
                if (currentRow.getRowNum() != 0) {
                    processValues(currentRow, columnNames, jsonObject, workbook);
                    sheetArray.add(jsonObject);
                } else {
                    // if first row, then column names
                    for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
                        columnNames.add(currentRow.getCell(k).getStringCellValue());
                    }
                }
            }
            sheetsJsonObject.add(sheet.getSheetName(), sheetArray);
            logger.info("Done reading and converting "+sheetName+" sheet from excel file into json object.");
        } catch (Exception e) {
            logger.error("ExcelUtils -> getExcelDataAsJsonObject() :: Exception thrown constructing XSSFWorkbook from provided excel file.  InvalidFormatException | IOException => ");
            e.printStackTrace();
        }
        return sheetsJsonObject;
    }

    private void processValues(Row currentRow,List<String> columnNames ,JsonObject jsonObject, Workbook workbook) throws Exception {
        for (int j = 0; j < columnNames.size(); j++) {
            if (currentRow.getCell(j) != null) {
                if (currentRow.getCell(j).getCellType() == CellType.BLANK) {
                    jsonObject.addProperty(columnNames.get(j), "");
                } else {
                    String cellValue = dataFormatter.formatCellValue(currentRow.getCell(j));
                    if(isListReferenceType(cellValue)){
                        jsonObject.add(columnNames.get(j), parseListReference(cellValue.split(":")[1], workbook));
                    }
                    else if(isReferenceType(cellValue)){
                        jsonObject.add(columnNames.get(j), parseReference(cellValue.split(":")[1], workbook));
                    }else
                        jsonObject.addProperty(columnNames.get(j), cellValue);
                }
            } else {
                jsonObject.addProperty(columnNames.get(j), "");
            }
        }
    }

    private JsonObject parseReference(String reference, Workbook workbook) throws Exception {
        String[] ref = reference.split("@");
        Sheet sheet = workbook.getSheet(ref[0]);
        String colName = ref[1].split("#")[0];
        String colVal = ref[1].split("#")[1];
        Row row = findRow(sheet, colName, colVal);
        if(row == null)
            throw new Exception("couldn't find the reference :: Sheet = "+sheet.getSheetName()+", Column = "+colName+", Value = "+colVal);
        Row headers = sheet.getRow(0);
        List<String> columnNames = new ArrayList<>();
        for (int k = 0; k < headers.getPhysicalNumberOfCells(); k++) {
            columnNames.add(headers.getCell(k).getStringCellValue());
        }
        JsonObject jsonObject = new JsonObject();
        processValues(row, columnNames, jsonObject, workbook);
        return jsonObject;
    }

    private JsonArray parseListReference(String listReference, Workbook workbook) throws Exception {
        String[] listOfReferences = listReference.split(",");
        JsonArray jsonArray = new JsonArray();
        for (String reference : listOfReferences) {
            jsonArray.add(parseReference(reference, workbook));
        }
        return jsonArray;
    }

    private boolean isReferenceType(String cellValue){
        return cellValue.split(":").length > 0 && cellValue.split(":")[0].equals("reference");
    }

    private boolean isListReferenceType(String cellValue){
        return cellValue.split(":").length > 0 && cellValue.split(":")[0].equals("listReference");
    }

    private Row findRow(Sheet sheet, String cellHeader, String cellContent) {
        Row columnHeaders = sheet.getRow(0);
        int cellHeaderIndex = 0;
        for (Cell cell : columnHeaders) {
            if (cell.getRichStringCellValue().getString().trim().equals(cellHeader)) {
                cellHeaderIndex = cell.getColumnIndex();
                break;
            }
        }
        for (Row row : sheet) {
            Cell cell = row.getCell(cellHeaderIndex);
            if (dataFormatter.formatCellValue(cell).trim().equals(cellContent)) {
                return row;
            }
        }
        return null;
    }
}
