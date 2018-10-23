package nl.erikruud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Toetsuitvoering {
    private Calendar startTijd;
    private Calendar looptijd;
    private Kennistoets kennistoets;
    private List<Toetsdeelname> toetsDeelnames;
    private String overzicht;

    public Toetsuitvoering(Kennistoets k, Calendar t1, Calendar t2){
        this.toetsDeelnames = new ArrayList<>();
        this.startTijd = t1;
        this.looptijd = t2;
        this.kennistoets = k;
        overzicht = "";
    }

    public String getUitslagOverzicht(){
        overzicht = "";
        for(Toetsdeelname td : toetsDeelnames) {
            float r = td.geefTotaalscore();
            Calendar tijd = td.getTijdOver();
            int bonus = kennistoets.getTijdsbonus(tijd);
            addToOverzicht(r, bonus, td.getNaamVanStudent());
        }
        addToOverzicht(kennistoets.getTitel(), kennistoets.getToetscode());
        return overzicht;
    }

    public void addToOverzicht(String titel, String code){
        overzicht += ("Titel: " + titel + "\nToetsCode: " + code + "\n");
    }

    public void addToOverzicht(float r, int bonus, String naam){
        overzicht += (naam + ": " + r + " " + bonus + "Totaal: " + (r + bonus));
    }

    /**
     * Voegt een deelname toe aan de lijst met toetsdeelnames
     * @param naam de naam van de student die wil deelnemen aan de toets
     */
    public void voegDeelnemerToe(String naam){
        Toetsdeelname t = new Toetsdeelname(startTijd, looptijd, kennistoets);
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
