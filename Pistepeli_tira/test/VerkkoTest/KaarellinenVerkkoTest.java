/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VerkkoTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pistepeli_tira.verkko.Solmu;
import pistepeli_tira.verkko.Verkko;

/**
 *
 * @author eevanikkari
 */
public class KaarellinenVerkkoTest {
    Verkko verkko;
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
        Solmu a = new Solmu("a", 20); 
        Solmu b = new Solmu("b", 5); 
        Solmu c = new Solmu("c", 9); 
        Solmu d = new Solmu("d", 3); 
        Solmu e = new Solmu("e", 1); 
        Solmu f = new Solmu("f"); 
        Solmu g = new Solmu("g", 4); 
        Solmu h = new Solmu("h", 2); 
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
}
