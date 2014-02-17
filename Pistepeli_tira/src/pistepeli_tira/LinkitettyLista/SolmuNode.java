package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 * Linkitetyn listan ja pinon olio eli 'node'.
 */
public class SolmuNode {

    private Solmu solmu;
    private SolmuNode seuraava;

    public SolmuNode(Solmu solmu) {
        this.solmu = solmu;
        this.seuraava = null;
    }

    /**
     * Asettaa valmiin noden tämän noden seuraajaksi
     */
    public void asetaSeuraava(SolmuNode seuraava) {
        this.seuraava = seuraava;
    }

    /**
     * Luo uuden noden, joka viittaa annettuun solmuun, ja asettaa sen tämän
     * noden seuraajaksi
     */
    public void asetaSeuraava(Solmu seuraava) {
        this.seuraava = new SolmuNode(seuraava);
    }


    public Solmu getSolmu() {
        return this.solmu;
    }

    public int getSolmunPistearvo() {
        return this.solmu.getPistearvo();
    }

    public String getSolmunNimi() {
        return this.solmu.getNimi();
    }

    public SolmuNode seuraava() {
        return this.seuraava;
    }

    public int getSolmunIndeksi() {
        return this.solmu.indeksi();
    }
    
    @Override
    public String toString(){
        return this.solmu.toString();
    }
}
