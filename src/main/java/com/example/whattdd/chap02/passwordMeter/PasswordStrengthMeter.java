package com.example.whattdd.chap02.passwordMeter;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if(s == null||s.isEmpty()) return PasswordStrength.INVALID; // null 만이 아닌 공백도 추가
        int metCounts = getMetCriteriaCounts(s);


//        boolean lengthEnough = s.length() >= 8;
//        if(lengthEnough) metCounts++;
//        boolean containsNum = meetsContainingNumberCriteria(s);
//        if (containsNum) metCounts++;
//        boolean containsUpp = meetsContatiningUppercasecriteria(s);
//        if (containsUpp) metCounts++;

        if(metCounts <= 1) return PasswordStrength.WEAK;
        if(metCounts == 2) return PasswordStrength.NORMAL;

        // 리팩토링하기전 코드
//        if(s.length() < 8) {
//            return PasswordStrength.NORMAL;
//        }
//        boolean containsNum = false;
//        for (char ch: s.toCharArray()) {
//            if (ch >= '0' && ch <= '9') {
//                containsNum = true;
//                break;



        // ====== if 절을 아래로 이동
        // (이유 : 두 로직을 구분해서 모으기 위함, 개별 규칙을 검사하는 로직, 규칙을 검사한 결과에 따라 암호 강도를 계산하는 로직)

//      ======= 아래코드 삭제 ========
// 세조건 중에서 한조건만 충족하는 경우 암호 강도가 약하다는 것을 구현, if절은 세조건중 한조건만 충족한다는것을 확인 , 조건개수로 리팩토링
//        if(lengthEnough && !containsNum && !containsUpp)
//        {
//            return PasswordStrength.WEAK;
//        }
//        if(!lengthEnough && containsNum && !containsUpp) {
//            return PasswordStrength.WEAK;
//        }
//        if(!lengthEnough && !containsNum && containsUpp) {
//            return PasswordStrength.WEAK;
//        }

        // 조건이 두개인 경우 암호 강도가 보통이라는 규칙
//        if (!lengthEnough) {
//            return PasswordStrength.NORMAL;
//        }
//        if(!containsNum) { return PasswordStrength.NORMAL; }
//
//        if(!containsUpp) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
            }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if (s.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(s)) metCounts++;
        if (meetsContatiningUppercasecriteria(s)) metCounts++;
        return metCounts;
    }

    // 리팩토링하기전 코드
//        if (!containsNum) { return PasswordStrength.NORMAL; }
//        return PasswordStrength.STRONG;

    private boolean meetsContainingNumberCriteria(String s) {
        for(char ch: s.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContatiningUppercasecriteria(String s) {
        for (char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
    // 리팩토링하기전 코드
    // NORMAL 만 리턴시 두테스트 모두 통과 불가하여 코드 변경
    // 숫자 관련 코드 추가 , 성공확인후 리팩토링
}
