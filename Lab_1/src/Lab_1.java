
/*  icsd14151 Βασιλική Παπαδήμου  */

package lab_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Lab_1 {

    public static void main(String[] args) {
        
        try {
            ObjectOutputStream out;
            File file = new File("papers.txt");
            // Αν το αρχείο υπάρχει, τότε το ξαναανοίγουμε για append
            if (file.exists()){
                out  = new MyObjectOutputStream(new FileOutputStream(file,true));
            }
            // αλλιώς το ανοίγουμε για πρώτη φορά
            else{
                out  = new ObjectOutputStream(new FileOutputStream(file));
            }
            PapersFrame pf = new PapersFrame(out);
        } catch (IOException ex) {}
    }
    
}
