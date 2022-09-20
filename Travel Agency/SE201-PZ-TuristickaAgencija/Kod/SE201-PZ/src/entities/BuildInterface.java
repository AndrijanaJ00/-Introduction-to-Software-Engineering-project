/***********************************************************************
 * Module:  BuildInterface.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Interface BuildInterface
 ***********************************************************************/
package entities;
import java.util.*;

/** @pdOid 1315b1e9-b222-4500-9961-a4bd201f8498 */
public interface BuildInterface {
   /** @param lokacija
    * @pdOid 1d1ac922-eb17-4d58-a998-fe22811993a4 */
   void addLokacija(String lokacija);
   /** @param smestaj
    * @pdOid 812fc34f-4599-48cf-8555-fbbded6f2ef3 */
   void addSmestaj(String smestaj);
   /** @param datum
    * @pdOid ac46697d-2fb4-4297-bf2e-a7047109cca3 */
   void addDatumPocetka(java.util.Date datum);
   /** @param datum
    * @pdOid 1ecee38a-7aaa-47d3-a37d-0438839fd9f9 */
   void addDatumZavrsetka(java.util.Date datum);
   /** @param cena
    * @pdOid d73fe049-3f16-4bc3-9f60-34294f81b5cf */
   void addCena(double cena);
   /** @pdOid cbfa200b-5d9a-4c96-9f4a-c17d60e87400 */
   Aranzman vratiAranzman();

    void addID(int id);
}