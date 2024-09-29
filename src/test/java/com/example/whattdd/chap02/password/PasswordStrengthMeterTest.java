package com.example.whattdd.chap02.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter(); // 전역으로 설정해서 중복제거

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void meetsAllCriteriaThenStrong() {
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        PasswordStrength result = meter.meter("ab12!@AB");
//        assertEquals(PasswordStrength.STRONG, result);
//        PasswordStrength result2 = meter.meter("abc1!ADD");
//        assertEquals(PasswordStrength.STRONG, result2);   모든 규칙을 충족하는 예를 하나 더 추가
        // 리팩토링으로 메서드로 사용해서 중복 코드 제거
        assertStrength("ab12!@Ab", PasswordStrength.STRONG);
        assertStrength("abc1!ADD", PasswordStrength.STRONG);

    }
    // 빈 메서드 테스트 -> 불필요한 행위 같지만 테스트를 실행할 수 있는 환경을 갖추었는지 확인할수 있는 나름대로 의미있다.
    /* TDD 암호검사기
        1. 첫번째 테스트 모든 규칙을 충족하는 경우
        - 가장 쉽거나 가장 예외적인 상황을 선택 (모든 규칙을 충족하는 경우 , 모든 조건을 충족하지 않는 경우)
        2. 실행 -> 실패(null 발생) -> 테스트 통과시키기 위해 코드작성 -> 테스트 성공
        * assertion(단언), 단언은 값이 특정 조건을 충족하는지 확인하고 충족하지 않는 경우 익셉션을 발생시킴
        이 단언을 통과하지못하고 익셉션을 발생하면 테스트 실패라고한다.
        3. 테스트코드도 코드이기 때문에 유지보수 대상이다. 발생하는 중복을 알맞게 제거 하거나 의미가 잘드러나게 코드를 수정할 필요가 있다.
        4. 테스트코드 중복을 무턱대고 제거하면 안된다. 중복을 제거한 뒤에도 테스트코드의 가독성이 떨어지지않고 수정이 용이한 경우에만 중복을 제거
        중복을 제거한뒤에 테스트 코드 관리가 어려워지면 제거했던 중복을 되돌려야한다.
     */

    // 두번째 테스트 : 길이만 8글자 미만이고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteriaExceptForLengthThenNormal() {
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        PasswordStrength result = meter.meter("ab12!@A");
//        assertEquals(PasswordStrength.NORMAL, result);
//        PasswordStrength result2 = meter.meter("AB12!c");
//        assertEquals(PasswordStrength.NORMAL, result2);
        // 리팩토링으로 메서드로 사용해서 중복 코드 제거
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("AB12!c", PasswordStrength.NORMAL);
    }
    // 세번째 테스트 : 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteriaExceptFornumberThenNormal() {
//        PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        PasswordStrength result = meter.meter("ab!@ABqwer");
//        assertEquals(PasswordStrength.NORMAL, result);
        // 리팩토링으로 메서드로 사용해서 중복 코드 제거
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }
    // 네번째 테스트 : 값이 없는 경우 (값이없다는것  null 그리고 공백(빈문자열도)도 생각
    @Test
    void nullInputThenInvalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    // 다섯번째 테스트 : 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
    @Test
    void meetsOtherCriteriaExceptForUppercaseThenNormal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);

    }

    // 여섯번째 테스트 : 길이가 8글자 이상인 조건만 충족하는 경우
    @Test
    void meetsOnlyLengthCriteriaThenWeak() {
        assertStrength("abdafghi", PasswordStrength.WEAK);
    }

    // 일곱번쨰 테스트 : 숫자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyNumCriteriaThenWeak() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    // 여덟번째 테스트 : 대문자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyUpperCriteriaThenWeak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    // 아홉번째 테스트 : 아무 조건도 충족하지 않는 경우
    @Test
    void meetsNoCriteriaThenWeak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
