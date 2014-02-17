

package pistepeli_tira;

import java.util.Scanner;
import pistepeli_tira.Algoritmi.TopoAlgoritmi;
import pistepeli_tira.verkko.Solmu;
import pistepeli_tira.verkko.Verkko;

public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lukija = new Scanner(System.in);
        System.out.println("Luo verkko käsin:1" + '\n' + "Käytä valmista verkkoa:2" );
        if(lukija.nextInt()==2){
            System.out.println("Mikä verkoista? (int)");
            int mikaVerkko = lukija.nextInt();
            if(mikaVerkko==1){
                verkko1();
            }else if(mikaVerkko ==2){
                verkko2();
            }else if(mikaVerkko ==3){
                verkko3();
            }
        }else{
        System.out.println("Kuinka monta solmua verkkoon?");
        int solmuja = lukija.nextInt();
        Solmu[] solmut =new Solmu[solmuja];
        System.out.println("Anna ensin solmun nimi, sitten pistearvo (Solmut indeksöidään nollasta alkaen, lisäysjärjestyksessä)");
        for(int i = 0; i<solmuja; i++){
            String nimi =lukija.next();
            int pistearvo =lukija.nextInt();
            solmut[i] = new Solmu(nimi, pistearvo);
        }
        Verkko uusiVerkko = new Verkko(solmut);
        //sit kaaret
        System.out.println("Kuinka monta kaarta verkkoon?");
        int kaaria = lukija.nextInt();
        System.out.println("Käytä solmujen indeksöintiä lisätessäsi kaaria");
        for(int i = 0; i<kaaria; i++){
            int solmusta =lukija.nextInt();
            int solmuun =lukija.nextInt();
            uusiVerkko.lisaaKaari(solmusta, solmuun);
        }
        
        TopoAlgoritmi topo = new TopoAlgoritmi(uusiVerkko);
        System.out.println(topo.tulokset());
        }
    }
    
    public static void verkko3(){
        Verkko verkko3 = new Verkko(new Solmu[]{new Solmu("R",3), new Solmu("S",5),
                                                   new Solmu("T",2), new Solmu("X",3),
                                                   new Solmu("Y",4), new Solmu("Z",2)},
                                                   new int[][]{{0,1},{0,2},{1,2},{1,3},
                                                       {2,3},{2,4},{2,5},{3,4},{3,5},
                                                       {4,5}});
        TopoAlgoritmi topo = new TopoAlgoritmi(verkko3);
        System.out.println(topo.tulokset());
    }
    
    public static void verkko2(){
        Verkko verkko2 = new Verkko(new Solmu[]{new Solmu("A",70), new Solmu("B",10),
                                                   new Solmu("C",60), new Solmu("D",50),
                                                   new Solmu("E",30), new Solmu("F",50),
                                                   new Solmu("G",10), new Solmu("H",20), 
                                                    new Solmu("I",100)},
                                                   new int[][]{{0,1},{0,2},{0,3},
                                                       {2,4},{2,5},{6,5},
                                                       {6,7},{6,8},{7,8}});
        TopoAlgoritmi topo = new TopoAlgoritmi(verkko2);
        System.out.println(topo.tulokset());
    }
    
    public static void verkko1(){
        Verkko verkko1 = new Verkko(new Solmu[]{new Solmu("Alkaid",-2), new Solmu("Mizar",3),
                                                   new Solmu("Alioth",8), new Solmu("Megrez",-1),
                                                   new Solmu("Dubhe",10), new Solmu("Merak",1),
                                                   new Solmu("Phecda",5)},
                                                   new int[][]{{0,1},{1,2},{2,3},{3,4},
                                                                {3,6},{5,4},{5,6}});
        TopoAlgoritmi topo = new TopoAlgoritmi(verkko1);
        System.out.println(topo.tulokset());
    }
    
}
