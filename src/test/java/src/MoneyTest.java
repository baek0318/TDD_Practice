package src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    //결과
    //(주가 * 주식의 수)의 결과값을 얻을 수 있어야 한다
    //결과값을 더할때 환율 변환을 달러로 한 뒤에 달러로 총 계산이 되어야 한다

    //Todo $5 + 10CHF = $10이 되어야 한다 (환율이 2:1인 경우) => (환율 변환해서 결과값을 구하는 것을 달성하기 위해서임)
    //Todo 5 * 2 = $10 => (주가 * 주식의 수 를 달성하기 위해서 임) (해결!!) 1.
    //Todo amount를 private으로 바꾸기 (해결!!) 2.
    //Todo Dollar 부작용? (해결!!) 3.
    //Todo Money 반올림?
    //Todo 객체비교 equals 구현 (해결!!) 4.
    //Todo HashMap 키값으로 사용될때의 hashcode 구현
    //Todo equals null
    //Todo equals different Object
    //Todo 5Franc * 2Franc = 10Franc (해결!!) 5.
    //Todo Dollar/Franc 중복
    //Todo 공용 equals (해결!!) 6.
    //Todo 공용 times
    //Todo Franc 과 Dollar 비교하기

    @Test
    @DisplayName("달러의 곱셈이 가능해야한다")
    void testDollarMultiplication() {
        Dollar five = new Dollar(5);
        Assertions.assertEquals(new Dollar(10), five.times(2));
        Assertions.assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    @DisplayName("객체끼리의 비교가 가능해야한다")
    void testEquality() {
        Assertions.assertTrue(new Dollar(5).equals(new Dollar(5)));
        Assertions.assertFalse(new Dollar(5).equals(new Dollar(6)));
        Assertions.assertTrue(new Franc(5).equals(new Franc(5)));
        Assertions.assertFalse(new Franc(5).equals(new Franc(6)));
        Assertions.assertFalse(new Franc(5).equals(new Dollar(5)));
    }

    @Test
    @DisplayName("프랑의 곱셈이 가능해야한다")
    void testFrancMultiplication() {
        Franc five = new Franc(5);
        Assertions.assertEquals(new Franc(10), five.times(2));
        Assertions.assertEquals(new Franc(15), five.times(3));
    }


}
