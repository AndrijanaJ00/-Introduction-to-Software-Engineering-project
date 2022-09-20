/***********************************************************************
 * Module:  Builder.java
 * Author:  Andrijana Jovanovic
 * Purpose: Defines the Class Builder
 ***********************************************************************/
package entities;
import java.util.*;

/** @pdOid 315157bc-2fd7-4342-9107-1bd4d7e82cee */
public class Builder implements BuildInterface {
   /** @pdRoleInfo migr=no name=Aranzman assc=Association_4 coll=java.util.Collection impl=java.util.ArrayList mult=1..* type=Aggregation */
   public java.util.Collection<Aranzman> listaAranzmana;
    private Aranzman aranzman = new Aranzman();
   
   /** @pdGenerated default getter */
   public java.util.Collection<Aranzman> getListaAranzmana() {
      if (listaAranzmana == null)
         listaAranzmana = new java.util.ArrayList<Aranzman>();
      return listaAranzmana;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorListaAranzmana() {
      if (listaAranzmana == null)
         listaAranzmana = new java.util.ArrayList<Aranzman>();
      return listaAranzmana.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newListaAranzmana */
   public void setListaAranzmana(java.util.Collection<Aranzman> newListaAranzmana) {
      removeAllListaAranzmana();
      for (java.util.Iterator iter = newListaAranzmana.iterator(); iter.hasNext();)
         addListaAranzmana((Aranzman)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAranzman */
   public void addListaAranzmana(Aranzman newAranzman) {
      if (newAranzman == null)
         return;
      if (this.listaAranzmana == null)
         this.listaAranzmana = new java.util.ArrayList<Aranzman>();
      if (!this.listaAranzmana.contains(newAranzman))
         this.listaAranzmana.add(newAranzman);
   }
   
   /** @pdGenerated default remove
     * @param oldAranzman */
   public void removeListaAranzmana(Aranzman oldAranzman) {
      if (oldAranzman == null)
         return;
      if (this.listaAranzmana != null)
         if (this.listaAranzmana.contains(oldAranzman))
            this.listaAranzmana.remove(oldAranzman);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllListaAranzmana() {
      if (listaAranzmana != null)
         listaAranzmana.clear();
   }

   @Override
    public void addLokacija(String lokacija) {
      aranzman.setLokacija(lokacija);
    }

    @Override
    public void addSmestaj(String smestaj) {
        aranzman.setSmestaj(smestaj);
    }

    @Override
    public void addDatumPocetka(Date datum) {
        aranzman.setDatumPocetka(datum);
    }

    @Override
    public void addDatumZavrsetka(Date datum) {
        aranzman.setDatumZavrsetka(datum);
    }

    @Override
    public void addCena(double cena) {
        aranzman.setCena(cena);
    }

    @Override
    public Aranzman vratiAranzman() {
      return  aranzman;
    }

    @Override
    public void addID(int id) {
        aranzman.setId(id);
    }

}