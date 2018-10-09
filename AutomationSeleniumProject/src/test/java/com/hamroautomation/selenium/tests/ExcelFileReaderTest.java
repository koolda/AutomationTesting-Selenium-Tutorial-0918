package com.hamroautomation.selenium.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hamroautomation.selenium.data.model.Address;
import com.hamroautomation.selenium.data.model.Customer;
import com.hamroautomation.selenium.data.model.Phone;
import com.javalearning.library.ExcelFileReader;
//import com.javalearning.library.model.Address;
//import com.javalearning.library.model.Customer;

public class ExcelFileReaderTest {
    @Test
    public void TestFileReaderParse() {
        ExcelFileReader fileReader = new ExcelFileReader();

        String fileName = "customer.xlsx";
        List<Customer> customerList = fileReader.getObjectListFor(fileName, "customer", Customer.class);
        List<Address> addressList = fileReader.getObjectListFor(fileName, "address", Address.class);
        List<Phone> phoneList = fileReader.getObjectListFor(fileName, "phone", Phone.class);

        Phone phone = phoneList.get(0);
        

        Assert.assertTrue(customerList.size() > 1);

        Customer customer = customerList.get(0);
        Assert.assertEquals("Andy", customer.getFirstName());
        Assert.assertEquals("01/02/2000", customer.getDob());


        
        
        Assert.assertEquals(7, addressList.size());
        Assert.assertTrue(addressList.size() > 1);

        Address address = addressList.get(0);
        Assert.assertEquals("12345", address.getZipCode());
        Assert.assertEquals("NY", address.getState());

    }
}
