package nl.erikruud;

import java.util.Calendar;

public class TijdsbonusVoorKennistoets {
    private Calendar van;
    private Calendar tot;
    private Tijdsbonus tijdsbonus;

    public TijdsbonusVoorKennistoets(Calendar van, Calendar tot, Tijdsbonus tijdsbonus) {
        this.van = van;
        this.tot = tot;
        this.tijdsbonus = tijdsbonus;
    }

    public boolean isHuidigeTijdsBonnus() {
        return Calendar.getInstance().compareTo(van) > 0 && Calendar.getInstance().compareTo(tot) < 0;
    }

    /**
     * Haalt de bonus op die op dit moment bij een kennistoets hoort
     * @param tijdOver de tijd die de student over had
     * @return de berekende bonus
     */
    public int getbonus(Calendar tijdOver){
        return tijdsbonus.getTijdsBonus(tijdOver);
    }
}
