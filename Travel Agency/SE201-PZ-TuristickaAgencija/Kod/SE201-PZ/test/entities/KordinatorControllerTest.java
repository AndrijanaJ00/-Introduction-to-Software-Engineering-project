/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import main.Main;
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
public class KordinatorControllerTest {
    
    public KordinatorControllerTest() {
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
    public void testVratiSveAranzmane() throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse("19-2-2000");
        Date date2 = sdf.parse("20-2-2000");

        Aranzman a = new Aranzman("ss", "ff", date1, date2, 200);

        Date date3 = sdf.parse("22-2-2000");
        Date date4 = sdf.parse("24-2-2000");
        
        Aranzman a1 = new Aranzman("aa", "bb", date3, date4, 200);
        Database.getDatabaseB().dodajAranzmanDB(a1);
        Database.getDatabaseB().dodajAranzmanDB(a);
        
        String lokacija = "aa";
        String smestaj = "bb";
        Date datumZavrsetka = sdf.parse("19-2-2000");
        Date datumPocetka = sdf.parse("20-2-2000");
        List<Aranzman> expResult = new ArrayList<>();
        expResult.add(a1);
        List<Aranzman> result = KordinatorController.vratiSveAranzmane(lokacija, smestaj, datumZavrsetka, datumPocetka);
        
        assertEquals(expResult, result);
    }

   
    @Test
    public void testSacuvajAranzman() throws ParseException {
        System.out.println("sacuvajAranzman");
        
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse("19-2-2000");
        Date date2 = sdf.parse("20-2-2000");

        Aranzman a = new Aranzman("ss", "ff", date1, date2, 200);

        Date date3 = sdf.parse("22-2-2000");
        Date date4 = sdf.parse("24-2-2000");
        
        Aranzman a1 = new Aranzman("aa", "bb", date3, date4, 200);
        Database.getDatabaseB().dodajAranzmanDB(a1);
        Database.getDatabaseB().dodajAranzmanDB(a);
        
        int id = 3;
        String lokacija = "aa";
        String smestaj = "bb";
        Date datumPocetka = date3;
        Date datumZavrsetka = date4;
        double cena = 2100.0;
        KordinatorController.sacuvajAranzman(lokacija, smestaj, datumPocetka, datumZavrsetka, cena);
        
    }

    
    @Test
    public void testPostoji() throws ParseException {
        System.out.println("postoji");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse("19-2-2000");
        Date date2 = sdf.parse("20-2-2000");

       Aranzman a = new Aranzman("aa", "bb", date1, date2, 200);
       Database.getDatabaseB().getListaAranzmana().add(a);
       Aranzman a1 = new Aranzman("aa", "bb", date1, date2, 200);
        boolean expResult = true;
        boolean result = KordinatorController.postoji(a1);
        assertEquals(expResult, result);
        
    }
   
    @Test
    public void testObrisiAranzman() throws ParseException {
        System.out.println("obrisiAranzman");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse("19-2-2000");
        Date date2 = sdf.parse("20-2-2000");

        Aranzman a = new Aranzman("aa", "bb", date1, date2, 200);
        Database.getDatabaseB().dodajAranzmanDB(a);
        KordinatorController.obrisiAranzman(a);
        boolean expResult = false;
        boolean result = KordinatorController.postoji(a);
         assertEquals(expResult, result);
    }
   
    @Test
    public void testProveraUspesnostiRezervacije() throws ParseException {
        System.out.println("proveraUspesnostiRezervacije");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse("19-2-2000");
        Date date2 = sdf.parse("20-2-2000");

        Aranzman a = new Aranzman("aa", "bb", date1, date2, 200);
        Klijent klijent = new Klijent("Andrijana", 1, "Jovanovic", "234324423", "Cuprija");
     
        Rezervacija r = new Rezervacija(a, 1, 1, klijent);

        Aranzman a1 = new Aranzman("aa", "bb", date1, date2, 200);
        Klijent klijent1 = new Klijent("Andrijana", 1, "Jovanovic", "234324423", "Cuprija");
  
        Rezervacija r1 = new Rezervacija(a, 1, 1, klijent);
        Database.getDatabaseB().getListaRezervacija().add(r1);
        boolean expResult = true;
        boolean result = KordinatorController.proveraUspesnostiRezervacije(r);
        assertEquals(expResult, result);
    }
    
}
