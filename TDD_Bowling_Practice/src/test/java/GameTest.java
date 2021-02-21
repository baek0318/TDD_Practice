import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    //10번의 게임을 진행할때 10번 모두 스트라이크라면 300점을 반환해야한다
    //한 게임당 30점의 점수를 내야한다

    @Test
    @DisplayName("모두 스트라이크라면 300점을 반환해야한다")
    void testGame() {
        Game game = new Game();
        int result = game.start();

        Assertions.assertEquals(300, result);
    }

    @Test
    @DisplayName("스페어시에 점수 계산")
    void testSpare() {

    }
}
