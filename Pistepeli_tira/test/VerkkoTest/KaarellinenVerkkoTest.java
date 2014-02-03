/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VerkkoTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pistepeli_tira.LinkitettyLista.LinkitettyLista;
import pistepeli_tira.LinkitettyLista.SolmuNode;
import pistepeli_tira.verkko.Solmu;
import pistepeli_tira.verkko.Verkko;

/**
 *
 * @author eevanikkari
 */
public class KaarellinenVerkkoTest {
    Verkko verkko;
    Solmu a; 
        Solmu b; 
        Solmu c; 
        Solmu d; 
        Solmu e; 
        Solmu f; 
        Solmu g; 
        Solmu h; 
    
    public KaarellinenVerkkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.a = new Solmu("a", 20); 
        this.b = new Solmu("b", 5); 
        this.c = new Solmu("c", 9); 
        this.d = new Solmu("d", 3); 
        this.e = new Solmu("e", 1); 
        this.f = new Solmu("f"); 
        this.g = new Solmu("g", 4); 
        this.h = new Solmu("h", 2); 
//        this.verkko = new Verkko(new Solmu[][]{{a,b,c,d},{b,c},{c,d},{d,e},{e,f,g,a},{f,g},{g,h},{h},});
        Verkko uusiVerkko = new Verkko( new Solmu[]{a,b,c,d,e,f,g,h} );
        uusiVerkko.lisaaKaaret(new int[][]{{0,1},{0,2},{0,3},{1,2},{2,3},{3,4},{4,0},{4,5},{4,6},{5,6},{6,7}});
//        uusiVerkko.lisaaKaari(0, 1);
        this.verkko = uusiVerkko;
        
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void oikeaMaaraKaaria() {
         assertEquals(11, this.verkko.getKaaria());
     }
     @Test
     public void oikeaMaaraSolmuja() {
         assertEquals(8, this.verkko.getSolmuja());
     }
     @Test
     public void solmujenIneksointi() {
         Solmu[] solmutVerkossa =
                 new Solmu[verkko.getSolmuja()];
         
         for(int i = 0; i<verkko.getSolmuja(); i++){
             solmutVerkossa[i]=verkko.getSolmuIdeksissa(i);
         }
         
         Solmu[] solmutOikein =
                 new Solmu[]{a,b,c,d,e,f,g,h};
//         
//         boolean ovatkoTaulukotSamat = true;
//         for(int i = 0; i<verkko.getSolmuja(); i++){
//             if(solmutVerkossa[i] != solmutOikein[i]){
//                 ovatkoTaulukotSamat = false;
//                 break;
//             }
//         }
//         
//         
         Assert.assertArrayEquals(solmutVerkossa, solmutOikein);
     }
     
     @Test
     public void solmujenOmaIneksointiVerkossa() {
         int[] solmutVerkossa =
                 new int[verkko.getSolmuja()];
         
         for(int i = 0; i<verkko.getSolmuja(); i++){
             solmutVerkossa[i]=this.verkko.getSolmuIdeksissa(i).indeksi();
         }
         
         int[] solmutOikein =
                 new int[]{0,1,2,3,4,5,6,7};
         Assert.assertArrayEquals(solmutVerkossa, solmutOikein);
     }
     
     @Test
     public void solmujenHakeminenIndeksilla1() {
         assertEquals(-1, this.verkko.getMissaIndeksissaSolmuOn(new Solmu("ö", 20)));
     }
     @Test
     public void solmujenHakeminenIndeksilla2() {
         assertEquals(0 , this.verkko.getMissaIndeksissaSolmuOn(a));
     }
     @Test
     public void solmujenHakeminenIndeksilla3() {
         int[] oikeaIndeksointi = new int[]{0,1,2,3,4,5,6,7};
         int[] verkonIndeksointi = new int[]
                                {this.verkko.getMissaIndeksissaSolmuOn(a),
                                this.verkko.getMissaIndeksissaSolmuOn(b),
                                this.verkko.getMissaIndeksissaSolmuOn(c),
                                this.verkko.getMissaIndeksissaSolmuOn(d),
                                this.verkko.getMissaIndeksissaSolmuOn(e),
                                this.verkko.getMissaIndeksissaSolmuOn(f),
                                this.verkko.getMissaIndeksissaSolmuOn(g),
                                this.verkko.getMissaIndeksissaSolmuOn(h)};
         
         //käytä metodia taulukkoon!
         Assert.assertArrayEquals(oikeaIndeksointi, verkonIndeksointi);
     }
     @Test
     public void vierusTest(){
         LinkitettyLista aanVierus = this.verkko.getVierus(0);
         SolmuNode missa = aanVierus.getNodeTop();
         Solmu[] aanVierusVerkossa = new Solmu[aanVierus.listanPituus()];
         int i=0;
         while(missa.seuraava() != null){
             aanVierusVerkossa[i]=missa.getSolmu();
             missa = missa.seuraava();
             i++;
         }
         aanVierusVerkossa[i]=missa.getSolmu();
         
         Solmu[] aanVierusOikein = new Solmu[]{a,d,c,b};
         
         Assert.assertArrayEquals(aanVierusOikein, aanVierusVerkossa);
     }
     
     
}
