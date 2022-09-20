package main;

import entities.Aranzman;
import entities.Builder;
import entities.Database;
import entities.Klijent;
import entities.KlijentUI;
import entities.KoordinatorUI;
import entities.KordinatorController;
import entities.Rezervacija;
import entities.UI;
import exception.OpcijaException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrijana Jovanovic
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        String datumPocetkaTxt = "20-2-2000";
        Date date1 = null;
        try {
            date1 = sd.parse(datumPocetkaTxt);
        } catch (ParseException ex) {
           ex.printStackTrace();
        }

        String datumZavrsetkaTxt = "21-2-2000";

        Date date2 = null;
        try {
            date2 = sd.parse(datumPocetkaTxt);
        } catch (ParseException ex) {
             ex.printStackTrace();
        }

        Aranzman a = new Aranzman( "aa", "bb", date1, date2, 200);
        Database.getDatabaseB().dodajAranzmanDB(a);
        

        SimpleDateFormat sd1 = new SimpleDateFormat("dd-MM-yyyy");
        String datumPocetkaTxt1 = "20-3-2000";
        Date date11 = null;
        try {
            date11 = sd.parse(datumPocetkaTxt1);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String datumZavrsetkaTxt1 = "21-3-2000";

        Date date21 = null;
        try {
            date21 = sd.parse(datumPocetkaTxt1);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Aranzman a1 = new Aranzman( "aa", "bb", date11, date21, 200);
        Database.getDatabaseB().dodajAranzmanDB(a1);
       
         
         Klijent k = new Klijent("Andrijana", 1, "Jovanovic", "12483292384", "Cuprija");
         Rezervacija r = new Rezervacija(a1, 1, 2, k);
         Database.getDatabaseB().getListaRezervacija().add(r);

        prikaziOpcije();

    }

    public static void opcijeTuristickeAgencije() {

    }

    public static int prikaziOpcije() {
        System.out.println();
        System.out.println("-----------Opcije Klijenta-----------");
        System.out.println(" 1. Klijent");
        System.out.println(" 2. Koordinator");
        System.out.println(" 3. KRAJ");
        int opcija = 3;
        boolean prolaz = false;

        while (!prolaz) {
            try {
                System.out.print("Unesite broj opcije: ");
                opcija = sc.nextInt();
                if (opcija == 3 || opcija == 1 || opcija == 2) {
                    prolaz = true;
                    if (opcija == 1) {
                        prikaziOpcijeKlijenta();
                    } else if (opcija == 2) {
                        prikaziOpcijeKoordinatora();
                    }
                } else {
                    throw new OpcijaException("Odaberite validnu opciju");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Mora biti broj kao opcija");
                sc.next();
            } catch (OpcijaException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return opcija;

    }

    public static int prikaziOpcijeKlijenta() {
        System.out.println();
        Klijent k = new Klijent("Andrijana", 1, "Jovanovic", "12483292384", "Cuprija");
        System.out.println("----------- Opcije -----------");
        System.out.println(" 1. Pregled aranzmana");
        System.out.println(" 2. Pregled rezervacija");
        System.out.println(" 3. KRAJ");
        int opcija = 3;

        boolean prolaz = false;

        while (!prolaz) {
            try {
                System.out.print("Unesite broj opcije: ");
                opcija = sc.nextInt();

                int idAranzmana = 0;
                Aranzman ar = null;              
                
                if (opcija == 3 || opcija == 1 || opcija == 2) {
                    prolaz = true;
                    if (opcija == 1) {
                        KlijentUI.otvoriStranicu();
                        
                        System.out.println("");
                        System.out.println("Da li zelite detaljan pregled rezervacije?");
                        String detaljno = "";

                        sc.nextLine();
                        detaljno = sc.nextLine();
                        System.out.println();
                        if (detaljno.equalsIgnoreCase("da")) {
                            System.out.println("Unesite id aranzmana: ");
                            idAranzmana = sc.nextInt();
                            KordinatorController.detaljanPrikazAranzmana(idAranzmana);
                            
                            for (Aranzman a : Database.getDatabaseB().getListaAranzmana()) {
                                if (a.getId() == idAranzmana) {
                                    ar = a;
                                }
                            }
                           
                        }

                        System.out.println("Da li zelite da rezervisete?");
                        String rezervacija = "";

                        sc.nextLine();
                        rezervacija = sc.nextLine();
                        System.out.println();
                        if (rezervacija.equalsIgnoreCase("da")) {

                            System.out.println("Broj soba: ");
                            int soba = sc.nextInt();
                            System.out.println("Broj osoba: ");
                            int osoba = sc.nextInt();

                          
                            KordinatorController.potvrdiRezervaciju(ar, k, soba, osoba);

                        }

                    } else if (opcija == 2) {

                        System.out.println(KordinatorController.vratiRezervacijeKlijenta(k));

                        String dodajJos = "";
                        String otkazi = "";
                        System.out.println("Zelite li pregled pojedinacne rezervacije?");
                        do {
                            sc.nextLine();
                            dodajJos = sc.nextLine();
                            System.out.println();
                            if (dodajJos.equalsIgnoreCase("da")) {
                                System.out.println("Unesite id rezervacije: ");
                                int idRezervacije = sc.nextInt();
                                KordinatorController.vratiPojedinacnuRezervaciju(idRezervacije);
                                System.out.println("Otkazi? da/ne");
                                sc.nextLine();
                                otkazi = sc.nextLine();
                                if (otkazi.equalsIgnoreCase("da")) {
                                    KordinatorController.otkaziRezervaciju(idRezervacije);
                                }
                            }
                        } while (dodajJos.equalsIgnoreCase("da"));
                    }
                } else {
                    throw new OpcijaException("Odaberite validnu opciju");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Mora biti broj kao opcija");
                sc.next();
            } catch (OpcijaException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return opcija;
    }

    public static int prikaziOpcijeKoordinatora() {
        System.out.println();
        System.out.println("----------- Opcije Koordinatora -----------");
        System.out.println(" 1. Dodavanje aranzmana");
        System.out.println(" 2. Izmena aranzmana");
        System.out.println(" 3. Brisanje aranzmana");
         System.out.println(" 0. KRAJ");
        int opcija = 0;
        boolean prolaz = false;

        while (!prolaz) {
            try {
                System.out.print("Unesite broj opcije: ");
                opcija = sc.nextInt();
                if (opcija == 3 || opcija == 1 || opcija == 2 || opcija == 0) {
                    prolaz = true;
                    if(opcija == 1){
                        KoordinatorUI.otvoriStranicuKoordinator();
                        
                    }
                } else {
                    throw new OpcijaException("Odaberite validnu opciju");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Mora biti broj kao opcija");
                sc.next();
            } catch (OpcijaException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return opcija;
    }

}
