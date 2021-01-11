package lab_1;

import java.io.*;
import javax.swing.*;

public class PapersFrame extends JFrame{
    ConferencePanel conferencepanel; 
    ScienceMagPanel sciencemagpanel;
    ObjectOutputStream out; //για εξαγωγή δεδομένων stream σε αρχείο
    PapersFrame(ObjectOutputStream out){
        this.out = out;
        // ************************************************ ΔΗΜΙΟΥΡΓΊΑ ΤΟΥ DROP DOWN MENU ΕΠΙΛΟΓΩΝ ************************************************

        MainMenu mb = new MainMenu(this); 
        
        // ************************************************ ΤΕΛΟΣ ΔΗΜΙΟΥΡΓΊΑΣ ΤΟΥ DROP DOWN MENU ΕΠΙΛΟΓΩΝ ************************************************
        
        this.setJMenuBar(mb);  // το μενου κάτω από το MainMenu
        JTabbedPane tabbedPane = new JTabbedPane();
        this.add(tabbedPane);
        conferencepanel = new ConferencePanel(this); //δεσμευση χώρου για την σχεδίαση του conference κοματιού  
        tabbedPane.add(conferencepanel,"Εργασία σε περιοδικό");// καρτέλα "Εργασία σε περιοδικό"
        
        this.setTitle("Δημοσιεύσεις"); //εξτρα χώρος κειμένου για να βλέπω τις εργασίες που καταχωρούνται.(Για testing)
        this.setVisible(true);// για να μπορώ να δώ ότι σχεδιάζω
        this.setSize(400,400);
        
        sciencemagpanel = new ScienceMagPanel(this);
        tabbedPane.add(sciencemagpanel,"Εργασία σε συνέδριο");
        this.setVisible(true);// για να μπορώ να δώ ότι σχεδιάζω
        this.setSize(500,400);

        // Για να μην πρέπει να πατήσω κλείσιμο μια στο παράθυρο και μία από τον compiler μου
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }  
}