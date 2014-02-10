/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pistepeli_tira;

import java.util.Scanner;
import pistepeli_tira.verkko.Solmu;
import pistepeli_tira.verkko.Verkko;

/**
 *
 * @author eevanikkari
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner hemmo = new Scanner(System.in);
        System.out.println("Kuinka monta solmua verkkoon?");
        int solmuja = hemmo.nextInt();
        Solmu[] solmut =new Solmu[solmuja];
        System.out.println("Anna ensin solmun nimi, sitten pistearvo");
        for(int i = 0; i<solmuja; i++){
            String nimi =hemmo.nextLine();
            int pistearvo =hemmo.nextInt();
            solmut[i] = new Solmu(nimi, pistearvo);
        }
        Verkko uusiVerkko = new Verkko(solmut);
        //sit kaaret
        
    }
    
}
