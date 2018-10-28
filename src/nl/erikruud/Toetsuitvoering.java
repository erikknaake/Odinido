package nl.erikruud;

import java.util.*;

/**
 * Een toetsuitvoering is de uitvoering van een willekeurige toets binnen een lokaal
 */
public class Toetsuitvoering extends Observable implements Runnable {
    private Calendar startTijd;
    private Calendar looptijd;
    private Calendar looptijdStudent;
    private Kennistoets kennistoets;
    private List<Toetsdeelname> toetsDeelnames;
    private String overzicht;
    private Thread thread;
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
        thread = new Thread(this);
        thread.start();
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
        if(toetsDeelnames.size() < 50) {
            Toetsdeelname t = new Toetsdeelname(Calendar.getInstance(), looptijdStudent, kennistoets);
            t.voegDeelnemerToe(naam);
            toetsDeelnames.add(t);
            addObserver(t);
        }
        else
            System.out.println("Het lokaal is vol");
    }

    /**
     * Geeft een toetsdeelname terug op basis van de index in de collectie met toetsdeelnames
     * @param index de index van de gewenste toetsdeelname
     * @return de toetsdeelname behorende bij het gegeven indexnummer
     */
    public Toetsdeelname getToetsdeelname(int index){
        return toetsDeelnames.get(index);
    }

    @Override
    public void run() {
        while(toetsLooptNog()) {
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Controleert of de duur dat een toets open mag staan is verstreken
     * @return of de toets nog open staat
     */
    private boolean toetsLooptNog() {
        return CalendarUtils.isCalGroterDanEpoch(CalendarUtils.substractCalendars(looptijd, CalendarUtils.substractCalendars(Calendar.getInstance(), startTijd)));
    }
}
