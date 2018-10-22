package nl.erikruud;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Docent {
    private String email;
    private String voornaam;
    private String achternaam;
    private String wachtwoord;
    private String docentCode;
    private boolean isPremiumDocent;
    protected List<Lokaal> lokalen;

    public Docent(){
        isPremiumDocent = false;
        lokalen = new ArrayList<>();
    }

    public void haalUitslagOverzichtOp(){
        //TODO
    }
    public void getLokaal(int lokaalNummer){
        //TODO
    }
    public Lokaal selecteerLokaal(){
        //TODO
        return new Lokaal();
    }
    public Calendar selecteerMaximumDeelnameDuur(){
        //TODO
        return Calendar.getInstance();
    }
    public Kennistoets getKennistoets(String toetscode){
        //TODO
        return new Kennistoets();
    }
    public Lokaal getStandaardLokaal(){
        //TODO
        return new Lokaal();
    }
    public Calendar selecteerTijdOpen(){
        //TODO
        return Calendar.getInstance();
    }
    public void registreerLokaal(int lokaalNummer){
        //TODO
    }
    public void addLokaal(Lokaal l){
        //TODO
    }
    public String haalUitslagOverzichtOp(int lokaalNummer){
        //TODO
        return new String();
    }
    public void startKennistoets(String docentcode,String toetscode){
        //TODO
    }
     public String getDocentcode(){
        //TODO
         return new String();
     }
}
