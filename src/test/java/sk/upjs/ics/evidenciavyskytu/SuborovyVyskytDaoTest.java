/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.evidenciavyskytu;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author student
 */
public class SuborovyVyskytDaoTest {
    
    private VyskytDao vyskytDao;
    
    @Before
    public void pripravData() {
        vyskytDao = new SuborovyVyskytDao();
        
//        Vyskyt vyskyt = new Vyskyt();
//        vyskyt.setMeno("Judita");
//        vyskyt.setPriezvisko("Juskova");
//        vyskyt.setAkcia("PAZ1c v P3 - 2.cvicenie");
//        vyskyt.setKedy(LocalDateTime.of(2016, Month.SEPTEMBER, 30, 7, 4));
//        vyskytDao.vlozVyskyt(vyskyt);
    }
    
    @Test
    public void testDajVyskyty() {
        List<Vyskyt> vyskyty = vyskytDao.dajVyskyty();
        
        Assert.assertNotNull(vyskyty);
    }
    
    @Test
    public void testVlozVyskyt() {
        Vyskyt vyskyt = new Vyskyt();
        vyskyt.setMeno("Erika");
        vyskyt.setPriezvisko("Buffova");
        vyskyt.setAkcia("PAZ1c v P3 - 2.cvicenie");
        vyskyt.setKedy(LocalDateTime.of(2016, Month.SEPTEMBER, 30, 7, 6));
        vyskytDao.vlozVyskyt(vyskyt);
        
       List<Vyskyt> vyskyty = vyskytDao.dajVyskyty();
        Assert.assertEquals(1, vyskyty.size()); 
    }
    
}
