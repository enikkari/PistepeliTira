
package VerkkoTest;

import java.util.Collection;
import java.util.LinkedList;
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
    @Test
    public void SolmuLinkedListissa(){
        LinkedList lista = new LinkedList();
        lista.add(this.nollaSolmu);
        lista.add(this.perttiSolmu);
        lista.add(new Solmu("kivaSolmu", 3));
        
        assertEquals(this.perttiSolmu, lista.get(1));
    }
    
    @Test
    public void SolmuLinkedListissa2(){
        LinkedList lista = new LinkedList();
        lista.add(this.nollaSolmu);
        lista.add(this.perttiSolmu);
        lista.add(new Solmu("kivaSolmu", 3));
        
        assertEquals(this.nollaSolmu, lista.getFirst());
    }
    
    @Test
    public void SolmuLinkedListissa3(){
        LinkedList<Solmu> lista = new LinkedList();
        lista.add(this.nollaSolmu);
        lista.add(this.perttiSolmu);
        lista.add(new Solmu("kivaSolmu", 3));
        
        assertEquals(3, lista.getLast().getPistearvo());
    }
    @Test
    public void SamaSolmu(){
        assertEquals(perttiSolmu, perttiSolmu);
    }
    @Test
    public void nollaArvoOikein(){
        assertEquals(nollaSolmu.getPistearvo(), 0);
    }
    @Test
    public void arvoOikein(){
        assertEquals(perttiSolmu.getPistearvo(), 100);
    }
    
    @Test
    public void nimiOikein(){
        assertEquals(perttiSolmu.getNimi(), "Pertti");
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
