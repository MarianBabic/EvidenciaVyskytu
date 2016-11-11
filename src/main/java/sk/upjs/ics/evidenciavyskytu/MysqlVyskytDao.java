/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.evidenciavyskytu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author student
 */
public class MysqlVyskytDao implements VyskytDao {
    
    private JdbcTemplate jdbcTemplate;

    public MysqlVyskytDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vyskyt> dajVyskyty() {
        String sql = "SELECT id, meno, priezvisko, kedy, akcia FROM vyskyt";
        return jdbcTemplate.query(sql, new VyskytRowMapper());
    }

    // udeje sa vsetko v 1 transkakcii, takze id je na 100% spravne
    // keby sme vlozili vyskyt a poziadali selectom o najvacsie id, medzitym by mohol niekto iny vlozit iny vyskyt a uz by id nesedelo
    @Override
    public void vlozVyskyt(Vyskyt vyskyt) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("vyskyt");
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        Map<String, Object> hodnoty = new HashMap<>();
        hodnoty.put("meno", vyskyt.getMeno());
        hodnoty.put("priezvisko", vyskyt.getPriezvisko());
        hodnoty.put("kedy", vyskyt.getKedy());
        hodnoty.put("akcia", vyskyt.getAkcia());
        int newID = simpleJdbcInsert.executeAndReturnKey(hodnoty).intValue();
        vyskyt.setId(newID);
    }

    @Override
    public void vymazVyskyt(int idVyskyt) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravVyskyt(Vyskyt vyskyt) {
        jdbcTemplate.update("UPDATE vyskyt SET "
                + "meno = ?, priezvisko = ?, kedy = ?, akcia = ? "
                + "WHERE id = " + vyskyt.getId(),vyskyt.getMeno(), vyskyt.getPriezvisko(), vyskyt.getKedy(), vyskyt.getAkcia()
              );
    }
    
    private class VyskytRowMapper implements RowMapper<Vyskyt> {

        @Override
        public Vyskyt mapRow(ResultSet rs, int i) throws SQLException {
            Vyskyt vyskyt = new Vyskyt();
            vyskyt.setId(rs.getInt("id"));
            vyskyt.setMeno(rs.getString("meno"));
            vyskyt.setPriezvisko(rs.getString("priezvisko"));
            Timestamp timestamp = rs.getTimestamp("kedy");
            vyskyt.setKedy(timestamp != null ? timestamp.toLocalDateTime() : null);
            vyskyt.setAkcia(rs.getString("akcia"));
            return vyskyt;
        }
        
    }
    
}
