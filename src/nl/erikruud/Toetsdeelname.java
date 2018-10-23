package nl.erikruud;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Toetsdeelname {
    private Calendar startTijd;
    private Calendar loopTijd;
    private String studentNaam;
    private int huidigeVraagNummer;
    private List<GesteldeVraag> gesteldeVragen;

    private float totaalScore;

    public Toetsdeelname(Calendar startTijd, Calendar loopTijd, Kennistoets k) {
        totaalScore = 0;
        gesteldeVragen = new ArrayList<>();
        this.loopTijd = loopTijd;
        this.startTijd = startTijd;
        initGesteldeVragen(k);
    }

    private void initGesteldeVragen(Kennistoets k) {
        gesteldeVragen = new ArrayList<>();
        List<VraagInKennistoets> vragenInKennisToets = k.getVragenInKennistoets();
        for(VraagInKennistoets vraagInKennistoets : vragenInKennisToets) {
            gesteldeVragen.add(vraagInKennistoets.maakGesteldeVraag());
        }
    }

    /**
     * Vindt het verschil tussen de huidige tijd en de starttijd van de deelname
     * @return Tijd dat de deelnemer heeft gedaan over de kennistoets
     */
    public Calendar getGebruikteTijd(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, Calendar.getInstance().compareTo(startTijd));
        return cal;
    }

    public Calendar getTijdOver() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MILLISECOND, loopTijd.compareTo(getGebruikteTijd()));
        return cal;
    }

    /**
     * Koppelt een studentnaam aan deze toetsdeelname
     * @param naam de studentNaam van de student aan wie deze deelname toebehoort
     */
    public void voegDeelnemerToe(String naam){
        this.studentNaam = naam;
        setEersteVraag();
        while(huidigeVraagNummer < gesteldeVragen.size()) { //TODO: tijd constriant
            System.out.println("Typ uw antwoord, of type t voor terug en v voor verder");
            gesteldeVragen.get(huidigeVraagNummer).stelVraag();
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();

            if(input.equals("t")) {
                verlaagVraagnr();
                continue;
            }
            else if(input.equals("v")) {
                verhoogVraagnr();
                continue;
            }
            GegevenAntwoord ga;
            if(gesteldeVragen.get(huidigeVraagNummer).isOpenVraag()) {
                ga = new GegevenAntwoordOpenVraag();
                ga.setGegevenAntwoord(input);
            }
            else {
                List<AntwoordGeslotenVraag> am = gesteldeVragen.get(huidigeVraagNummer).getAntwoordMogelijkheden();
                String a = krijgAntwoord(am, input);
                ga = new GegevenAntwoordGeslotenVraag();
                ga.setGegevenAntwoord(a);
                gesteldeVragen.get(huidigeVraagNummer).krijgScoreVoorAntwoord(ga);
            }
            int sc = gesteldeVragen.get(huidigeVraagNummer).krijgScoreVoorAntwoord(ga);
            verhoogScore(sc);
            verhoogVraagnr();
            //TODO aangeven wanneer klaar ipv wanneer laatste vraag is beantwoord
        }
    }

    public void verhoogScore(int s){
        totaalScore += s;
    }

    public void verlaagVraagnr(){
        if(huidigeVraagNummer > 0)
            huidigeVraagNummer--;
    }
    public void verhoogVraagnr(){
        if(huidigeVraagNummer < gesteldeVragen.size())
            huidigeVraagNummer++;
    }


    public String krijgAntwoord(List<AntwoordGeslotenVraag> mogelijkheden, String input) {
        while(!isInputValid(mogelijkheden, input)) {
            Scanner s = new Scanner(System.in);
            input = s.next();
        }
        return input;
    }

    private boolean isInputValid(List<AntwoordGeslotenVraag> mogelijkheden, String antwoord) {
        for(AntwoordGeslotenVraag a : mogelijkheden) {
            if(a.getTekst().equals(antwoord)) {
                return true;
            }
        }
        return false;
    }

    public float geefTotaalscore(){
        float totaalScore = 0;
        for(GesteldeVraag gv : gesteldeVragen) {
            totaalScore += gv.getScore();
        }
        return totaalScore;
    }

    public void setEersteVraag(){
        huidigeVraagNummer = 0;
    }
    public String getNaamVanStudent(){
        return studentNaam;
    }
}
