/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkitettyListaTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pistepeli_tira.LinkitettyLista.*;
import pistepeli_tira.verkko.*;

/**
 *
 * @author eevanikkari
 */
public class PinoTest {

    private Pino pino;

    public PinoTest() {
    }

    @Before
    public void setUp() {
        this.pino = new Pino();
        Solmu R = new Solmu("R", 2);
        Solmu S = new Solmu("S", 2);
        Solmu T = new Solmu("T", 2);
        Solmu X = new Solmu("X", 2);
        Solmu Y = new Solmu("Y", 2);
        Solmu Z = new Solmu("Z", 2);

        pino.push(R);
        pino.push(S);
        pino.push(T);
        pino.push(X);
        pino.push(Y);
        pino.push(Z);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void pinoPoppaileeOikein() {
        String[] solmut = new String[6];
        for (int i = 0; i < 6; i++) {
            solmut[i] = pino.pop().getNimi();
        }
        assertArrayEquals(new String[]{"Z", "Y", "X", "T","S","R"}, solmut);
    }
}
