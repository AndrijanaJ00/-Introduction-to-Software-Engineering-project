/** *********************************************************************
 * Module:  Rezervacija.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class Rezervacija
 ********************************************************************** */
package entities;

import java.util.*;

/**
 * @pdOid 2e0b0a7b-e36e-4452-b5c9-885f3014e850
 */
public class Rezervacija {
 
    private int id = 0;
    
    private int brojSoba;
 
    private int brojOsoba;
    
    private String status;
 
    public Aranzman aranzman;
     
    public Klijent klijent;

    public Rezervacija(Aranzman aranzman, int brojSoba, int brojOsoba, Klijent klijent) {
        this.id++;
        this.brojSoba = brojSoba;
        this.brojOsoba = brojOsoba;
        this.setStatus("rezervisano");
        this.aranzman = aranzman;
        this.klijent = klijent;
    }

    Rezervacija() {

    }

    public int getBrojSoba() {
        return brojSoba;
    }

    public void setBrojSoba(int brojSoba) {
        this.brojSoba = brojSoba;
    }

    public int getBrojOsoba() {
        return brojOsoba;
    }

    public void setBrojOsoba(int brojOsoba) {
        this.brojOsoba = brojOsoba;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman aranzman) {
        this.aranzman = aranzman;
    }

 
    
    @Override
    public String toString() {
        return "idRezervacija: " + id + ", Aranzman: " + aranzman +  ", brojSoba: " + brojSoba + ", brojOsoba: " + brojOsoba + ", status: " + status +  ", klijent: " + klijent + '}';
    }
 
   

}
