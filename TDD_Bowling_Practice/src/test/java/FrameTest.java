import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class FrameTest {

    //게임이 올바르다는 것을 검증할 테스트
    //Todo 0. 각 프레임은 두번의 점수를 가지게 된다
    //Todo 1. 각 프레임마다의 점수의 누적합을 구할 수 있어야 한다
    //Todo 2. 스페어를 하면 자신의 점수가 Frame.score = 10 + Next_Frame.score 되어야한다
    //Todo 3. 스트라이크를 하면 자신의 점수가 Frame.score = 10 + First_Next_Frame.score + Second_Next_Frame.score 되어야한다
    //Todo 4. 마지막 프레임 스트라이크인 경우 +2 프레임 추가제공
    //Todo 5. 마지막 프레임 스페어인 경우 +1 프레임 추가제공

    //0번 처리
    //Todo 0. 각 프레임은 두번의 점수를 가지게 된다 (완료)
    //Todo 0-1. score, first, second를 private로 만들기
    @Test
    @DisplayName("Score = first + second")
    void testFrameFirstSecond() {
        Frame frame = new Frame();
        frame.roll(3, 5);

        Assertions.assertEquals(8, frame.getScore());
    }

    //1번 처리
    //Todo 1. 각 프레임마다의 점수의 누적합을 구할 수 있어야 한다 (완료)
    @Test
    @DisplayName("누적 점수 계산")
    void testTotalScore() {
        Frame frame1 = new Frame();
        frame1.roll(5,3);
        Frame frame2 = new Frame();
        frame2.roll(5,3);
        Frame frame3 = new Frame();
        frame3.roll(5,3);
        Frame frame4 = new Frame();
        frame4.roll(5,3);
        Frame frame5 = new Frame();
        frame5.roll(5,3);

        List<Frame> frames = new ArrayList<>();
        frames.add(frame1); frames.add(frame2); frames.add(frame3); frames.add(frame4); frames.add(frame5);
        int result = Calculator.totalCalc(frames);

        Assertions.assertEquals(24, result);
    }

    //2번 처리 스페어시에 점수 계산하기!!
    //Todo 스페어가 발생했을 때의 점수 계산하기 Frame.score = 10 + Next_Frame.score (완료)
    //Todo 다음 프레임에게 자신이 스페어라는 것을 알려줄 수 있어야 한다 (완료)

    @Test
    @DisplayName("스페어라는 것을 표시하기")
    void testSpareFlag() {
        Frame frame = new Frame();
        frame.roll(5,5);
        Frame frame2 = new Frame();
        frame2.roll(5,3);

        Assertions.assertTrue(frame.getIsSpare());
        Assertions.assertFalse(frame2.getIsSpare());
    }

    @Test
    @DisplayName("스페어 계산하기")
    void testSpareCalc() {
        Frame frame = new Frame();
        frame.roll(5,5);
        Frame frame2 = new Frame();
        frame2.roll(5,3);

        Calculator.spareCalc(frame, frame2);

        Assertions.assertEquals(15, frame.getScore());
        Assertions.assertNotEquals(10, frame.getScore());
        Assertions.assertEquals(8, frame2.getScore());
    }

    //3번 처리
    //Todo 스트라이크가 발생했을 때 점수 계산 Frame.score = 10 + First_Next_Frame.score + Second_Next_Frame.score (완료)
    //Todo 자신이 스트라이크라는 것을 알려줘야 한다 (완료)

    @Test
    @DisplayName("스트라이크 표시하기")
    void testStrikeFlag() {
        Frame frame = new Frame();
        frame.roll(10, 0);
        Frame frame2 = new Frame();
        frame2.roll(5, 5);

        Assertions.assertTrue(frame.getIsStrike());
        Assertions.assertFalse(frame2.getIsStrike());
    }

    @Test
    @DisplayName("Strike Score = first + second + third")
    void testStrikeScore() {
        Frame frame = new Frame();
        frame.roll(10, 0);
        Frame frame2 = new Frame();
        frame2.roll(6, 3);
        Frame frame3 = new Frame();
        frame3.roll(5, 4);

        Calculator.strikeCalc(frame, frame2, frame3);
        Assertions.assertEquals(21, frame.getScore());
    }

}
