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

public class ConferencePanel extends JPanel{
    PapersFrame pf;
    ConferencePanel(PapersFrame pf){
        this.pf = pf;
        ArrayList<String> authorslist = new ArrayList<>();

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // ********************** Δημιουργία Τίτλος Εργασίας (χώρο και Label) ********************** 
        JPanel conftitlepanel = new JPanel();
        conftitlepanel.setOpaque(true);
        
        JLabel conftitlelabel = new JLabel("Τίτλος Άρθρου:"); //label 
        conftitlelabel.setForeground(Color.darkGray);
        conftitlepanel.add(conftitlelabel); 
        JTextField conftitlefield = new JTextField(); //χώρος που γράφουμε τίτλο
        conftitlefield.setPreferredSize(new Dimension(100,20));
        conftitlepanel.add(conftitlefield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(conftitlepanel);
   
        // *************************** Δημιουργία Label Συγγραφείς Εργασίας *************************** 
        JPanel confauthorspanel = new JPanel();
        JLabel confauthorslabel = new JLabel("Συγγραφείς:");
        confauthorspanel.add(confauthorslabel);
        JTextField confauthorsfield = new JTextField();//χώρος που γράφουμε τον συγγραφέα
        confauthorsfield.setPreferredSize(new Dimension(100,20));
        confauthorspanel.add(confauthorsfield); // εμφανίζει το text field για να γράψουμε το ονομα του συγγραφέα
        JTextArea confauthorsarea = new JTextArea();
        confauthorsarea.setEditable(false);//δεν μπορω να πληκτρολογήσω μέσα 
        JScrollPane sp = new  JScrollPane(confauthorsarea); //πολλοί οι συγγραφείς, κανει scroll down

        // **************************** Γραφικό για προσθήκη συγγραφέα ****************************
        JButton confauthoradd = new JButton(new ImageIcon("icons/addauthor.png"));         
        confauthoradd.setToolTipText("Προσθήκη Συγγραφέα"); //βοηθητικό κείμενο για την λειτουργεία του κουμπιου
        //θέλω το ActionListener για τον συγγραφέα
        confauthoradd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                confauthorsarea.append(confauthorsfield.getText()+"\n");
                authorslist.add(confauthorsfield.getText());
            }
        });
        this.add(sp);
        confauthorspanel.add(confauthoradd);// εμφανίζει το κουμπι για προσθήκη συγγραφέα
        

        // **************************** Γραφικό για διαγραφή συγγραφέα ****************************
        JButton confauthorremove = new JButton(new ImageIcon("icons/removeauthors.png"));
        confauthorremove.setToolTipText("Διαγραφή Συγγραφέων");//βοηθητικό κείμενο για την λειτουργεία του κουμπιου
        
        confauthorremove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                confauthorsarea.setText(null);
                authorslist.clear();
            }
        });
        confauthorspanel.add(confauthorremove);
        this.add(confauthorspanel);
        
        // *************************** Δημιουργία Label για Συνέδριο / Πολη / Ημερομηνία  *************************** 

        JPanel confNamepanel = new JPanel();
        JLabel confNamelabel = new JLabel("Όνομα συνεδρίου: "); //label 
        confNamepanel.add(confNamelabel); 
        JTextField confNamefield = new JTextField(); //χώρος που γράφουμε τίτλο
        confNamefield.setPreferredSize(new Dimension(200,20));
        confNamepanel.add(confNamefield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(confNamepanel);
        
        JPanel citypanel = new JPanel();
        JLabel citylabel = new JLabel("Πόλη διεξαγωγής συνεδρίου: "); //label 
        citypanel.add(citylabel); 
        JTextField cityfield = new JTextField(); 
        cityfield.setPreferredSize(new Dimension(90,20));
        citypanel.add(cityfield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(citypanel);
        
        JPanel datepanel = new JPanel();
        JLabel datelabel = new JLabel("Ημερομηνία διεξαγωγής συνεδρίου: "); //label 
        datepanel.add(datelabel);
        datepanel.add(datelabel); 
        JTextField datefield = new JTextField(); 
        datefield.setPreferredSize(new Dimension(90,20));
        datepanel.add(datefield); //έτσι εμφανίζεται η Label και ο τίτλος που γράψαμε
        this.add(datepanel);
        
        
        // *************************** Προσθήκη γραφικου για Save Καταγραφής *************************** 
        JButton confaddbutton = new JButton(new ImageIcon("icons/addpaper.png"));
        //this.setBackground(Color.LIGHT_GRAY);

        confaddbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = conftitlefield.getText();
                String confName,city;
                LocalDate date;
                confName = confNamefield.getText();
                city = cityfield.getText();
             
                try {
                    date = LocalDate.parse(datefield.getText()+"-01");
                    ConferencePaper p = new ConferencePaper(title,authorslist,confName,date,city);

                    pf.out.writeObject(p);

                    JOptionPane.showMessageDialog(pf,  "Επιτυχής Εγγραφή Δημοσίευσης","Εγγραφή Δημοσίευσης",JOptionPane.INFORMATION_MESSAGE );

                }catch (DateTimeParseException ex){
                    JOptionPane.showMessageDialog(pf,  "Η ημερομηνία πρέπει να έχει την μορφή yyyy-mm","Λάθος ημερομηνία",JOptionPane.INFORMATION_MESSAGE );

                } 
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(pf,  "Ανεπιτυχής Εγγραφή Δημοσίευσης","Εγγραφή Δημοσίευσης",JOptionPane.INFORMATION_MESSAGE );

                }
            }
        });
        this.add(confaddbutton);
    }
}
