/***********************************************************************
 * Module:  KlijentUI.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class KlijentUI
 ***********************************************************************/
package entities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/** @pdOid d32ffe10-eb82-4e46-84d8-bbf65339149d */
public class KlijentUI extends UI {
   /** @pdOid a9511127-cc51-4247-80ac-3f74606d1ebe */
   private int brKartice;
   /** @pdOid 09fabb75-a234-4a98-a9ee-6c5f9f49e621 */
   private int pin;
   /** @pdOid 651cd0d3-9d32-430f-910f-24862d47057e */
   private int brRacuna;
   
   /** @pdOid e9bcc696-32ef-42af-a234-7f556d7fbe04 */
   public static void prikazi() {
      // TODO: implement
   }
   
   public void detaljanPrikaz(Aranzman aranzman) {
      // TODO: implement
   }
   
   public void rezervisi(Rezervacija r) {
      
   }
   
   /** @pdOid 3026fa5e-415c-46d8-b2df-72d8e4c63128 */
   public static void pregledRezervacija() {
      // TODO: implement
   }
   
   /** @pdOid ac4a2268-81ff-42f2-b6ef-849aebedc4cb */
   public void otkazi() {
      // TODO: implement
   }
   
   /** @pdOid e696f63e-d3c6-44ea-ae2f-3c091d099964 */
   public void pojedinacnaRezervacije() {
      // TODO: implement
   }
   
   /** @pdOid 3e7b8193-de7a-4b8b-8000-4becb3adea4d */
   public void potvrdiPlacanje() {
      // TODO: implement
   }
   
   public static void otvoriStranicu() {     
       System.out.println("--------------------------");
        System.out.println("Lokacija: ");
        lokacijaTxt = main.Main.sc.next();
        System.out.println("Smestaj: ");
         smestajTxt = main.Main.sc.next();
        System.out.println("Datum pocetka: ");
         datumPocetkaTxt = main.Main.sc.next();
          Date date1 = null;
       try {  
           date1=new SimpleDateFormat("dd-MM-yyyy").parse(datumPocetkaTxt);
       } catch (ParseException ex) {
          ex.printStackTrace();
       }
        System.out.println("Datum zavrsetka: ");
         datumZavrsetkaTxt = main.Main.sc.next();
         Date date2 = null;
        try {  
           date2 = new SimpleDateFormat("dd-MM-yyyy").parse(datumZavrsetkaTxt);
       } catch (ParseException ex) {
          ex.printStackTrace();
       }
        System.out.println(KordinatorController.vratiSveAranzmane(lokacijaTxt, smestajTxt, date1, date2));
        
    }

}