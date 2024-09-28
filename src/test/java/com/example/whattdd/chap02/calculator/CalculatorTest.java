package com.example.whattdd.chap02.calculator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {

    @Test
    void plus() {
        int result = Calculator.plus(1,2);
        assertEquals(3, result);
        assertEquals(5, Calculator.plus(4,1));
        /*
            1. 항상 메서드 이름에 대한 고민 , 어울리는 영어명칭으로 지을것
            2. 정적메서드? 인스턴스 메서드? , 메서드를 제공할 클래스 이름은 뭐가좋을지?
            3. 보통 Red -> Green -> Refacotring 순으로 진행되고 해당 테스트 에러를 실행되게하고 다시 리팩토링한다.
         */
    }
}
