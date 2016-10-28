package sk.upjs.ics.evidenciavyskytu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;

public class AkciaVyskytuComboBoxModel extends DefaultComboBoxModel<String> {

    private List<String> akcie;
    private int predchadzajuciVyber;

    public AkciaVyskytuComboBoxModel() {
        VyskytDao dao = VyskytDaoFactory.INSTANCE.getVyskytDao();
        List<Vyskyt> vyskyty = dao.dajVyskyty();
        Set<String> akcieSet = new HashSet<>();
        for (Vyskyt vyskyt : vyskyty) {
            akcieSet.add(vyskyt.getAkcia());
        }
        akcie = new ArrayList<>(akcieSet);
        akcie.add(0, "<<< nova akcia >>>");
    }

    @Override
    public int getSize() {
        return akcie.size();
    }

    @Override
    public String getElementAt(int index) {
        return akcie.get(index);
    }

    public void setPredchadzajuciVyber(int predchadzajuciVyber) {
        this.predchadzajuciVyber = predchadzajuciVyber;
    }

    void addOrChangeAkcia(String vybrataAkcia) {
        if (predchadzajuciVyber == 0) {
            akcie.add(vybrataAkcia);
            predchadzajuciVyber = akcie.size() - 1;
        } else {
            String staraAkcia = akcie.get(predchadzajuciVyber);
            akcie.set(predchadzajuciVyber, vybrataAkcia);

            VyskytDao dao = VyskytDaoFactory.INSTANCE.getVyskytDao();
            List<Vyskyt> vyskyty = dao.dajVyskyty();
            for (Vyskyt vyskyt : vyskyty) {
                if (vyskyt.getAkcia().equals(staraAkcia)) {
                    vyskyt.setAkcia(vybrataAkcia);
                    dao.upravVyskyt(vyskyt);
                }
            }

        }
        fireContentsChanged(this, 0, akcie.size());
    }

}
