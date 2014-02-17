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
import pistepeli_tira.LinkitettyLista.Pino;
import pistepeli_tira.verkko.Solmu;
import pistepeli_tira.verkko.Verkko;

/**
 *
 * @author eevanikkari
 */
public class TopoEriVerkoillaTest {

    TopoAlgoritmi topo2;
    TopoAlgoritmi topo3;

    public TopoEriVerkoillaTest() {
    }

    @Before
    public void setUp() {
        Verkko verkko2 = new Verkko(new Solmu[]{new Solmu("A", 70), new Solmu("B", 10),
            new Solmu("C", 60), new Solmu("D", 50),
            new Solmu("E", 30), new Solmu("F", 50),
            new Solmu("G", 10), new Solmu("H", 20),
            new Solmu("I", 100)},
                new int[][]{{0, 1}, {0, 2}, {0, 3},
                 {2, 4}, {2, 5}, {6, 5},
                {6, 7}, {6, 8}, {7, 8}});
        topo2 = new TopoAlgoritmi(verkko2);

        Verkko verkko3 = new Verkko(new Solmu[]{new Solmu("Alkaid", -2), new Solmu("Mizar", 3),
            new Solmu("Alioth", 8), new Solmu("Megrez", -1),
            new Solmu("Dubhe", 10), new Solmu("Merak", 1),
            new Solmu("Phecda", 5)},
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4},
                {3, 6}, {5, 4}, {5, 6}});
        topo3 = new TopoAlgoritmi(verkko3);
    }

    @Test
    public void topoPinoOikeinVerkko3() {
        Pino pino = this.topo3.getTopoPino();
        int[] solmut = new int[7];
        for (int i = 0; i < 7; i++) {
            solmut[i] = pino.pop().indeksi();
        }
        assertArrayEquals(new int[]{5, 0, 1, 2, 3, 4, 6}, solmut);
    }

    @Test
    public void topoPinoOikeinVerkko2() {
        Pino pino = this.topo2.getTopoPino();
        int[] solmut = new int[9];
        int i=0;
        while (!pino.isEmpty()) {
            solmut[i] = pino.pop().indeksi();
            i++;
        }
        assertArrayEquals(new int[]{6,7,8,0,1,2,4,5,3}, solmut);
    }
    
    @Test
     public void reitti2() {
         assertArrayEquals(new int[]{-1,0,0,0,2,2,-1,6,7},this.topo2.getReitti());
     }
     
     @Test
     public void reitti3() {
         assertArrayEquals(new int[]{-1,-1,1,2,3,-1,3},this.topo3.getReitti());
     }
}
