
package pistepeli_tira.LinkitettyLista;

import pistepeli_tira.verkko.Solmu;

/**
 *Tähän toteutetaan linkitetty lista
 *Tässä työssä LinkitettyLista listaa verkon solmuja.
 * LinkitetynListan metodit, haku- ja pituus metodeja lukuunottamatta, toimivat ajassa O(1).
 * Hakumetodit search ja searchNode toimivat lineaarisessa ajassa
 */
public class LinkitettyLista {
    
   SolmuNode top;
   
   public LinkitettyLista(Solmu topSolmu){
       this.top = new SolmuNode(topSolmu);
   }
   public SolmuNode getNodeTop(){
       return top;
   }
   
   /**
    * Lisää listaan alkion top-noden perään.
    * top-node ei vaihda paikkaa.
    * O(1)
   **/
   public void add(Solmu solmu){
       SolmuNode uusiNodi = new SolmuNode(solmu);
       SolmuNode seuraava = this.top.seuraava();
       this.top.asetaSeuraava(uusiNodi);
       uusiNodi.asetaSeuraava(seuraava);
   }
   
   
   public Solmu getSolmuOnTop(){
       return top.getSolmu();
   }
   
//   private SolmuNode etsiSeuraavaksiSuurin(int uudenNodenPistearvo){
//       
//       SolmuNode missaMennaan= top;
//       while(missaMennaan.seuraava() != null){
//           if(missaMennaan.seuraava().getSolmunPistearvo() <= uudenNodenPistearvo){
//               return missaMennaan;
//           }
//           missaMennaan=missaMennaan.seuraava();
//       }
//       
//       return missaMennaan;
//   }
   
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
    * @return 
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
   
}
