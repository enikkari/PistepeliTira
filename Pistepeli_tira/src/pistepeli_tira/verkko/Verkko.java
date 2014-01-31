

package pistepeli_tira.verkko;

import pistepeli_tira.LinkitettyLista.LinkitettyLista;

/**
 * Verkko
 */
public class Verkko {
    LinkitettyLista[] vierus;//
    int solmuja; //Kuinka monta solmua verkossa on
    int kaaria; //Kuinka monta kaarta verkossa on;
    
    /**
     * Luo verkon jossa ei ole vielä kaaria, vain solmut.
     * @param solmut 
     */
    public Verkko(Solmu[] solmut){
        this.kaaria=0;
        this.solmuja=solmut.length;
        this.vierus = new LinkitettyLista[solmut.length];
        for(int i =0; i<solmut.length; i++){
            LinkitettyLista lista = new LinkitettyLista(solmut[i]);
            this.vierus[i]=lista;
        }
    }

    /**
     * lisää kaari e->d solmujen indeksöinnin avulla
     */
    public void lisaaKaari(int e, int d){
        if(e>=0 && d>=0 && e<vierus.length && d<=vierus.length){
            this.vierus[e].add(this.vierus[d].getSolmuOnTop());
            this.kaaria++;
        }
    }
    /**
     * lisää useita kaaria solmujen indeksöinnin avulla
     */
    public void lisaaKaaret(int[][] kaaret){
        for(int[] kaari : kaaret){
            this.lisaaKaari(kaari[0], kaari[1]);
        }
    }
    /**
     * Indeksöinti alkaa nollasta. Jos i on liian suuri, palautetaan null.
     */
    public Solmu getSolmuIdeksissa(int i){
        if(i<vierus.length && i>=0){
        return vierus[i].getSolmuOnTop();
        }else{
            return null;
        }
    }
    /**
     * aikavaativuus O(|V|)
     * @param solmu
     * @return 
     */
    
    public int getMissaIndeksissaSolmuOn(Solmu solmu){
        for(int i =0; i<this.solmuja; i++){
            if(this.getSolmuIdeksissa(i) == solmu){
                return i;
            }
        }
        return -1;
    }
    
    public LinkitettyLista getVierus(int i){
        return this.vierus[i];
    }
    
    public int getKaaria(){
        return this.kaaria;
    }
    public int getSolmuja(){
        return this.solmuja;
    }
    
    
}
