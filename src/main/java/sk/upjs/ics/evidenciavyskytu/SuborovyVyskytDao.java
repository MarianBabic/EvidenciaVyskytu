package sk.upjs.ics.evidenciavyskytu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuborovyVyskytDao implements VyskytDao {
    
    private File vyskyty;
    private File suborSId;

    public SuborovyVyskytDao() {
        vyskyty = new File("vyskyty.txt");
        suborSId = new File("suborsid.txt");
    }
    
    public SuborovyVyskytDao(File vyskyty, File suborsid) {
        this.vyskyty = vyskyty;
        this.suborSId = suborsid;
    }

    @Override
    public List<Vyskyt> dajVyskyty() {
        List<Vyskyt> outputList = new ArrayList<>();
        try (Scanner scanner = new Scanner(vyskyty)) {
           while(scanner.hasNextLine()) {
               
//           vyskyty.add(new Vyskyt(scanner.nextLine()));
               
               Scanner scannerRiadka = new Scanner(scanner.nextLine());
               Vyskyt vyskyt = new Vyskyt();
               scannerRiadka.useDelimiter(";");
               vyskyt.setId(scannerRiadka.nextInt());
               vyskyt.setMeno(scannerRiadka.next());
               vyskyt.setPriezvisko(scannerRiadka.next());
               vyskyt.setKedy(LocalDateTime.parse(scannerRiadka.next()));
               vyskyt.setAkcia(scannerRiadka.next());
               outputList.add(vyskyt);
           }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuborovyVyskytDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return outputList;
    }

    @Override
    public void vlozVyskyt(Vyskyt vyskyt) {
        int maxId = 0;
        try(Scanner scanner = new Scanner(suborSId)){
            maxId = scanner.nextInt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuborovyVyskytDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try(FileWriter writer = new FileWriter(vyskyty, true);
                PrintWriter pw = new PrintWriter(suborSId)) {
            maxId++;
            
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(maxId));
            sb.append(";");
           sb.append(vyskyt.getMeno());
           sb.append(";");
           sb.append(vyskyt.getPriezvisko());
           sb.append(";");
           sb.append(vyskyt.getKedy().toString());
           sb.append(";");
           sb.append(vyskyt.getAkcia());
           String vyskytString = sb.toString();
           
           writer.append(vyskytString + "\n");
           
           pw.print(maxId);
        } catch (IOException ex) {
            Logger.getLogger(SuborovyVyskytDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void vymazVyskyt(int idVyskyt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
