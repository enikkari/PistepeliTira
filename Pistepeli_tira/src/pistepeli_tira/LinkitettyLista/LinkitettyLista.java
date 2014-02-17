
package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 * Yhteen suuntaan linkitetty lista.
 * Tällä linkitetyllä listalla on 'tunnus-node' eli top-node, joka annetaan listan konstruktorille ja joka säilyy paikallaan, kun käytetään add-metodia. 
 * Käytännön syistä listalla on myös addOnTop-metodi, jolla lisätään uusi solmu listan topiksi ja vanha top sen seuraajaksi.
 * LinkitetynListan metodit, haku- ja pituus metodeja lukuunottamatta, toimivat ajassa O(1).
 * Hakumetodit search ja searchNode toimivat lineaarisessa ajassa
 */
public class LinkitettyLista {
    
   SolmuNode top;
   
   public LinkitettyLista(Solmu topSolmu){
       this.top = new SolmuNode(topSolmu);
   }
   
   /**
    * Palauttaa listan tunnus noden eli ensimmäisen noden 
    */
   public SolmuNode getNodeTop(){
       return top;
   }
   
   /**
    * Lisää listaan alkion top-noden perään.
    * top-node ei vaihda paikkaa.
   **/
   public void add(Solmu solmu){
       SolmuNode uusiNodi = new SolmuNode(solmu);
       SolmuNode seuraava = this.top.seuraava();
       this.top.asetaSeuraava(uusiNodi);
       uusiNodi.asetaSeuraava(seuraava);
   }
   /**
    * Palauttaa listan tunnus solmun eli top-solmun
    */
   
   public Solmu getSolmuOnTop(){
       return top.getSolmu();
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
   
   /**
    * palauttaa noden, jossa kyseinen solmu on
    */
   public SolmuNode searchNode(Solmu solmu){
       SolmuNode missaOllaan= this.top;
       while(missaOllaan != null){
           if(missaOllaan.getSolmu() == solmu){
               return missaOllaan;
           }
           missaOllaan = missaOllaan.seuraava();
       }
       return null;
   }
   /**
    * palauttaa kuinka monta nodea listassa on, top-node mukaan lukien. Tämä metodi
    * on lähinnä testaamista varten.
    */
   public int listanPituus(){
       SolmuNode missa = this.top;
       int pituus = 0;
       while(missa != null){
           pituus++;
           missa = missa.seuraava();
       }
       return pituus;
   }
   /**
    * Lisää solmun ensimmäiseksi solmuksi, sen sijaan, että lisäisi sen top-noden perään.
    */
   public void addOnTop(Solmu solmu){
       SolmuNode vanhaTop = this.top;
       SolmuNode uusiNode = new SolmuNode(solmu);
       uusiNode.asetaSeuraava(vanhaTop);
       this.top=uusiNode;
   }
   
}
