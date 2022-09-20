/** *********************************************************************
 * Module:  Aranzman.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class Aranzman
 ********************************************************************** */
package entities;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @pdOid 56337158-b704-4332-9135-673f809c159d
 */
public class Aranzman {

   private int id = 0;
    
    private String lokacija;
     
    private String smestaj;
   
    private Date datumPocetka;
    
    private Date datumZavrsetka;
    
    private double cena;

  
    public void dodaj(String sledece) {
        // TODO: implement
    }
 
    public Aranzman() {
        // TODO: implement
    }

    public Aranzman(String lokacija, String smestaj, Date datumPocetka, Date datumZavrsetka, double cena) {
         this.id++;
        this.lokacija = lokacija;
        this.smestaj = smestaj;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.cena = cena;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(String smestaj) {
        this.smestaj = smestaj;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return  "id: " + id + " lokacija: " + lokacija + ", smestaj: " + smestaj + 
                ", datumPocetka: " + new SimpleDateFormat().format(datumPocetka) + 
                ", datumZavrsetka: " +  new SimpleDateFormat().format(datumZavrsetka) + 
                ", cena: " + cena;
    }
   
}
