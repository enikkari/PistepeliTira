/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pistepeli_tira.Algoritmi;

import pistepeli_tira.LinkitettyLista.LinkitettyLista;
import pistepeli_tira.LinkitettyLista.Pino;
import pistepeli_tira.LinkitettyLista.SolmuNode;
import pistepeli_tira.verkko.*;

/**
 * Algoritmi, joka pelaa pistepeliä. Toiminta perustuu topologiseen
 * järjestämiseen.
 */
public class TopoAlgoritmi {

    Verkko verkko;
    int[] kayty;//0:'valkoinen' ; 1:'harmaa' ; 2:'musta'
    Pino pino;
    
    int[] pisteSaalis;
    int[] reitti;//solmun indeksiin talletetaan mistä solmusta siihen tultiin
    
    int parasPisteSaalis;
    LinkitettyLista parasReitti;

    public TopoAlgoritmi(Verkko verkko) {
        this.verkko = verkko;
        this.kayty = new int[verkko.getSolmuja()];
        this.pisteSaalis = jokaisenSolmunSaldoOmaPistemaara(verkko.getSolmuja());
        this.reitti = teeTaulukkoJossaKaikkiLukua(-1,verkko.getSolmuja());
        this.parasPisteSaalis =0;

        this.pino = this.topoJarjestaAll();
        this.etsiPainavinReitti();
        tulkitseParasReittiJaPistearvo();
    }
    private int[] jokaisenSolmunSaldoOmaPistemaara(int koko){
        int[] uusiTaulukko = new int[koko];
        for(int i=0; i< koko; i++){
            uusiTaulukko[i]=verkko.getSolmuIdeksissa(i).getPistearvo();
        }
        return uusiTaulukko;
    }
    
    private int[] teeTaulukkoJossaKaikkiLukua(int lukua, int koko){
        int[] uusiTaulukko = new int[koko];
        for(int i=0; i< koko; i++){
            uusiTaulukko[i]=lukua;
        }
        return uusiTaulukko;
    }

    /**
     * luo pinon, jossa solmut ovat topologisessa järjestyksessä
     */
    private Pino topoJarjestaAll() {
        
        Pino pino = new Pino();
        for (int i : kayty) {
            if (i == 0) {
                DFSvisitTopo(i, pino);
            }
        }
        return pino;
    }

    private void DFSvisitTopo(int solmunIndeksi, Pino pino) {
        kayty[solmunIndeksi] = 1; //värjättän solmu 'harmaaksi'
        LinkitettyLista vierus = verkko.getVierus(solmunIndeksi);
        SolmuNode missa = vierus.getNodeTop().seuraava();

        while (missa != null) {
            int solmussa = missa.getSolmu().indeksi();
            if (this.kayty[solmussa] == 0) {
                DFSvisitTopo(solmussa, pino);
            }
            missa = missa.seuraava();
        }

        kayty[solmunIndeksi] = 2; //värjätään solmu 'mustaksi'
        pino.push(verkko.getSolmuIdeksissa(solmunIndeksi));//ja lisätään se pinoon
    }

    /**
     * Metodi käsittelee verkon solmut topologisessa järjstyksessä ja päivittää
     * pisteSaalis-taulukkoon painavimman reitin solmuun. Solmut siis käsitellään
     * sellaisessa järjestyksessä, että jo käsitellyihin silmuihin ei osoita
     * enää nuolia myöhemmin käsitellyistä solmuista eikä niiden pistesaldo siis
     * enää muutu.
     */
    private void etsiPainavinReitti() {
        while (!this.pino.isEmpty()) {
            //u->v
            Solmu u = this.pino.pop();
            SolmuNode v = verkko.getVierus(u.indeksi()).getNodeTop().seuraava();
            
            while (v != null) {
                relax(u.indeksi(), v.getSolmu().indeksi());
                v = v.seuraava();
            }
        }

    }

    private void relax(int u, int v) {
        int vPistearvo = verkko.getSolmuIdeksissa(v).getPistearvo();
        if (pisteSaalis[v] < pisteSaalis[u] + vPistearvo) {
            pisteSaalis[v] = pisteSaalis[u] + vPistearvo;
            reitti[v]=u;
        }
    }
    
    private void tulkitseParasReittiJaPistearvo(){
        
        int paras =0;
        int viimeinenSolmuParhaassaReitissä = -1;
        for(int i =0; i<this.pisteSaalis.length; i++){
            if(pisteSaalis[i]>paras){
                paras = pisteSaalis[i];
                viimeinenSolmuParhaassaReitissä=i;
            }
        }
        
        this.parasPisteSaalis=paras;
        LinkitettyLista parasReitti = new LinkitettyLista(verkko.getSolmuIdeksissa(viimeinenSolmuParhaassaReitissä));
        int missa = viimeinenSolmuParhaassaReitissä;
        
        while(this.reitti[missa] != -1){
            //lähtösolmuun ei tule kaarta mistään, joten se on taulukossa edelleen
            //alkuperäisellä arvolla -1
            missa = reitti[missa];
            Solmu lisattava = verkko.getSolmuIdeksissa(missa);
            parasReitti.addOnTop(lisattava);
            
        }
        this.parasReitti=parasReitti;
        
    }
    /**
     * Testauskäyttöön. Sitä varten, että voidaan tarkistaa topologisen 
     * järjestämisen toimivuutta.
     */
    public Pino getTopoPino(){
        this.kayty = new int[verkko.getSolmuja()];
        return this.topoJarjestaAll();
    }
    public int[] getReitti(){
        return this.reitti;
    }
 
    /**
     *  palauttaa tulokset stringinä
     */
    public String tulokset(){
        String reitti = "";
        SolmuNode missa = this.parasReitti.getNodeTop();
        reitti+=missa.toString();
        missa = missa.seuraava();
        while(missa != null){
            reitti+="->"+missa.toString();
            missa=missa.seuraava();
        }
        return "Paras reitti oli "+reitti + ", ja sen arvo oli "+this.parasPisteSaalis;
    }
    

}
