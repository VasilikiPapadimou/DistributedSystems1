
package lab_1;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConferencePaper extends Paper{
    private String confName,city;
    private LocalDate date;
    // Constructor
    ConferencePaper(String title,ArrayList<String> authorslist,String confName,LocalDate date,String city){
        super(title,authorslist);
        this.confName=confName;
        this.date = date;
        this.city=city;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(); // για concatenation του τίτλου
        sb.append("Τίτλος άρθρου: ").append(title);
        sb.append("Συγγραφείς: ");
        for(int i=0;i<authorslist.size();i++){// διατρέχει την authorlist ξεκινώντας από την αρχή
            //και ενώνει τον author που βρήκε με StringBuilder (\n-> αφήνωντας μία σειρά κενή)
            sb.append(authorslist.get(i) + " ");
        }
        sb.append("Όνομα συνεδρίου: ").append(confName);
        sb.append("Μήνας και Έτος Διεξαγωγής Συνεδρίου: ").append(date);
        sb.append("\n");
        return sb.toString();
    }
}