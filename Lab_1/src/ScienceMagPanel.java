
package lab_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.*;

public class ScienceMagPanel extends JPanel{
    PapersFrame pf;
    ScienceMagPanel(PapersFrame pf){
        this.pf = pf;
        ArrayList<String> authorslist = new ArrayList<>();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // ********************** Δημιουργία Τίτλος Εργασίας (χώρο και Label) ********************** 
        JPanel sciencemagpanel = new JPanel();
 
        JLabel sciMagTilabel = new JLabel("Τίτλος άρθρου:"); //label 
        sciMagTilabel.setForeground(Color.darkGray); // για γράμματα
        sciencemagpanel.add(sciMagTilabel); 
        JTextField scienceMtfield = new JTextField(); //χώρος που γράφουμε τίτλο
        scienceMtfield.setPreferredSize(new Dimension(100,20));
        sciencemagpanel.add(scienceMtfield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(sciencemagpanel);
        
        // *************************** Δημιουργία Label Συγγραφείς Εργασίας *************************** 
        JPanel scienceMAuthpanel = new JPanel();
        JLabel sciencefMAuthlabel = new JLabel("Συγγραφείς:");
        scienceMAuthpanel.add(sciencefMAuthlabel);
        JTextField sciencefMAuthfield = new JTextField();//χώρος που γράφουμε τον συγγραφέα
        sciencefMAuthfield.setPreferredSize(new Dimension(100,20));
        scienceMAuthpanel.add(sciencefMAuthfield); // εμφανίζει το text field για να γράψουμε το ονομα του συγγραφέα
        
        JTextArea scienceMAuthorsarea = new JTextArea();
        scienceMAuthorsarea.setEditable(false);//δεν μπορω να πληκτρολογήσω μέσα 
        JScrollPane sp = new  JScrollPane(scienceMAuthorsarea); //πολλοί οι συγγραφείς, κανει scroll down
        
        
        // **************************** Γραφικό για προσθήκη συγγραφέα ****************************
        JButton scienceMAuthadd = new JButton(new ImageIcon("icons/addauthor.png"));         
        scienceMAuthadd.setToolTipText("Προσθήκη Συγγραφέα"); //βοηθητικό κείμενο για την λειτουργεία του κουμπιου
        //θέλω το ActionListener για τον συγγραφέα
        scienceMAuthadd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scienceMAuthorsarea.append(sciencefMAuthfield.getText()+"\n");
                authorslist.add(sciencefMAuthfield.getText());
            }
        });
        this.add(sp);
        scienceMAuthpanel.add(scienceMAuthadd);// εμφανίζει το κουμπι για προσθήκη συγγραφέα
        

        // **************************** Γραφικό για διαγραφή συγγραφέα ****************************
        JButton scienceMAuthremove = new JButton(new ImageIcon("icons/removeauthors.png"));
        scienceMAuthremove.setToolTipText("Διαγραφή Συγγραφέων");//βοηθητικό κείμενο για την λειτουργεία του κουμπιου
        
        scienceMAuthremove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scienceMAuthorsarea.setText(null);
                authorslist.clear();
            }
        });
        scienceMAuthpanel.add(scienceMAuthremove);
        this.add(scienceMAuthpanel);
        
         // ********************** Δημιουργία Τίτλος Περιοδικού Δημοσίευσης Άρθρου (χώρο και Label) ********************** 
        JPanel magpanel = new JPanel();
 
        JLabel magTilabel = new JLabel("Τίτλος Περιοδικού Δημοσίευσης Άρθρου:"); //label 
        magpanel.add(magTilabel); 
        JTextField magTitlefield = new JTextField(); //χώρος που γράφουμε τίτλο
        magTitlefield.setPreferredSize(new Dimension(100,20));
        magpanel.add(magTitlefield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(magpanel);
        
        // ********************** Δημιουργία Αριθμού Σελίδων Άρθρου ********************** 
        JPanel pagesPaperpanel = new JPanel();
 
        JLabel pagesPaperlabel = new JLabel("Αριθμός Σελίδων Άρθρου:"); //label 
        pagesPaperpanel.add(pagesPaperlabel); 
        JTextField pagesPaperfield = new JTextField(); //χώρος που γράφουμε τίτλο
        pagesPaperfield.setPreferredSize(new Dimension(50,20));
        pagesPaperpanel.add(pagesPaperfield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(pagesPaperpanel);
        
        // ********************** Δημιουργία Τόμου Περιοδικού Δημοσίευσης  ********************** 
        JPanel yearPublpanel = new JPanel();
        JLabel yearPubllabel = new JLabel("Έτος Δημοσίευσης Άρθρου: "); //label 
        yearPublpanel.add(yearPubllabel);
        yearPublpanel.add(yearPubllabel); 
        JTextField yearPublfield = new JTextField(); 
        yearPublfield.setPreferredSize(new Dimension(90,20));
        yearPublpanel.add(yearPublfield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(yearPublpanel);
        // ********************** Δημιουργία Τόμου Περιοδικού Δημοσίευσης  ********************** 
        JPanel magTomospanel = new JPanel();
 
        JLabel magTomoslabel = new JLabel(" Τόμος Περιοδικού:"); //label 
        magTomoslabel.setForeground(Color.darkGray); // για γράμματα
        magTomospanel.add(magTomoslabel); 
        JTextField magTomosfield = new JTextField(); //χώρος που γράφουμε τίτλο
        magTomosfield.setPreferredSize(new Dimension(50,20));
        magTomospanel.add(magTomosfield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(magTomospanel);
        
        // ********************** Δημιουργία Website Περιοδικού Δημοσίευσης  ********************** 
        JPanel sitePostedpanel = new JPanel();
        JLabel sitePostedlabel = new JLabel("Ημερομηνία Δημοσίευσης Άρθρου: "); //label 
        sitePostedpanel.add(sitePostedlabel);
        sitePostedpanel.add(sitePostedlabel); 
        JTextField sitePostedfield = new JTextField(); 
        sitePostedfield.setPreferredSize(new Dimension(100,20));
        sitePostedpanel.add(sitePostedfield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(sitePostedpanel);
        
        // *************************** Προσθήκη γραφικου για Save Καταγραφής *************************** 
        JButton magAddbutton = new JButton(new ImageIcon("icons/addpaper.png"));
        magAddbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String title,magtitle,pagesPaper,tomos,sitePosted;
                LocalDate yearPubl;
                title =scienceMtfield.getText();
                magtitle = magTitlefield.getText();
                pagesPaper = pagesPaperfield.getText();//int
                tomos = magTomosfield.getText();//int
                sitePosted= sitePostedfield.getText();
                
                try {
                    yearPubl = LocalDate.parse(yearPublfield.getText());
                    
                    ScienceMagPaper p = new ScienceMagPaper (title,authorslist,magtitle,pagesPaper,yearPubl,tomos,sitePosted);

                    pf.out.writeObject(p);

                    JOptionPane.showMessageDialog(pf,  "Επιτυχής Εγγραφή Δημοσίευσης","Εγγραφή Δημοσίευσης",JOptionPane.INFORMATION_MESSAGE );

                }catch (DateTimeParseException ex){
                    JOptionPane.showMessageDialog(pf,  "Η ημερομηνία πρέπει να έχει την μορφή yyyy","Λάθος ημερομηνία",JOptionPane.INFORMATION_MESSAGE );

                } 
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(pf,  "Ανεπιτυχής Εγγραφή Δημοσίευσης","Εγγραφή Δημοσίευσης",JOptionPane.INFORMATION_MESSAGE );

                }
            }
        });
        this.add(magAddbutton);
        
    }
}
