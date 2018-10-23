package nl.erikruud;

import java.util.List;

public class Odinido {
    private List<Docent> docenten;

    /**
     * Stelt een kennistoets beschikbaar voor studenten
     * @param toetscode de code van de toets die moet worden open gesteld
     * @param docentCode de docent die de kennistoets open wil stellen
     */
    public void openKennistoets(String toetscode, String docentCode){
        Docent d = getDocent(docentCode);
        d.startKennistoets(toetscode);
    }

    /**
     * Voegt een nieuw lokaal toe aan een docent
     * @param lokaalNummer het nummer van het toe te voegen lokaal
     * @param docentCode de docent waaraan het lokaal moet worden toegevoegd
     */
    public void registreerLokaal(int lokaalNummer, String docentCode){
        Docent d = getDocent(docentCode);
        addDocent(d);
        d.registreerLokaal(lokaalNummer);
    }

    /**
     * Voegt een docent toe aan de lijst van docenten.
     * @param d Docent om toe te voegen
     */
    private void addDocent(Docent d) {
        docenten.add(d);
    }


    /**
     * Zoekt een docent op, op basis van een docentcode
     * @param docentCode de code van de docent die opgezocht moet worden
     * @return de gevonden docent
     */
    private Docent getDocent(String docentCode){
        for(Docent d : docenten) {
            if(d.getDocentcode().equals(docentCode))
                return d;
        }
        return null;
    }

    /**
     * Laat een student deelnemen aan een kennistoets
     * @param lokaalNummer het lokaal waar de student aan deel wil nemen
     * @param naam de naam van de student die wil deelnemen aan de kennistoets
     */
    public void neemDeelAanKennistoets(int lokaalNummer, String naam){
        //TODO
        Lokaal l = null;
        for(Docent d : docenten) {
            l = d.getLokaal(lokaalNummer);
            if(d.getLokaal(lokaalNummer) != null) {
                break;
            }
        }
        if(l == null) {
            System.out.println("Kon lokaal niet vinden");
            return;
        }
        l.voegDeelnemerToe(naam);
    }

    public void haalUitslagOverzichtOp(int lokaalNummer, String docentCode) {
        Docent d = getDocent(docentCode);
        System.out.println(d.haalUitslagOverzichtOp(lokaalNummer));
    }
}
