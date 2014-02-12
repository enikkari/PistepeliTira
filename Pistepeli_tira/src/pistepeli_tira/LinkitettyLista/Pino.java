/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 *
 * @author eevanikkari
 */
public class Pino {
    
    SolmuNode Top;
    
    public Pino(){
        this.Top = null;
    }
    
    public void push(Solmu solmu){
        SolmuNode exTop = this.Top;
        SolmuNode uusiTop = new SolmuNode(solmu);
        uusiTop.asetaSeuraava(exTop);
        this.Top = uusiTop;
    }
    
    public Solmu pop(){
        if(this.Top == null){
            return null;
        }
        SolmuNode exTop = this.Top;
        this.Top = exTop.seuraava();
        return exTop.getSolmu();
    }
    
    public boolean isEmpty(){
        if(this.Top==null){
            return true;
        }
        return false;
    }
}
