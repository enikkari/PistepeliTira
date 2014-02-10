/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pistepeli_tira.Algoritmi;

import pistepeli_tira.LinkitettyLista.LinkitettyLista;
import pistepeli_tira.LinkitettyLista.Pino;
import pistepeli_tira.LinkitettyLista.SolmuNode;
import pistepeli_tira.verkko.Verkko;

/**
 *
 * @author eevanikkari
 */
public class TopoAlgoritmi {
    Verkko verkko;
    int[] kayty;//0:'valkoinen' ; 1:'harmaa' ; 2:'musta'
    Pino pino;
    
    int[] etaisyys;
    int[] reitti;
    
    
    public TopoAlgoritmi(Verkko verkko){
        this.verkko = verkko;
        this.kayty = new int[verkko.getSolmuja()];
        this.etaisyys = new int[verkko.getSolmuja()];
        this.reitti = new int[verkko.getSolmuja()];
        //tähän tarkastus, että verkko ei sisällä looppia?
        
        this.pino = this.topoJarjestaAll();
        
        
    }
    /**
    * luo pinon, jossa solmut ovat topologisessa järjestyksessä
    */
    private Pino topoJarjestaAll(){
        Pino pino = new Pino();
        for(int i : kayty){
            if(i==0){
            DFSvisitTopo(i, pino);
        }
        }
        return pino;
    }

    private void DFSvisitTopo(int solmunIndeksi, Pino pino){
        kayty[solmunIndeksi]=1; //värjättän solmu 'harmaaksi'
        LinkitettyLista vierus = verkko.getVierus(solmunIndeksi);
        SolmuNode missa = vierus.getNodeTop().seuraava();
        
        while(missa != null){
            int solmussa = missa.getSolmu().indeksi();
            if(this.kayty[solmussa] == 0){
                DFSvisitTopo(solmussa, pino);
            }
            missa= missa.seuraava();
        }
        
        kayty[solmunIndeksi]=2; //värjätään solmu 'mustaksi'
        pino.push(verkko.getSolmuIdeksissa(solmunIndeksi));//ja lisätään se pinoon
    }
    /**
     * Palauttaa topologisessa järjestyksessä olevan pinon algoritmille annetusta verkosta.
     * Testausta varten.
     */
    public Pino getPino(){
        return this.pino;
    }
    
}
