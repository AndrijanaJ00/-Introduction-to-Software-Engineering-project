/** *********************************************************************
 * Module:  KordinatorController.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class KordinatorController
 ********************************************************************** */
package entities;

import entities.Database;
import exception.OpcijaException;
import java.util.*;
import static main.Main.sc;

public class KordinatorController{

    public static List<Aranzman> vratiSveAranzmane(String lokacija, String smestaj, Date datumZavrsetka, Date datumPocetka) {
        
        List<Aranzman> aranzmani = new ArrayList<>();
        for (Aranzman aranzman: Database.getDatabaseB().vratiAranzmane()) {
            if (aranzman.getLokacija().equals(lokacija) 
                    && aranzman.getSmestaj().equals(smestaj)) {
                aranzmani.add(aranzman);
            }else{
                UI.prikaziPoruku("Aranzman ne postoji");
            }
        }
        return aranzmani;
    }

    public static void sacuvajAranzman(String lokacija, String smestaj, java.util.Date datumPocetka, java.util.Date datumZavrsetka, double cena) {
        Aranzman a = new Aranzman(lokacija, smestaj, datumPocetka, datumZavrsetka, cena);
       if(!postoji(a)){
           Database.getDatabaseB().dodajAranzmanDB(a);
          UI.prikaziPoruku("Uspesno dodavanje");
       }else{
           UI.prikaziPoruku("Aranzman vec postoji");
       }
    }

    public static boolean postoji(Aranzman aranzman) {
       for(Aranzman a: Database.getDatabaseB().getListaAranzmana()){
           if(aranzman.getLokacija().equals(a.getLokacija()) 
                    && aranzman.getSmestaj().equals(a.getSmestaj()) 
                    && aranzman.getDatumZavrsetka().equals(a.getDatumZavrsetka())
                     && aranzman.getDatumPocetka().equals(a.getDatumPocetka())){
               return true;
           }
       }
         return false;
    }

    public static void obrisiAranzman(Aranzman aranzman) {
      Database.getDatabaseB().obrisiAranzman(aranzman);
    }

    public static void izmeniAranzman(Aranzman aranzman) {
        // TODO: implement
    }

    public static void potvrdiRezervaciju(Aranzman a, Klijent klijent, int brojSoba, int brojOsoba) {
        
        Rezervacija r = new Rezervacija(a, brojSoba, brojOsoba, klijent);
        
        
        if (!proveraUspesnostiRezervacije(r)) {
            Database.getDatabaseB().dodajRezervacijuDB(r);
               Klijent.dodajRezervaciju(r);
            
            UI.prikaziPoruku("*****Uspesna rezervacija******");
            UI.prikaziPoruku(">>>>>>>>Placanje");
            System.out.println("");
            System.out.println("Broj kartice: ");
            main.Main.sc.nextLine();
            String brKartice =  main.Main.sc.nextLine();
            System.out.println("Pin");
            int pin =  main.Main.sc.nextInt();
            proveraPlacanja(pin, brKartice);
        } else {
            UI.prikaziPoruku("Rezervacija nije uspesna");
        }

    }

    public static List<Rezervacija> vratiRezervacijeKlijenta(Klijent klijent) {     
        return klijent.klijentRezervacije();
    }

    public static void otkaziRezervaciju(int id) {
      for(Rezervacija r : Database.getDatabaseB().getListaRezervacija()){
           if(r.getId() == id){
               r.setStatus("otkazana");
               UI.prikaziPoruku("Uspesno ste otkazali ne postoji");
           }
       }
    }

    public static void vratiPojedinacnuRezervaciju(int id) {
        System.out.println(Database.getDatabaseB().getListaRezervacija());
       
        for(Rezervacija r : Database.getDatabaseB().getListaRezervacija()){
           if(r.getId() == id){
               r.toString();
           }else{
                UI.prikaziPoruku("Rezervacija ne postoji");
           }
       }
       
    }

    public static void proveraPlacanja(int pin, String brojKartice) {
        if(Banka.getBanka().proveraKartice(brojKartice, pin)){
            UI.prikaziPoruku("Uspesno placanje");
        }else{
          UI.prikaziPoruku("Nevalidna ");
        }
    }

    public static void placanje(String brojKartice, int pin) {
        // TODO: implement
    }

    public static void detaljanPrikazAranzmana(int id) {
        for(Aranzman a : Database.getDatabaseB().getListaAranzmana()){
           if(a.getId() == id){
               System.out.println(a.toString());
               return;
           }
       }
       UI.prikaziPoruku("Aranzman ne postoji");
    }

    public static boolean proveraUspesnostiRezervacije(Rezervacija rezervacija) {
        for (Rezervacija r:  Database.getDatabaseB().getListaRezervacija()) {
            if (rezervacija.getAranzman().equals(r.getAranzman())
                    && rezervacija.getBrojOsoba() == r.getBrojOsoba()
                    && rezervacija.getBrojSoba() == r.getBrojSoba()
                    && rezervacija.getKlijent() == r.getKlijent()) {
                return true;
            }
        }
        return false;
    }

    

}
