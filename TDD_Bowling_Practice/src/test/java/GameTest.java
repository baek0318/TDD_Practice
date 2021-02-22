import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    //Todo 4. 마지막 프레임 스트라이크인 경우 +2 프레임 추가제공
    //Todo 5. 마지막 프레임 스페어인 경우 +1 프레임 추가제공

    //10번의 게임을 진행할때 10번 모두 스트라이크라면 300점을 반환해야한다
    //한 게임당 30점의 점수를 내야한다
    @Test
    @DisplayName("모두 스트라이크라면 300점을 반환")
    void testStrikeGame() {
        Game game = new Game();
        int result = game.start(10, 0);

        Assertions.assertEquals(300, result);
    }

    @Test
    @DisplayName("모두 5,5 스페어라면 150점 반환")
    void test55SpareGame() {
        Game game = new Game();
        int result = game.start(5,5);

        Assertions.assertEquals(150, result);
    }

    @Test
    @DisplayName("모두 스페어와 스트라이크가 아닌 경우")
    void testNotSpareAndStrike() {
        Game game = new Game();
        int result = game.start(3, 4);

        Assertions.assertEquals(70, result);
    }
}
