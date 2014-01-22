package pistepeli_tira.verkko;

import java.util.Comparator;

/**
 *Solmu on alkio verkossa. Solmulla on pistearvo ja nimi.
 */
public class Solmu implements Comparator{
    private String nimi;
    private int pistearvo;
    
    /*
    Luo 0 arvoisen solmun
    */
    public Solmu(String nimi){
       this.nimi = nimi;
       this.pistearvo = 0;
    }
    
    /*
    Luo halutun arvoisen solmun
    */
    public Solmu(String nimi, int pistearvo){
       this.nimi = nimi;
       this.pistearvo = pistearvo;
    }
    
    public int getPistearvo(){
        return this.pistearvo;
    }
    public String getNimi(){
        return this.nimi;
    }
    
    @Override
    public String toString(){
        return this.nimi + ":" + this.pistearvo;
    }
    
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
