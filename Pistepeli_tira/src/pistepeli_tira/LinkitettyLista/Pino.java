/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 *Vanha kunnon pino. Tässä pinossa pinotaan Solmuja.
 */
public class Pino {
    
    SolmuNode Top;
    
    public Pino(){
        this.Top = null;
    }
    
    /**
     * Lisää Solmun pinon päällimmäiseksi.
     */
    public void push(Solmu solmu){
        SolmuNode exTop = this.Top;
        SolmuNode uusiTop = new SolmuNode(solmu);
        uusiTop.asetaSeuraava(exTop);
        this.Top = uusiTop;
    }
    /**
     * Palauttaa listan päällimäisen solmun ja poistaa sen pinosta.
     */
    public Solmu pop(){
        if(this.Top == null){
            return null;
        }
        SolmuNode exTop = this.Top;
        this.Top = exTop.seuraava();
        return exTop.getSolmu();
    }
    
    /**
     * Palauttaa true, jos pino on tyhjä.
     */
    public boolean isEmpty(){
        if(this.Top==null){
            return true;
        }
        return false;
    }
}
