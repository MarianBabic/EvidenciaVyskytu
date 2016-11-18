package sk.upjs.ics.evidenciavyskytu;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlAkciaDao implements AkciaDao {
    
    private JdbcTemplate jdbcTemplate;

    public MySqlAkciaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void pridaj(Akcia akcia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Akcia> dajVsetky() {
        String sql = "SELECT id, nazov, predmet FROM akcia";
        BeanPropertyRowMapper<Akcia> bprm = new BeanPropertyRowMapper<>();
        // 2.variant pre bprm:
        // BeanPropertyRowMapper<> bprm = new BeanPropertyRowMapper<>(Akcia.class);
        return jdbcTemplate.query(sql, bprm);
    }

    @Override
    public Akcia dajPodlaId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zmen(Akcia akcia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vymaz(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
