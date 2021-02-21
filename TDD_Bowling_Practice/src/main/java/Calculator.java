import java.util.List;

public class Calculator {

    public static int totalCalc(List<Frame> frames) {
        int sum = 0;
        for (Frame frame : frames) {
            sum += frame.score;
        }
        return sum;
    }

    public static void spareCalc(Frame first, Frame second) {
        first.score += second.score;
    }
}
