
package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 *Tähän toteutetaan linkitetty lista
 *Tässä työssä LinkitettyLista listaa verkon solmuja.
 * TEhdään linkitetty lista siten, että suurimman arvoiset solmut tulevat listassa
 * ensimmäisenä. Listan ensimmäinen eli top nodi on listalle ensimmäisenä annettu 
 * SolmuNode ja se ei siirry enää listassa arvostaan huolimatta.
 */
public class LinkitettyLista {
    
   SolmuNode top;
   
   public LinkitettyLista(Solmu topSolmu){
       this.top = new SolmuNode(topSolmu);
   }
   public SolmuNode getNodeTop(){
       return top;
   }
   
   public void add(Solmu solmu){
       this.add(new SolmuNode(solmu));
   }
   
   /**
    * Muokataan vielä niin että lisää noden suuruusjärjestyksessä oikealle paikalle.
    * Tällöin lisäämisen aikavaativuus muuttuu lineaariseksi listan pituuden suhteen.
   **/
   public void add(SolmuNode uusiNodi){
       SolmuNode seuraava = this.top.seuraava();
       this.top.asetaSeuraava(uusiNodi);
       uusiNodi.asetaSeuraava(seuraava);
   }
   
   public Solmu getSolmuOnTop(){
       return top.getSolmu();
   }
   
   
}
