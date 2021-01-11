package lab_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainMenu extends JMenuBar{
    PapersFrame pf;
    MainMenu(PapersFrame pf){
        this.pf = pf;
        JMenu menu = new JMenu("Επιλογές");//Δημιουργία drop down Menu Επιλογών
        JMenuItem searchtmi = new JMenuItem("Αναζήτηση/Τίτλο");//Επιλογές-> Αναζήτηση/Τιτλο
        
        //ψάχνει για το title menu item και με το ActionListener μπορεί να το λάβει το event e και να το υλοποιήσει
        searchtmi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // το stream εισαγωγής στο αρχείο θα είναι κενό
                ObjectInputStream in = null;
                StringBuilder sb = new StringBuilder();
                
                // η foundany λέει το εάν ειναι κενό το πεδίο εισαγωγής μας
                boolean foundany= false;
                //*********************************************************************************************************
                
                try {
                    String st = JOptionPane.showInputDialog(pf, "Όρος αναζήτησης: ", "Αναζήτηση", JOptionPane.QUESTION_MESSAGE);
                    
                    in = new ObjectInputStream(new FileInputStream("papers.txt"));
                    Paper p;
                    while((p = (Paper)in.readObject())!=null){
                        if (p.searchTitle(st)){
                            sb.append(p);
                            foundany = true;    
                        }
                    } 
                /*exception εάν έχει ή όχι τίποτα καταχωρημένο μέσα το sb String και εμφάνιση κατάληλου παραθύρου και
                    μηνύματος κάθε φορά κατά την αναζήτηση τίτλου*/
                } catch(EOFException ex){
                        //το  "Σχετικά" είναι ο τίτλος του παραθύρου
                        if (foundany)
                            JOptionPane.showMessageDialog(pf,  sb,"Σχετικά",JOptionPane.INFORMATION_MESSAGE );
                        else
                            JOptionPane.showMessageDialog(pf,  "Δεν βρέθηκε δημοσίευση","Σχετικά",JOptionPane.INFORMATION_MESSAGE );
                }
                 catch (IOException | ClassNotFoundException ex) {ex.printStackTrace();}
                //κλεινει το input stream
                 finally {
                    try {in.close();}
                    catch (IOException ex) {}
                 }
            }
        });
        //αφου υλοποιήθηκε πρόσθεσέ το 
        menu.add(searchtmi);

        //Menu SearchAuthor
        JMenuItem searchami = new JMenuItem("Αναζήτηση/Συγγραφέα");
        searchami.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                ObjectInputStream in = null;
                StringBuilder sb = new StringBuilder();
                boolean foundany = false;
                try {
                    String st = JOptionPane.showInputDialog(pf, "Όρος αναζήτησης:", "Αναζήτηση", JOptionPane.QUESTION_MESSAGE);
                    in = new ObjectInputStream(new FileInputStream("papers.txt"));

                    Paper p;
                    while((p = (Paper)in.readObject())!=null){
                        if (p.searchAuthor(st)){
                            sb.append(p);
                            foundany = true;      
                        }
                    }
                    
                } catch(EOFException ex){
                    if (foundany)
                        JOptionPane.showMessageDialog(pf,  sb,"Σχετικά",JOptionPane.INFORMATION_MESSAGE );
                    else
                        JOptionPane.showMessageDialog(pf,  "Δεν βρέθηκε δημοσίευση","Σχετικά",JOptionPane.INFORMATION_MESSAGE );
                }
                catch (IOException | ClassNotFoundException ex) {ex.printStackTrace();} 
                finally {
                    try {in.close();} 
                    catch (IOException ex) {}
                }
            }

        });
        menu.add(searchami);
        
        //Menu About
        JMenuItem aboutmi = new JMenuItem("Σχετικά");
        aboutmi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(pf,  "Βίκυ","Σχετικά",JOptionPane.INFORMATION_MESSAGE );
            }
        });
        menu.add(aboutmi);

        //Menu Choice Exit
        JMenuItem exitmi = new JMenuItem("Έξοδος");
        exitmi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitmi);
        this.add(menu);
        
    }
}
