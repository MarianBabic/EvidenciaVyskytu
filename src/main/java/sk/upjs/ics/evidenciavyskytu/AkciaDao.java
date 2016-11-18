package sk.upjs.ics.evidenciavyskytu;

import java.util.List;

public interface AkciaDao {
    
    void pridaj(Akcia akcia);
    
    List<Akcia> dajVsetky();
            
    Akcia dajPodlaId(Long id);
    
    void zmen(Akcia akcia);
    
    void vymaz(Long id);
    
}
