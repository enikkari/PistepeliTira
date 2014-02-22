
package LinkitettyListaTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pistepeli_tira.LinkitettyLista.LinkitettyLista;
import pistepeli_tira.LinkitettyLista.SolmuNode;
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
        Solmu solmu2 = new Solmu(3);
         Solmu solmu3 = new Solmu(4);
         Solmu solmu4 = new Solmu(2);
         Solmu solmu5 = new Solmu(50);
         Solmu solmu6 = new Solmu(2);
         Solmu solmu7 = new Solmu(5);
         Solmu solmu8 = new Solmu(9);
         Solmu solmu9 = new Solmu(23);
         this.lista.add(solmu2);
         this.lista.add(solmu3);
         this.lista.add(solmu4);
         this.lista.add(solmu5);
         this.lista.add(solmu6);
         this.lista.add(solmu7);
         this.lista.add(solmu8);
         this.lista.add(solmu9);
         
     assertEquals(this.solmu1, this.lista.getSolmuOnTop());
     }

     @Test
     public void saadaanTop() {
     assertEquals(this.lista.getSolmuOnTop(), this.solmu1);
     }
     
     @Test
     public void saadaanTopAddJalkeen() {
     this.lista.add(new Solmu("ölöl",10));
     assertEquals(this.lista.getSolmuOnTop(), this.solmu1);
     }
     
     @Test
     public void saadaanUusiTopAddOnTopJalkeen() {
     this.lista.addOnTop(new Solmu("ölöl",10));
     assertEquals("ölöl", this.lista.getSolmuOnTop().getNimi());
     }
     @Test
     public void lisaaminenToimii() {
         Solmu solmu2 = new Solmu("solmu2", 3);
         this.lista.add(solmu2);
         Solmu seuraavaSolmu = this.lista.getNodeTop().seuraava().getSolmu();
        assertEquals(seuraavaSolmu, solmu2);
     }
     
     @Test
     public void listanPituus(){
         assertEquals(9, this.lista.listanPituus());
     }

}
