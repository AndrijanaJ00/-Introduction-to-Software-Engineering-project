/** *********************************************************************
 * Module:  Klijent.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class Klijent
 ********************************************************************** */
package entities;

import java.util.*;

/**
 * @pdOid 2ec285f3-d761-4c1f-ba61-a6d8d2c99498
 */
public class Klijent {

    /**
     * @pdOid ab0d7093-9297-4e2c-9548-565eed346139
     */
    private String ime;
    /**
     * @pdOid 839e1f95-00e3-4b8c-a957-1f56bfe33d90
     */
    private int id;
    private String prezime;
    /**
     * @pdOid 58ca898a-b0f7-457f-b3e4-bfdc3475f8d1
     */
    private String jmbg;
    /**
     * @pdOid 8bbf225b-6f4e-4bb6-9a38-5b885ba4aee2
     */
    private String adresa;

    /**
     * @pdRoleInfo migr=no name=Rezervacija assc=Association_2
     * coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition
     */
    public static List<Rezervacija> rezervacijaLista = new ArrayList<>();

    /**
     * @pdOid cab8d986-8745-4462-a7a3-aed664caf6f4
     */
    public Klijent() {
        // TODO: implement
    }

    public Klijent(String ime, int id, String prezime, String jmbg, String adresa) {
        this.ime = ime;
        this.id = id;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    /**
     * @pdOid c8910016-4c2d-4ec2-a2c4-2882dfe596c3
     */
    public String getime() {
        return ime;
    }

    /**
     * @param newIme
     * @pdOid 0a46dafe-9b42-4ad5-bf17-cc46ce8451c9
     */
    public void setime(String newIme) {
        ime = newIme;
    }

    /**
     * @pdOid 9740e77a-08c2-409f-b7ea-71cf6bf14925
     */
    public String getprezime() {
        return prezime;
    }

    /**
     * @param newPrezime
     * @pdOid e076a99a-cbba-4f2e-95d3-eb4a464720ac
     */
    public void setprezime(String newPrezime) {
        prezime = newPrezime;
    }

    /**
     * @pdOid 59559ba7-e843-4e92-8257-dd7c995ecdec
     */
    public String getjmbg() {
        return jmbg;
    }

    /**
     * @param newJmbg
     * @pdOid 06892510-83a7-46e7-94f8-46c03261f3f9
     */
    public void setjmbg(String newJmbg) {
        jmbg = newJmbg;
    }
    
    public String getadresa() {
        return adresa;
    }

    public void setadresa(String newAdresa) {
        adresa = newAdresa;
    }

    public java.util.List<Rezervacija> getRezervacijaLista() {
        if (rezervacijaLista == null) {
            rezervacijaLista = new java.util.ArrayList<Rezervacija>();
        }
        return rezervacijaLista;
    }

    public java.util.Iterator getIteratorRezervacijaLista() {
        if (rezervacijaLista == null) {
            rezervacijaLista = new java.util.ArrayList<Rezervacija>();
        }
        return rezervacijaLista.iterator();
    }

    /**
     * @pdGenerated default setter
     * @param newRezervacijaLista
     */
    public void setRezervacijaLista(java.util.List<Rezervacija> newRezervacijaLista) {
        removeAllRezervacijaLista();
        for (java.util.Iterator iter = newRezervacijaLista.iterator(); iter.hasNext();) {
            addRezervacijaLista((Rezervacija) iter.next());
        }
    }

    /**
     * @pdGenerated default add
     * @param newRezervacija
     */
    public void addRezervacijaLista(Rezervacija newRezervacija) {
        if (newRezervacija == null) {
            return;
        }
        if (this.rezervacijaLista == null) {
            this.rezervacijaLista = new java.util.ArrayList<Rezervacija>();
        }
        if (!this.rezervacijaLista.contains(newRezervacija)) {
            this.rezervacijaLista.add(newRezervacija);
            newRezervacija.setKlijent(this);
        }
    }

    /**
     * @pdGenerated default remove
     * @param oldRezervacija
     */
    public void removeRezervacijaLista(Rezervacija oldRezervacija) {
        if (oldRezervacija == null) {
            return;
        }
        if (this.rezervacijaLista != null) {
            if (this.rezervacijaLista.contains(oldRezervacija)) {
                this.rezervacijaLista.remove(oldRezervacija);
                oldRezervacija.setKlijent((Klijent) null);
            }
        }
    }

    /**
     * @pdGenerated default removeAll
     */
    public void removeAllRezervacijaLista() {
        if (rezervacijaLista != null) {
            Rezervacija oldRezervacija;
            for (java.util.Iterator iter = getIteratorRezervacijaLista(); iter.hasNext();) {
                oldRezervacija = (Rezervacija) iter.next();
                iter.remove();
                oldRezervacija.setKlijent((Klijent) null);
            }
        }
    }
    
    public static void dodajRezervaciju(Rezervacija rezervacija) {
        rezervacijaLista.add(rezervacija);
    }
    
    public List<Rezervacija> klijentRezervacije() {
       return this.rezervacijaLista;
   }

    @Override
    public String toString() {
        return "ime: " + ime + ", prezime: " + prezime + ", jmbg: " + jmbg;
    }
    

}
