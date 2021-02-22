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
        for(int i = 0; i < frames.size(); i++){
            frames.get(i).roll(first, second);
            if(i >= 1) {
                if(frames.get(i-1).getIsSpare()) {
                    Calculator.spareCalc(frames.get(i-1), frames.get(i));
                }
            }
            if(i >= 2) {
                if(frames.get(i-2).getIsStrike()) {
                    Calculator.strikeCalc(frames.get(i-2), frames.get(i-1), frames.get(i));
                }
            }
        }
        return end();
    }

    private int end() {
        return Calculator.totalCalc(frames);
    }
}
