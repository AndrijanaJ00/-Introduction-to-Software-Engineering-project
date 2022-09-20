/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrijana Jovanovic
 */
public class BankaTest {
    
    public BankaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testProveraKartice() {
        System.out.println("proveraKartice");
        String brKartice = "1234";
        int pin = 1234;
     
        boolean expResult = true;
        boolean result = Banka.getBanka().proveraKartice(brKartice, pin);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testProveraKartice1() {
        System.out.println("proveraKartice");
        String brKartice = "123456";
        int pin = 123456;
     
        boolean expResult = false;
        boolean result = Banka.getBanka().proveraKartice(brKartice, pin);
        assertEquals(expResult, result);
    }
    
}
