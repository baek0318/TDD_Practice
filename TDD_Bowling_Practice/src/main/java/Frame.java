public class Frame {

    public int score;

    public boolean isSpare;

    public Frame() {
        this.score = 0;
        this.isSpare = false;
    }

    public void roll(int first_score, int second_score) {
        int sum = first_score+second_score;
        if(sum == 10) {
            this.isSpare = true;
        }
        score = sum;
    }
}
