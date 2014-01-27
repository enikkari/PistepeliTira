
package VerkkoTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pistepeli_tira.LinkitettyLista.LinkitettyLista;
import pistepeli_tira.verkko.Solmu;

/**
 *
 * @author eevanikkari
 */
public class LinkitettyListaTest {
    
    LinkitettyLista lista;
    Solmu solmu1;
    public LinkitettyListaTest() {
    }

    
    @Before
    public void setUp() {
        this.solmu1 = new Solmu("solmu1", 30);
        this.lista = new LinkitettyLista(solmu1);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void saadaanTop() {
     assertEquals(this.lista.getSolmuOnTop(), this.solmu1);
     }
     
     @Test
     public void lisaaminenToimii() {
         Solmu solmu2 = new Solmu("solmu2", 3);
         this.lista.add(solmu2);
         Solmu seuraavaSolmu = this.lista.getNodeTop().seuraava().getSolmu();
        assertEquals(seuraavaSolmu, solmu2);
     }
}
