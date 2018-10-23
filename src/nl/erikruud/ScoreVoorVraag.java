package nl.erikruud;

import java.util.Calendar;

public class ScoreVoorVraag {
    private Calendar van;
    private Calendar tot;
    private Score score;

    public boolean isHuidigeScoreBijVraag(){
        return Calendar.getInstance().compareTo(tot) < 0 && Calendar.getInstance().compareTo(van) > 0;
    }


    public int getScore(){
        return score.getScore();
    }
}
