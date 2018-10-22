package nl.erikruud;

import java.util.Calendar;
import java.util.List;

public class Toetsuitvoering {
    private Calendar startTijd;
    private Calendar looptijd;
    private Kennistoets kennistoets;
    private List<Toetsdeelname> toetsDeelnames;

    public String getUitslagOverzicht(){
        //TODO
        return new String();
    }
    public void addToOverzicht(String titel, String code){
        //TODO
    }
    public void addToOverzicht(float r, int bonus, String naam){
        //TODO
    }
    public void Toetsuitvoering(Kennistoets k, Calendar t1, Calendar t2){
        //TODO
    }
    public void voegDeelnemerToer(String naam){
        //TODO
    }
    public Toetsdeelname getToetsdeelname(int index){
        //TODO
        return new Toetsdeelname();
    }
}
