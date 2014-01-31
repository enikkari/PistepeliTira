/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pistepeli_tira.Algoritmi;

import pistepeli_tira.verkko.Solmu;
import pistepeli_tira.verkko.Verkko;

/**
 *
 * Algoritmi, joka käy dfs:llä läpi verkon ja pitää parhaana reittinä sitä,
 *  josta saatiin eniten pisteitä umpikujaan tullessa.
 * Ongelma: algoritmi ei osaa jatkaa haraan, jos sen solmut on käsitelty aikaisemmin,
 * vaikka periaattessa se saisi jatkaa peliä?
 */
public class AlgoritmiDFS {
    Verkko verkko;
    Solmu lahtosolmu;
    boolean[] kayty;
    //int[] parasReitti
    int parasPistemaara;
    
    
    public AlgoritmiDFS(Verkko verkko, Solmu lahtoSolmu){
        this.verkko=verkko;
        this.lahtosolmu = lahtoSolmu;
        this.kayty= new boolean[verkko.getSolmuja()];
        this.parasPistemaara=lahtoSolmu.getPistearvo();
        
    }
    
    private void DFS(Solmu lahtosolmu){
        
        
    }
    
}
