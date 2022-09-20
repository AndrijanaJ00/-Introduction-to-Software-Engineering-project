/** *********************************************************************
 * Module:  Banka.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class Banka
 ********************************************************************** */
package entities;

import java.awt.image.BandCombineOp;
import java.util.*;

public class Banka {

    private static Banka banka;
    private static List<Kartica> listaKartica = new ArrayList<>();

    private Banka() {
        // TODO: implement
    }

    public static Banka getBanka() {
        if (banka == null) {
            banka = new Banka();
            // U svrhe testa
            listaKartica.add(new Kartica("1234", 1234));
        }
        return banka;
    }

    public static List<Kartica> getListaKartica() {
        return listaKartica;
    }

    public static void setListaKartica(List<Kartica> listaKartica) {
        Banka.listaKartica = listaKartica;
    }
    

    public boolean proveraKartice(String brKartice, int pin) {
        Kartica k = new Kartica(brKartice, pin);

        for (Kartica kartica : listaKartica) {
            if (k.getPin() == kartica.getPin()
                    && k.getBrojKartice().equals(kartica.getBrojKartice())) {
                return true;
            }
        }
        return false;
    }

    private static class Kartica {

        private String brojKartice;
        private int pin;

        public String getBrojKartice() {
            return brojKartice;
        }

        public void setBrojKartice(String brojKartice) {
            this.brojKartice = brojKartice;
        }

        public int getPin() {
            return pin;
        }

        public void setPin(int pin) {

            this.pin = pin;
        }

        public Kartica() {
        }

        public Kartica(String brojKartice, int pin) {
            this.brojKartice = brojKartice;
            this.pin = pin;
        }

    }

}
