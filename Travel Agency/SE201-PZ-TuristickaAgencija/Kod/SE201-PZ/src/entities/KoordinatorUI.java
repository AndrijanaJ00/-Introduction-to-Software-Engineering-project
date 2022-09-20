/** *********************************************************************
 * Module:  KoordinatorUI.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class KoordinatorUI
 ********************************************************************** */
package entities;

import static entities.UI.lokacijaTxt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class KoordinatorUI extends UI {

    private static double cenaTxt;

    public void sacuvaj() {

    }

    public void obrisi() {
        // TODO: implement
    }

    public void izmeni() {
        // TODO: implement
    }

    public void otvoriIzmenu() {
        // TODO: implement
    }

    public void otvoriDodavanje() {
        // TODO: implement
    }

    public static void otvoriStranicuKoordinator() {     
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
         System.out.println("Cena: ");
        cenaTxt = main.Main.sc.nextInt();
        
        KordinatorController.sacuvajAranzman(lokacijaTxt, smestajTxt, date1, date2, cenaTxt);
        
    }

}
