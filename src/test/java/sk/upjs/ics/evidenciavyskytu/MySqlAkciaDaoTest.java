/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.evidenciavyskytu;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class MySqlAkciaDaoTest {
    
    public MySqlAkciaDaoTest() {
    }

    /**
     * Test of pridaj method, of class MySqlAkciaDao.
     */
    @Test
    public void testPridaj() {
        System.out.println("pridaj");
        Akcia akcia = null;
        MySqlAkciaDao instance = null;
        instance.pridaj(akcia);
        fail("The test case is a prototype.");
    }

    /**
     * Test of dajVsetky method, of class MySqlAkciaDao.
     */
    @Test
    public void testDajVsetky() {
        System.out.println("dajVsetky");
        MySqlAkciaDao instance = null;
        List<Akcia> expResult = null;
        List<Akcia> result = instance.dajVsetky();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of dajPodlaId method, of class MySqlAkciaDao.
     */
    @Test
    public void testDajPodlaId() {
        System.out.println("dajPodlaId");
        Long id = null;
        MySqlAkciaDao instance = null;
        Akcia expResult = null;
        Akcia result = instance.dajPodlaId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of zmen method, of class MySqlAkciaDao.
     */
    @Test
    public void testZmen() {
        System.out.println("zmen");
        Akcia akcia = null;
        MySqlAkciaDao instance = null;
        instance.zmen(akcia);
        fail("The test case is a prototype.");
    }

    /**
     * Test of vymaz method, of class MySqlAkciaDao.
     */
    @Test
    public void testVymaz() {
        System.out.println("vymaz");
        Long id = null;
        MySqlAkciaDao instance = null;
        instance.vymaz(id);
        fail("The test case is a prototype.");
    }
    
}
