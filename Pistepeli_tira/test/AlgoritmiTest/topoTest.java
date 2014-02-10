/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AlgoritmiTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pistepeli_tira.Algoritmi.TopoAlgoritmi;
import pistepeli_tira.LinkitettyLista.*;
import pistepeli_tira.verkko.*;

/**
 *
 * @author eevanikkari
 */
public class topoTest {
    
    TopoAlgoritmi topo;
    
    public topoTest() {
    }
    
    @Before
    public void setUp() {
        Solmu R =new Solmu("R",2);
        Solmu S =new Solmu("S",2);
        Solmu T =new Solmu("T",2);
        Solmu X =new Solmu("X",2);
        Solmu Y =new Solmu("Y",2);
        Solmu Z =new Solmu("Z",2);
        
        Verkko uusiVerkko = new Verkko(new Solmu[]{R, S, T, X, Y, Z});
        uusiVerkko.lisaaKaaret(new int[][]{{0,1},{0,2},{1,2},{1,3},{2,3},{2,4},{2,5},{3,4},{3,5}});
        
        topo = new TopoAlgoritmi(uusiVerkko);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void pinoOikein() {
     Pino pino = this.topo.getPino();
     String[] solmut = new String[6];
     for(int i = 0; i<6; i++){
         solmut[i]=pino.pop().getNimi();
     }
     assertArrayEquals(solmut, new String[]{"R","S","T","X","Y","Z"});
     }
}
