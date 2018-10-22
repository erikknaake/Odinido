package nl.erikruud;

import java.util.Calendar;

public class Lokaal {
    private int lokaalNummer;
    private Toetsuitvoering toetsuitvoering;

    public Lokaal(int lokaalNummer){
        this.lokaalNummer = lokaalNummer;
    }
    public String getUitslagOverzicht(){
        //TODO
        return new String();
    }
    public void startKennistoets(Kennistoets k, Calendar t1, Calendar t2){
        //TODO
    }
    public void voegDeelnemerToe(String naam) {
        //TODO
    }
    public void voegToetsuitvoeringToe(Toetsuitvoering tu){
        //TODO
    }
}
