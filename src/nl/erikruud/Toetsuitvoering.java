package nl.erikruud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Een toetsuitvoering is de uitvoering van een willekeurige toets binnen een lokaal
 */
public class Toetsuitvoering {
    private Calendar startTijd;
    private Calendar looptijd; //TODO: toets dicht zetten nadat tijd is verlopen
    private Calendar looptijdStudent; //TODO: verwerken in DCD
    private Kennistoets kennistoets;
    private List<Toetsdeelname> toetsDeelnames;
    private String overzicht;

    /**
     * Maakt een nieuwe toetsuitvoering aan op basis van de meegegeven informatie
     * @param k de kennistoets waarvoor een uitvoering moet worden gestart
     * @param t1 de tijd dat de uitvoering duurt
     * @param t2 de tijd die een deelnemer aan de toets mag besteden
     */
    public Toetsuitvoering(Kennistoets k, Calendar t1, Calendar t2){
        this.toetsDeelnames = new ArrayList<>();
        this.startTijd = Calendar.getInstance();
        this.looptijd = t1;
        looptijdStudent = t2;
        this.kennistoets = k;
        overzicht = "";
    }

    /**
     * Haalt het uitslagoverzicht op van alle deelnemers van de huidige toetsuitvoering
     * @return het uitslagovericht van de huidige toetsuitvoering
     */
    public String getUitslagOverzicht(){
        overzicht = "";
        addToOverzicht(kennistoets.getTitel(), kennistoets.getToetscode());
        for(Toetsdeelname td : toetsDeelnames) {
            float r = td.geefTotaalscore();
            Calendar tijd = td.getTijdOver();
            int bonus = kennistoets.getTijdsbonus(tijd);
            addToOverzicht(r, bonus, td.getNaamVanStudent());
        }

        return overzicht;
    }

    /**
     * Voegt een titel en code toe aan het uitslagoverzicht
     * @param titel de toe te voegen titel
     * @param code de toe te voegen code
     */
    public void addToOverzicht(String titel, String code){
        overzicht += ("Titel: " + titel + "\nToetsCode: " + code + "\n");
    }

    /**
     * Voegt de prestaties van een student toe aan het uitslagoverzicht
     * @param r de totaalscore van de student
     * @param bonus de verkregen bonus
     * @param naam de naam van de student
     */
    public void addToOverzicht(float r, int bonus, String naam){
        overzicht += (naam + ":\n\tScore: " + r + "\n\t" + bonus + "\n\tTotaal: " + (r + bonus) + "\n");
    }

    /**
     * Voegt een deelname toe aan de lijst met toetsdeelnames
     * @param naam de naam van de student die wil deelnemen aan de toets
     */
    public void voegDeelnemerToe(String naam){
        Toetsdeelname t = new Toetsdeelname(Calendar.getInstance(), looptijdStudent, kennistoets);
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
