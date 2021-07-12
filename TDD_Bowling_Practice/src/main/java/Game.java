import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    List<Frame> frames;

    //게임을 초기화하는 메서드
    public Game() {
        initFrames();
    }

    private void initFrames() {
        frames = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            frames.add(new Frame());
        }
    }

    /**
     * 게임을 시작하는 메서드
     * @param first 첫번째로 던진 공의 점수
     * @param second 두번째로 던진 공의 점수
     * @return end() 메서드를 호출함으로써 총합점수를 구한다
     */
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
            calcSpare(index);
        }
    }

    private void calcSpare(int index) {
        Calculator.spareCalc(frames.get(index-1), frames.get(index));
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
