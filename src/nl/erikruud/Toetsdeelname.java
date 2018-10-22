package nl.erikruud;

import com.sun.xml.internal.bind.v2.TODO;

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
    public void voegDeelnemerToe(String naam){
        //TODO
    }
    public void verhoogScore(int s){
        //TODO
    }
    public void verlaagVraagnr(){
        //TODO
    }
    public void verhoogVraagnr(){
        //TODO
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
        //TODO
    }
    public String getNaamVanStudent(){
        //TODO
        return new String();
    }
}
