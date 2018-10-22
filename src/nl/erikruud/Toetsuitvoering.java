package nl.erikruud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Toetsuitvoering {
    private Calendar startTijd;
    private Calendar looptijd;
    private Kennistoets kennistoets;
    private List<Toetsdeelname> toetsDeelnames;

    public Toetsuitvoering(){
        toetsDeelnames = new ArrayList<>();
    }

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

    /**
     * Voegt een deelname toe aan de lijst met toetsdeelnames
     * @param naam de naam van de student die wil deelnemen aan de toets
     */
    public void voegDeelnemerToe(String naam){
        Toetsdeelname t = new Toetsdeelname();
        t.voegDeelnemerToe(naam);
        toetsDeelnames.add(t);
    }

    /**
     * Geeft een toetsdeelname terug op basis van de index in de collectie met toetsdeelnames
     * @param index de index van de gewenste toetsdeelname
     * @return de toetsdeelname behorende bij het gegeven indexnummer
     */
    public Toetsdeelname getToetsdeelname(int index){
        return toetsDeelnames.get(index);
    }
}
