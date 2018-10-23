package nl.erikruud;


import java.util.Calendar;
import java.util.List;

public class Toetsdeelname {
    private Calendar startTijd;
    private Calendar loopTijd;
    private String studentNaam;
    private int huidigeVraagNummer;
    private List<GesteldeVraag> gesteldeVragen;

    public int berekenBonus(){
        //TODO
        return 0;
    }
    public int getGebruikteTijd(){
        //TODO
        return 0;
    }

    /**
     * Koppeld een studentnaam aan deze toetsdeelname
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
    public float geefTotaalscore(){
        //TODO
        return 0;
    }
    public void setEersteVraag(){
        huidigeVraagNummer = 0;
    }
    public String getNaamVanStudent(){
        return studentNaam;
    }
}
