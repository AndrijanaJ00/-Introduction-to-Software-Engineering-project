/** *********************************************************************
 * Module:  Database.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class Database
 ********************************************************************** */
package entities;

import java.util.*;

public class Database {

    private static Database database;
    private List<Aranzman> listaAranzmana = new ArrayList<>();
    private List<Rezervacija> listaRezervacija = new ArrayList<>();

    private Database() {

    }

    public static Database getDatabaseB() {
        if (database == null) {
            database = new Database();
        }
        return database;

    }
    
    public void dodajRezervacijuDB(Rezervacija rezervacija) {
        listaRezervacija.add(rezervacija);
    }

    public void dodajAranzmanDB(Aranzman aranzman) {
        listaAranzmana.add(aranzman);
    }

    public void azurirajRezervaciju(Rezervacija rezervacija, int brojSoba, int brojOsoba, String status) {
        for (Rezervacija r : listaRezervacija) {
            if (r == rezervacija) {
                rezervacija.setBrojOsoba(brojOsoba);
                rezervacija.setBrojSoba(brojSoba);
                rezervacija.setStatus(status);
            }
        }
    }

    public void obrisiRezervaciju(Rezervacija rezervacija) {
        listaRezervacija.remove(rezervacija);
    }

    public void azurirajAranzman(Aranzman aranzman, String lokacija, String smestaj, Date datumPoceka, Date datumZavrsetka, double cena) {
        for (Aranzman a : listaAranzmana) {
            if (a == aranzman) {
                aranzman.setLokacija(lokacija);
                aranzman.setDatumPocetka(datumPoceka);
                aranzman.setDatumZavrsetka(datumZavrsetka);
                aranzman.setSmestaj(smestaj);
                aranzman.setCena(cena);
            }
        }
    }
    
    public List<Rezervacija> vratiRezervacije() {
       return this.listaRezervacija;
   }
    
    public List<Aranzman> vratiAranzmane() {
       return this.listaAranzmana;
   }

    public void obrisiAranzman(Aranzman aranzman) {
        listaAranzmana.remove(aranzman);
    }

    public List<Aranzman> getListaAranzmana() {
        return listaAranzmana;
    }

    public void setListaAranzmana(List<Aranzman> listaAranzmana) {
        this.listaAranzmana = listaAranzmana;
    }

    public List<Rezervacija> getListaRezervacija() {
        return listaRezervacija;
    }

    public void setListaRezervacija(List<Rezervacija> listaRezervacija) {
        this.listaRezervacija = listaRezervacija;
    }

    
    
}
