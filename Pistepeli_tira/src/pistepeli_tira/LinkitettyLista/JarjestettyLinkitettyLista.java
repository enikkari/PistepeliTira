
package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 * Tätä luokkaa ei välttämättä käytetä lopullisessa toteutuksessa!
 *Tähän toteutetaan linkitetty lista
 *Tässä työssä LinkitettyLista listaa verkon solmuja.
 * Linkitetty lista siten, että suurimman arvoiset solmut tulevat listassa
 * ensimmäisenä. Listan ensimmäinen eli top nodi on listalle ensimmäisenä annettu 
 * SolmuNode ja se ei siirry enää listassa arvostaan huolimatta.
 */
public class JarjestettyLinkitettyLista {
    
   SolmuNode top;
   
   public JarjestettyLinkitettyLista(Solmu topSolmu){
       this.top = new SolmuNode(topSolmu);
   }
   public SolmuNode getNodeTop(){
       return top;
   }
   
   /**
    * Metodi lisää noden suuruusjärjestyksessä oikealle paikalle listassa.
    * Aikavaativuus on lineaarinen listan pituuden suhteen.
    * top-node ei kuitenkaan vaihda paikkaa, vaikka sen pistearvo olisi uutta pienempi
   **/
   public void add(Solmu solmu){
       SolmuNode uusiNodi = new SolmuNode(solmu);
//       SolmuNode seuraava = this.top.seuraava();
//       this.top.asetaSeuraava(uusiNodi);
//       uusiNodi.asetaSeuraava(seuraava);
       SolmuNode edeltaja = etsiSeuraavaksiSuurin(uusiNodi.getSolmunPistearvo());
       SolmuNode seuraaja = edeltaja.seuraava();
       edeltaja.asetaSeuraava(uusiNodi);
       uusiNodi.asetaSeuraava(seuraaja);
   }
   
   
   public Solmu getSolmuOnTop(){
       return top.getSolmu();
   }
   
   private SolmuNode etsiSeuraavaksiSuurin(int uudenNodenPistearvo){
       
       SolmuNode missaMennaan= top;
       while(missaMennaan.seuraava() != null){
           if(missaMennaan.seuraava().getSolmunPistearvo() <= uudenNodenPistearvo){
               return missaMennaan;
           }
           missaMennaan=missaMennaan.seuraava();
       }
       
       return missaMennaan;
   }
   
   public boolean search(Solmu solmu){
       SolmuNode missaOllaan= this.top;
       while(missaOllaan != null){
           if(missaOllaan.getSolmu() == solmu){
               return true;
           }
           missaOllaan = missaOllaan.seuraava();
       }
       return false;
   }
   
}
