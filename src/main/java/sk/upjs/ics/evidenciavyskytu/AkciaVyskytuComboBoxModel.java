package sk.upjs.ics.evidenciavyskytu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;

public class AkciaVyskytuComboBoxModel extends DefaultComboBoxModel<String> {
    
    private List<String> akcie;

    public AkciaVyskytuComboBoxModel() {
        VyskytDao dao = VyskytDaoFactory.INSTANCE.getVyskytDao();
        List<Vyskyt> vyskyty = dao.dajVyskyty();
        Set<String> akcieSet = new HashSet<>();
        for (Vyskyt vyskyt : vyskyty) {
            akcieSet.add(vyskyt.getAkcia());
        }
        akcie = new ArrayList<>(akcieSet);
    }

    @Override
    public int getSize() {
        return akcie.size();
    }

    @Override
    public String getElementAt(int index) {
        return akcie.get(index);
    }
    
}
