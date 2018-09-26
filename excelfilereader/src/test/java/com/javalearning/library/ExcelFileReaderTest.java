package com.javalearning.library;

import com.javalearning.library.model.Address;
import com.javalearning.library.model.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class ExcelFileReaderTest {
    @Test
    public void TestFileReaderParse() {
        ExcelFileReader fileReader = new ExcelFileReader();

        String fileName = "customer.xlsx";
        List<Customer> customerList = fileReader.getObjectListFor(fileName, "customer", Customer.class);
        List<Address> addressList = fileReader.getObjectListFor(fileName, "address", Address.class);


        Assert.assertTrue(customerList.size() > 1);

        Customer customer = customerList.get(0);
        Assert.assertEquals("customer1", customer.getName());
        Assert.assertEquals(30, customer.getAge());


        Assert.assertEquals(7, addressList.size());
        Assert.assertTrue(addressList.size() > 1);

        Address address = addressList.get(0);
        Assert.assertEquals("12345", address.getZipCode());
        Assert.assertEquals("US", address.getCountry());

    }
}
