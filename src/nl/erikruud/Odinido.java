package nl.erikruud;

import java.util.List;

public class Odinido {
    private List<Docent> docenten;

    public static void main(String[] args) {
	// write your code here
    }

    /**
     * Stelt een kennistoets beschikbaar voor studenten
     * @param toetscode de code van de toets die moet worden open gesteld
     * @param docentCode de docent die de kennistoets open wil stellen
     */
    private void openKennistoets(String toetscode, String docentCode){
        //TODO
    }

    /**
     * Voegt een nieuw lokaal toe aan een docent
     * @param lokaalNummer het nummer van het toe te voegen lokaal
     * @param docentCode de docent waaraan het lokaal moet worden toegevoegd
     */
    private void registreerLokaal(int lokaalNummer, String docentCode){
        //TODO
    }

    /**
     * Zoekt een docent op, op basis van een docentcode
     * @param docentCode de code van de docent die opgezocht moet worden
     * @return de gevonden docent
     */
    public Docent getDocent(String docentCode){
        //TODO
        return new Docent();
    }

    /**
     * Laat een student deelnemen aan een kennistoets
     * @param lokaalNummer het lokaal waar de student aan deel wil nemen
     * @param naam de naam van de student die wil deelnemen aan de kennistoets
     */
    public void neemDeelAanKennistoets(int lokaalNummer, String naam){
        //TODO
    }
}
