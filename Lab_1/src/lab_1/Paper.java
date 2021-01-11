
package lab_1;

import java.io.*;
import java.util.ArrayList;

// Για να μπορώ τα το δώ από τις κλάσεις παιδιά
public class Paper implements Serializable{
    protected String title;
    protected ArrayList<String> authorslist;
    //Constructor
    Paper(String title,ArrayList<String> authorslist){
        this.title = title;
        this.authorslist = new ArrayList<>();
        // για κάθε author που υπάρχει στην λίστα διέτρεξέ την
        for(int i=0;i<authorslist.size();i++){
            this.authorslist.add(new String(authorslist.get(i)));
        }
    }
    //Για να μπορέσω αργότερα στα panel του Author και του Title να περνάω τα 
    //σωστά στοιχεία στα γραφικάπου γίνονται στην PapersFrame
    boolean searchTitle(String title){
        return this.title.contains(title);
    }
    boolean searchAuthor(String author){
        //Για να ψάξω σε όλο το μήκος της authorlist και να επιστρέψω τον/τους συγγραφεις
        for(int i=0;i<authorslist.size();i++){
            //ελέγχω αν υπάρχει author στο i του authorlist που είμαι κατα το loop μου
            if (authorslist.get(i).contains(author))
                return true;
        }
        return false;
    }
    
}
