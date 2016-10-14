/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.evidenciavyskytu;

import java.util.List;

/**
 *
 * @author student
 */
public interface VyskytDao {

    List<Vyskyt> dajVyskyty();

    void vlozVyskyt(Vyskyt vyskyt);
    
     void vymazVyskyt(int idVyskyt);
    
}
