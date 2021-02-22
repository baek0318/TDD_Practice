public class Frame {

    private int score;
    private int firstScore;
    private int secondScore;
    private boolean isSpare;
    private boolean isStrike;

    public Frame() {
        this.score = 0;
        this.firstScore = 0;
        this.secondScore = 0;
        this.isSpare = false;
        this.isStrike = false;
    }

    public void roll(int first_score, int second_score) {
        this.firstScore = first_score;
        this.secondScore = second_score;
        int sum = firstScore+secondScore;
        if(sum == 10) {
            if(first_score == 10) {
                this.isStrike = true;
            }
            else {
                this.isSpare = true;
            }
        }
        score = sum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public boolean getIsSpare() {
        return isSpare;
    }

    public boolean getIsStrike() {
        return isStrike;
    }
}
