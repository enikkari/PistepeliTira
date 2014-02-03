/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pistepeli_tira.Algoritmi;

import pistepeli_tira.LinkitettyLista.LinkitettyLista;
import pistepeli_tira.LinkitettyLista.SolmuNode;
import pistepeli_tira.verkko.Solmu;
import pistepeli_tira.verkko.Verkko;

/**
 *
 * Algoritmi, joka käy dfs:llä läpi verkon ja pitää parhaana reittinä sitä,
 * josta saatiin eniten pisteitä umpikujaan tullessa. Ongelma: algoritmi ei osaa
 * jatkaa haraan, jos sen solmut on käsitelty aikaisemmin, vaikka periaattessa
 * se saisi jatkaa peliä?
 */
public class AlgoritmiDFS {

    Verkko verkko;
    int lahtosolmu;
    boolean[] kayty;
    //int[] parasReitti
    int parasPistemaara;

    public AlgoritmiDFS(Verkko verkko, int lahtoSolmunIndeksi) {
        this.verkko = verkko;
        this.kayty = new boolean[verkko.getSolmuja()];
        this.parasPistemaara = 0;
        if (lahtoSolmunIndeksi < verkko.getSolmuja() && lahtoSolmunIndeksi > 0) {
            this.lahtosolmu = lahtoSolmunIndeksi;
            this.DFS(lahtoSolmunIndeksi, 0);
        } else {
            System.out.println("Antamasi luku ei ");
        }
    }

    private void DFS(int lahtoSolmunIndeksi, int keratytPisteet) {
        LinkitettyLista vierus = this.verkko.getVierus(lahtoSolmunIndeksi);

        //top-nodi on verkossa se solmu, jonka vierusta käsitellään.
        //siksi aloitetaan sitä seuraavasta nodesta
        SolmuNode missaMennaan = vierus.getNodeTop().seuraava();

        this.kayty[lahtoSolmunIndeksi] = true;

        while (missaMennaan != null) {
            if (this.kayty[missaMennaan.getSolmunIndeksi()] == false) {
                
                this.kayty[missaMennaan.getSolmunIndeksi()] = true;
                int pisteita = keratytPisteet + missaMennaan.getSolmunPistearvo();
                if(pisteita > this.parasPistemaara){
                    this.parasPistemaara=pisteita;
                }
                
                DFS(missaMennaan.getSolmu().indeksi(), pisteita);
                
            }
            missaMennaan = missaMennaan.seuraava();
        }

    }

}
