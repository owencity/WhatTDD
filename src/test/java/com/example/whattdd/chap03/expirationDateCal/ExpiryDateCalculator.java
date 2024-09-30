package com.example.whattdd.chap03.expirationDateCal;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculator {
    /*
           매달 비용 지불 유료 서비스 ( 다음 규칙에 따라 서비스 만료일을 결정)
           1. 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한 달 뒤가 서비스 만료일이 된다.
           2. 2개월 이상 요금을 납부할 수 있다.
           3. 10만 원을 납부하면 서비스를 1년 제공한다.
     */
    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {

        assertExpiryDate(
                LocalDate.of(2019, 3, 1 ), 10_000,
                LocalDate.of(2019, 4, 1));
        assertExpiryDate(
                LocalDate.of(2019, 5, 5), 10_000,
                LocalDate.of(2019, 6, 5));

    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(
                LocalDate.of(2019,1,31), 10_000,
                LocalDate.of(2019,2,28));
        assertExpiryDate(
                LocalDate.of(2019,5,31), 10_000,
                LocalDate.of(2019,6,30));
        assertExpiryDate(
                LocalDate.of(2020,1,31), 10_000,
                LocalDate.of(2020,2,29));

    }
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }


}
