package nl.erikruud;

import java.util.Calendar;

/**
 * Een tijdsbonus is een bonus die verkregen wordt voor het voortijdig afronden van een kennistoets
 */
public class Tijdsbonus {
    private int bonusPerMinuutOver;

    public Tijdsbonus(int bonusPerMinuutOver) {
        this.bonusPerMinuutOver = bonusPerMinuutOver;
    }

    /**
     * Berekend een tijdsbonus op basis van een vaste formule
     * @param tijdOver de tijd dat de student over de kennistoets heeft gedaan
     * @return de bonus die de student krijgt
     */
    public int getTijdsBonus(Calendar tijdOver){
        return bonusPerMinuutOver * tijdOver.get(Calendar.MINUTE);
    }
}
