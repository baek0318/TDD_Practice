package src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    //결과
    //(주가 * 주식의 수)의 결과값을 얻을 수 있어야 한다
    //결과값을 더할때 환율 변환을 달러로 한 뒤에 달러로 총 계산이 되어야 한다

    //Todo $5 + 10CHF = $10이 되어야 한다 (환율이 2:1인 경우) => (환율 변환해서 결과값을 구하는 것을 달성하기 위해서임)

    //Todo $5 + $5 = $10 이 되어야 한다

    //Todo 5 * 2 = $10 => (주가 * 주식의 수 를 달성하기 위해서 임) (해결!!) 1.

    //Todo amount를 private으로 바꾸기 (해결!!) 2.

    //Todo Dollar 부작용? (해결!!) 3.

    //Todo Money 반올림?

    //Todo 객체비교 equals 구현 (해결!!) 4.

    //Todo HashMap 키값으로 사용될때의 hashcode 구현

    //Todo equals null

    //Todo equals different Object

    //Todo 5Franc * 2Franc = 10Franc (해결!!) 5.

    //Todo Dollar/Franc 중복 (해결!!) 11.

    //Todo 공용 equals (해결!!) 6.

    //Todo 공용 times (해결!!) 10.

    //Todo Franc 과 Dollar 비교하기 (해결!!) 7.

    //Todo 통화? (해결!!) 8.

    //Todo testFranMultiplication 제거? (해결!!) 11.

    @Test
    @DisplayName("달러의 곱셈이 가능해야한다")
    void testDollarMultiplication() {
        Money five = Money.dollar(5);
        Assertions.assertEquals(Money.dollar(10), five.times(2));
        Assertions.assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    @DisplayName("객체끼리의 비교가 가능해야한다")
    void testEquality() {
        Assertions.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        Assertions.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        Assertions.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    @DisplayName("프랑의 곱셈이 가능해야한다")
    void testFrancMultiplication() {
        Money five = Money.franc(5);
        Assertions.assertEquals(Money.franc(10), five.times(2));
        Assertions.assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    @DisplayName("통화가 일치하는지 확인")
    void testCurrency() {
        Assertions.assertEquals("USD", Money.dollar(1).currency());
        Assertions.assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    @DisplayName("덧셈을 하자")
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        Assertions.assertEquals(Money.dollar(10), reduced);
    }

    @Test
    @DisplayName("덧셈을 하면 Sum이라는 객체를 반환")
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        Assertions.assertEquals(five, sum.augend);
        Assertions.assertEquals(five, sum.addend);
    }

    @Test
    @DisplayName("Reduce는 Sum을 전달받아서 값을 처리한다")
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assertions.assertEquals(Money.dollar(7), result);
    }

    @Test
    @DisplayName("")
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        Assertions.assertEquals(Money.dollar(1), result);
    }
}
