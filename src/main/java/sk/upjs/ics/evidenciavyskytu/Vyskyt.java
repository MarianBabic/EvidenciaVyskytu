package sk.upjs.ics.evidenciavyskytu;

import java.time.LocalDateTime;

public class Vyskyt {
    
    private final int id;
    private String meno;
    private String priezvisko;
    private LocalDateTime kedy;
    private String akcia;

    public Vyskyt(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public LocalDateTime getKedy() {
        return kedy;
    }

    public void setKedy(LocalDateTime kedy) {
        this.kedy = kedy;
    }

    public String getAkcia() {
        return akcia;
    }

    public void setAkcia(String akcia) {
        this.akcia = akcia;
    }
            
     
    
}
