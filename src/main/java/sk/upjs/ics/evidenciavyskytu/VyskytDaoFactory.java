/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.evidenciavyskytu;

import java.io.File;

/**
 *
 * @author student
 */
public enum VyskytDaoFactory {
    
    INSTANCE;
    
    private VyskytDao vyskytDao;
    private static final File SUBOR_VYSKYTY = new File("vyskyty.txt");
    private static final File SUBOR_MAX_ID = new File("maxid.txt");
    
    public VyskytDao getVyskytDao() {
        if (vyskytDao == null)
            vyskytDao = new SuborovyVyskytDao();
        return vyskytDao;
    }
    
}
