import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    List<Frame> frames;

    public Game() {
        frames = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            frames.add(new Frame());
        }
    }

    public int start(int first, int second) {
        frames.get(0).roll(first, second);
        for(int i = 1; i < frames.size(); i++){
            frames.get(i).roll(first, second);
            checkSpare(i);
            checkStrike(i);
        }
        return end();
    }

    private void checkSpare(int index) {
        if(frames.get(index-1).getIsSpare()) {
            Calculator.spareCalc(frames.get(index-1), frames.get(index));
        }
    }

    private void checkStrike(int index) {
        if(index >= 2) {
            calcStrike(index);
        }
    }

    private void calcStrike(int index) {
        if(frames.get(index-2).getIsStrike()) {
            Calculator.strikeCalc(frames.get(index-2), frames.get(index-1), frames.get(index));
        }
    }

    private int end() {
        return Calculator.totalCalc(frames);
    }
}
