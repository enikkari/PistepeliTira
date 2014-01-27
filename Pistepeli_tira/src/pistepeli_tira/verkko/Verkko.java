

package pistepeli_tira.verkko;

import pistepeli_tira.LinkitettyLista.LinkitettyLista;

/**
 * Verkko
 */
public class Verkko {
    LinkitettyLista[] vierus;//
    int solmuja; //Kuinka monta solmua verkossa on
    int kaaria; //Kuinka monta kaarta verkossa on;
    
//    /**
//    * Verkkolle annetaan parametreinä lista listoja, joissa indeksissä 0 on itse solmu
//    *ja lopuilla paikoilla solmut, joihin kyseisestä solmusta osoittaa kaari.
//    */
//    public Verkko(Solmu[][] solmut){
//        this.vierus = new LinkedList[solmut.length];
//        this.solmuja=solmut.length;
//        this.kaaria=0;
//        for(int i=0; i<solmut.length; i++){
//            LinkedList<Solmu> lista = new LinkedList<Solmu>();
//            this.kaaria =+ solmut[i].length-1;
//            lista.add(solmut[i][0]); //lopullisessa toteutuksessa ensimmäinen solmu on 'top'
//            for(int a =1; a<solmut[i].length; ){
//                lista.add(solmut[i][a]);
//            }
//            vierus[i]=lista;
//        }
//    }
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
//    /**
//     * lisää kaari e->d
//     * Jos solmuja ei ole verkossa, ei tehdä mitään.
//     */
//    public void lisaaKaari(Solmu e, Solmu d){
//        for(LinkedList lista : this.vierus){
//            if(lista.getFirst()==e){
//                lista.add(d);
//                this.kaaria++;
//                break;
//            }
//        }
//    }
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
    
    public int getKaaria(){
        return this.kaaria;
    }
    public int getSolmuja(){
        return this.solmuja;
    }
    
}
