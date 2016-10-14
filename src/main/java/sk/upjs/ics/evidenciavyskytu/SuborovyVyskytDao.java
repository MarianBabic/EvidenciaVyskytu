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

    @Override
    public List<Vyskyt> dajVyskyty() {
        List<Vyskyt> outputList = new ArrayList<>();
        try (Scanner scanner = new Scanner(vyskyty)) {
           while(scanner.hasNextLine()) {
               Scanner scannerRiadka = new Scanner(scanner.nextLine());
               Vyskyt vyskyt = new Vyskyt();
               scannerRiadka.useDelimiter(";");
               vyskyt.setId(Integer.parseInt(scannerRiadka.next()));
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
        
        try(FileWriter writer = new FileWriter(vyskyty);
                PrintWriter pw = new PrintWriter(suborSId)) {
            maxId++;
           writer.append(Integer.toString(maxId));
           writer.append(";");
           writer.append(vyskyt.getMeno());
           writer.append(";");
           writer.append(vyskyt.getPriezvisko());
           writer.append(";");
           writer.append(vyskyt.getKedy().toString());
           writer.append(";");
           writer.append(vyskyt.getAkcia());
           writer.append("\n");
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
