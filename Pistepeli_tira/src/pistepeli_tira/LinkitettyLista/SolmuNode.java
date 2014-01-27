
package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 *Tähän toteutetaan linkitetyn listan olio. 

 */
public class SolmuNode {
    private Solmu solmu;
    private SolmuNode seuraava;
    
    public SolmuNode(Solmu olio){
        this.solmu = olio;
        this.seuraava=null;
    }
    
    public void asetaSeuraava(SolmuNode seuraava){
        this.seuraava = seuraava;
    }
    
    public void asetaSeuraava(Solmu seuraava){
        this.seuraava = new SolmuNode(seuraava);
    }
    
    public Solmu getSolmu(){
        return this.solmu;
    }
    
    public SolmuNode seuraava(){
        return this.seuraava;
    }
}
