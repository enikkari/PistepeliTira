
package Verkko;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pistepeli_tira.verkko.Solmu;

/**
 *
 * @author eevanikkari
 */
public class SolmuTest {
    
    Solmu perttiSolmu;
    Solmu nollaSolmu;
    
    public SolmuTest() {
    }
    
    @Before
    public void setUp() {
        this.perttiSolmu = new Solmu("Pertti", 100);
        this.nollaSolmu = new Solmu("nolla");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void SamanNimisetJaArvoisetSolmutEriOlioita(){
        assertNotSame(new Solmu("Pertti", 100), this.perttiSolmu);
    }
    
//    @Test
//    public void CompareToimii(){
//        Solmu[] taulukko = new Solmu[]{nollaSolmu, perttiSolmu};
//        Solmu uusiNolla = new Solmu("toinen nolla");
//        boolean onkoSamatArvot = uusiNolla == this.nollaSolmu;
//        assertEquals(onkoSamatArvot, true);
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
