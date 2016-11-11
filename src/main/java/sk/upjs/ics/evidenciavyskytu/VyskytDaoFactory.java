/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.evidenciavyskytu;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.File;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author student
 */
public enum VyskytDaoFactory {
    
    INSTANCE;
    
    private VyskytDao suborovyVyskytDao;
    private VyskytDao mysqlVyskytDao;
    private static final File SUBOR_VYSKYTY = new File("vyskyty.txt");
    private static final File SUBOR_MAX_ID = new File("maxid.txt");
    
    public VyskytDao getVyskytDao() {
        return getMysqlVyskytDao();
    }
    
    private VyskytDao getSuborovyVyskytDao() {
         if (suborovyVyskytDao == null)
            suborovyVyskytDao = new SuborovyVyskytDao();
        return suborovyVyskytDao;
    }
    
    private VyskytDao getMysqlVyskytDao() {
        if (mysqlVyskytDao == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost/evidencia_vyskytu?serverTimezone=Europe/Bratislava");
            dataSource.setUser("evidenciavyskytu");
            dataSource.setPassword("heslo");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            mysqlVyskytDao = new MysqlVyskytDao(jdbcTemplate);
        }
        return mysqlVyskytDao;
    }
    
}
