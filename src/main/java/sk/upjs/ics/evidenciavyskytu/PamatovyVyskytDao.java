package sk.upjs.ics.evidenciavyskytu;

import java.util.ArrayList;
import java.util.List;

public class PamatovyVyskytDao implements VyskytDao {

    private List<Vyskyt> vyskyty;
    private int maxId = 0;

   
   public PamatovyVyskytDao() {
        vyskyty = new ArrayList<>();
    }
    
   @Override
    public List<Vyskyt> dajVyskyty() {
        return vyskyty;
    }

    public void vlozVyskyt(Vyskyt vyskyt) {
        vyskyt.setId(++maxId);
        vyskyty.add(vyskyt);
    }

    public void vymazVyskyt(int idVyskyt) {
        for (int i=0; i<vyskyty.size(); i++) {
            if (vyskyty.get(i).getId()==idVyskyt)
                vyskyty.remove(vyskyty.get(i));
        }
    }

}
