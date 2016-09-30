package sk.upjs.ics.evidenciavyskytu;

import java.util.ArrayList;
import java.util.List;

public class VyskytDao {

    private List<Vyskyt> vyskyty;

    public VyskytDao() {
        vyskyty = new ArrayList<>();
    }
    
    List<Vyskyt> dajVyskyty() {
        return vyskyty;
    }

    void vlozVyskyt(Vyskyt vyskyt) {
        vyskyty.add(vyskyt);
    }

    void vymazVyskyt(int idVyskyt) {
        for (int i=0; i<vyskyty.size(); i++) {
            if (vyskyty.get(i).getId()==idVyskyt)
                vyskyty.remove(vyskyty.get(i));
        }
    }

}
