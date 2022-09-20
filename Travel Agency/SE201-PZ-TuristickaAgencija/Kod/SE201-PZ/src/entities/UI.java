/** *********************************************************************
 * Module:  UI.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class UI
 ********************************************************************** */
package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class UI {

    protected static String lokacijaTxt;

    protected static String smestajTxt;

    protected static String datumPocetkaTxt;

    protected static String datumZavrsetkaTxt;

    public static void prikaziPoruku(String poruka) {
        System.out.println(poruka);
    }

    

}
