package sk.upjs.ics.evidenciavyskytu;

import javax.swing.AbstractListModel;

public class VyskytListModel extends AbstractListModel<Vyskyt> {

    private VyskytDao dao;

    public VyskytListModel() {
        dao = VyskytDaoFactory.INSTANCE.getVyskytDao();
    }
    
    @Override
    public int getSize() {
        return dao.dajVyskyty().size();
    }

    @Override
    public Vyskyt getElementAt(int index) {
        return dao.dajVyskyty().get(index);
    }

    public void pridajVyskyt(Vyskyt vyskyt) {
        dao.vlozVyskyt(vyskyt);
        int pozicia = dao.dajVyskyty().size();
        fireIntervalAdded(this, pozicia, pozicia);
    }
    
}
