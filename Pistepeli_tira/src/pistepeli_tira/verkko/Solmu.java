package pistepeli_tira.verkko;

import java.util.Comparator;

/**
 *Solmu on alkio verkossa. Solmulla on pistearvo ja nimi.
 */
public class Solmu implements Comparator{
    private String nimi;
    private int pistearvo;
    private int indeksi; //indeksöinnin helpottamiseksi
    
    /*
    Luo 0 arvoisen solmun
    */
    public Solmu(String nimi){
       this.nimi = nimi;
       this.pistearvo = 0;
       this.indeksi = -1;
    }
    
    
    /*
    Luo halutun arvoisen solmun 
    */
    public Solmu(String nimi, int pistearvo){
       this.nimi = nimi;
       this.pistearvo = pistearvo;
       this.indeksi = -1;
    }
    /*
    Luo nimettömän halutun arvoisen solmun 
    */
    public Solmu(int pisteArvo){
       this.nimi = null;
       this.pistearvo = pisteArvo;
       this.indeksi = -1;
    }
    
    public int getPistearvo(){
        return this.pistearvo;
    }
    public String getNimi(){
        return this.nimi;
    }
    public void asetaIndeksi(int indeksi){
        this.indeksi=indeksi;
    }
    /**
     * Palauttaa solmulle määrätyn indeksin. Verkko indeksöi solmut automaattisesti.
     * Alunperin solmun indeksi on -1, jos sitä ei ole erikseen aseteta.
     */
    
    public int indeksi(){
        return this.indeksi;
    }
    
    @Override
    public String toString(){
        return this.nimi + ":" + this.pistearvo;
    }
//    
    @Override
    public int compare(Object o1, Object o2) {
        Solmu s1 = (Solmu)o1;
        Solmu s2 = (Solmu)o2;
     if(s1.getPistearvo() < s2.getPistearvo()){
         return -1;
     }else if(s1.getPistearvo() == s2.getPistearvo()){
         return 0;
     }else{
         return 1;
     }
     
    }

}
