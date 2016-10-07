package sk.upjs.ics.evidenciavyskytu;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class VyskytDaoTest {
    
    private VyskytDao vyskytDao;
    
    // spusti sa pred kazdym testom
    @Before
    public void pripravData() {
        vyskytDao = new VyskytDao();
        
        Vyskyt vyskyt = new Vyskyt();
        vyskyt.setMeno("Judita");
        vyskyt.setPriezvisko("Juskova");
        vyskyt.setAkcia("PAZ1c v P3 - 2.cvicenie");
        vyskyt.setKedy(LocalDateTime.of(2016, Month.SEPTEMBER, 30, 7, 4));
        vyskytDao.vlozVyskyt(vyskyt);
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
        Assert.assertEquals(2, vyskyty.size());     
    }
    
    @Test
    public void testVymazVyskyt() {
        int idVyskyt = 1;
        vyskytDao.vymazVyskyt(idVyskyt);
        
        List<Vyskyt> vyskyty = vyskytDao.dajVyskyty();
        Assert.assertEquals(0, vyskyty.size());
    }
    
}
