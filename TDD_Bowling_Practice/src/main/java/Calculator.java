import java.util.List;

public class Calculator {

    public static int totalCalc(List<Frame> frames) {
        int sum = 0;
        for (int i = 0; i < frames.size()-2; i++) {
            sum += frames.get(i).getScore();
        }
        return sum;
    }

    public static void spareCalc(Frame first, Frame second) {
        int score = first.getScore() + second.getFirstScore();
        first.setScore(score);
    }

    public static void strikeCalc(Frame first, Frame second, Frame third) {
        int score = first.getScore() + second.getFirstScore() + third.getFirstScore();
        first.setScore(score);
    }
}
