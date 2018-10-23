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

    public Toetsdeelname(Calendar startTijd, Calendar loopTijd) {
        totaalScore = 0;
        gesteldeVragen = new ArrayList<>();
        this.loopTijd = loopTijd;
        this.startTijd = startTijd;
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

    /**
     * Koppelt een studentnaam aan deze toetsdeelname
     * @param naam de studentNaam van de student aan wie deze deelname toebehoort
     */
    public void voegDeelnemerToe(String naam){
        this.studentNaam = naam;
        setEersteVraag();
        while(huidigeVraagNummer < gesteldeVragen.size() && getGebruikteTijd().compareTo(loopTijd) < 0) {
            System.out.println("Typ uw antwoord, of type t voor terug en v voor verder");
            Scanner s = new Scanner(System.in);
            String input = s.next();

            GegevenAntwoord ga;
            if(gesteldeVragen.get(huidigeVraagNummer).isOpenVraag()) {
                String a = krijgAntwoord(input);
                ga = new GegevenAntwoordOpenVraag();
                ga.setGegevenAntwoord(a);
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

            if(input.equals("t")) {
                verlaagVraagnr();
            }
            else if(input.equals("v")) {
                verhoogVraagnr();
            }
        }
    }

    public void verhoogScore(int s){
        totaalScore += s;
    }

    public void verlaagVraagnr(){
        huidigeVraagNummer--;
    }
    public void verhoogVraagnr(){
        huidigeVraagNummer++;
    }

    public String krijgAntwoord(String input){
//        System.out.println("Typ uw antwoord: ");
//        return s.next();
        return new String();
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
//        float totaalScore = 0;
//        for(GesteldeVraag gv : gesteldeVragen) {
//            totaalScore += gv.getScore();
//        }
        return totaalScore;
    }

    public void setEersteVraag(){
        huidigeVraagNummer = 0;
    }
    public String getNaamVanStudent(){
        return studentNaam;
    }
}
