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
public class KaaretonVerkkoTest {
    Verkko verkko;
    public KaaretonVerkkoTest() {
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
        this.verkko = new Verkko( new Solmu[]{a,b,c,d,e,f,g,h} );
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void oikeaMaaraKaaria() {
         assertEquals(0, this.verkko.getKaaria());
     }
     @Test
     public void oikeaMaaraSolmuja() {
         assertEquals(8, this.verkko.getSolmuja());
     }
    
}
