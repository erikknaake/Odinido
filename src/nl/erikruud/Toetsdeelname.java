package nl.erikruud;


import java.util.Calendar;
import java.util.List;

public class Toetsdeelname {
    private Calendar startTijd;
    private Calendar loopTijd;
    private String studentNaam;
    private int huidigeVraagNummer;
    private List<GesteldeVraag> gesteldeVragen;

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
        while(huidigeVraagNummer < gesteldeVragen.size()) {
            if(true /*TODO: Student wil naar vorige vraag*/) {
                verlaagVraagnr();
            }

            if(true /*TODO: Student wil naar volgende vraag*/) {
                verhoogVraagnr();
            }

            GegevenAntwoord ga;
            if(gesteldeVragen.get(huidigeVraagNummer).isOpenVraag()) {
                String a = krijgAntwoord();
                ga = new GegevenAntwoordOpenVraag();
                ga.setGegevenAntwoord(a);
            }
            else {
                List<AntwoordGeslotenVraag> am = gesteldeVragen.get(huidigeVraagNummer).getAntwoordMogelijkheden();
                String a = krijgAntwoord(am);
                ga = new GegevenAntwoordGeslotenVraag();
                ga.setGegevenAntwoord(a);
                gesteldeVragen.get(huidigeVraagNummer).krijgScoreVoorAntwoord(ga);
            }
            int s = gesteldeVragen.get(huidigeVraagNummer).krijgScoreVoorAntwoord(ga);
            verhoogScore(s);
        }
    }

    public void verhoogScore(int s){
        //TODO
    }

    public void verlaagVraagnr(){
        huidigeVraagNummer--;
    }
    public void verhoogVraagnr(){
        huidigeVraagNummer++;
    }
    public String krijgAntwoord(){
        //TODO
        return new String();
    }
    public String krijgAntwoord(List<AntwoordGeslotenVraag> mogelijkheden){
        //TODO
        return new String();
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
