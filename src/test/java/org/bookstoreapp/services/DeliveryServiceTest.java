package org.bookstoreapp.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.bookstoreapp.model.Order;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import static org.junit.Assert.*;

public class DeliveryServiceTest extends ApplicationTest{

    @BeforeClass
    public static void setupClass() {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initApplicationHomeDirIfNeeded();
    }

    @Before
    public void setUp() throws IOException {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
    }

    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception {
        DeliveryService.loadOrdersFromFile();
        assertTrue(Files.exists(DeliveryService.ORDERS_PATH));
    }

    @Test
    public void testLoadOrdersFromFile() throws Exception {
        DeliveryService.loadOrdersFromFile();
        assertNotNull(DeliveryService.orders);
        assertEquals(0, DeliveryService.orders.size());
    }

    @Test
    public void testAddOneOrder() throws Exception {
        DeliveryService.loadOrdersFromFile();
        DeliveryService.addOrder("test", "testPass", "432","testemail","075",0);
        assertNotNull(DeliveryService.orders);
        assertEquals(1, DeliveryService.orders.size());
    }

    @Test
    public void testAddTwoOrders() throws Exception{
        DeliveryService.loadOrdersFromFile();
        DeliveryService.addOrder("test1", "testPass1", "431","testemail1","076",0);
        DeliveryService.addOrder("test2", "testPass2", "430","testemail2","078",0);
        assertNotNull(DeliveryService.orders);
        assertEquals(2, DeliveryService.orders.size());
    }
    @Test
    public void testAddOneOrderIsPersisted() throws Exception {
        DeliveryService.loadOrdersFromFile();
        DeliveryService.addOrder("test", "testPass", "432","testemail","075",0);
        List<Order> orders = new ObjectMapper().readValue(DeliveryService.ORDERS_PATH.toFile(), new TypeReference<List<Order>>() {
        });
        assertNotNull(orders);
        assertEquals(1, orders.size());
    }

    @Test
    public void testAddTwoUserArePersisted() throws Exception {
        DeliveryService.loadOrdersFromFile();
        DeliveryService.addOrder("test1", "testPass1", "123","testemail1","077",0);
        DeliveryService.addOrder("test2", "testPass2", "432","testemail3","079",0);
        List<Order> orders = new ObjectMapper().readValue(DeliveryService.ORDERS_PATH.toFile(), new TypeReference<List<Order>>() {
        });
        assertNotNull(orders);
        assertEquals(2, orders.size());
    }

}