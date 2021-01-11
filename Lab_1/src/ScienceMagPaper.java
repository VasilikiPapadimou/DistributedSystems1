package lab_1;

import java.time.LocalDate;
import java.util.ArrayList;

public class ScienceMagPaper extends Paper{
    private String magtitle, sitePosted;
    private String pages, tomos ;
    private LocalDate yearPubl;
     
    ScienceMagPaper(String title,ArrayList<String> authorslist,String magtitle,String pages,LocalDate yearPubl,String tomos,String sitePosted){
        super(title,authorslist);
        this.magtitle = magtitle;
        this.pages=pages;
        this.yearPubl= yearPubl;
        this.tomos=tomos;
        this.sitePosted=sitePosted;
    } 
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Τίτλος άρθρου: ").append(title);
        sb.append("Συγγραφείς: ");
        for(int i=0;i<authorslist.size();i++){
            sb.append(authorslist.get(i) + " ");
        }
        sb.append("Τίτλος περιοδικου δημοσίευσης άρθρου: ").append(magtitle);
        sb.append("Αριθμός Σελίδων Άρθρου: ").append(pages);
        sb.append("Έτος Δημοσίευσης: ").append(yearPubl);
        sb.append("Τόμος: ").append(tomos);
        sb.append("Website που δημοσιευτηκε: ").append(sitePosted);
        sb.append("\n");
        return sb.toString();
    }
}
