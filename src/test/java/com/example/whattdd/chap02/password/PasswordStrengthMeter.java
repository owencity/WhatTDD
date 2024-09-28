package com.example.whattdd.chap02.password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if(s == null||s.isEmpty()) return PasswordStrength.INVALID; // null 만이 아닌 공백도 추가
        if(s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
//        boolean containsNum = false;
//        for (char ch: s.toCharArray()) {
//            if (ch >= '0' && ch <= '9') {
//                containsNum = true;
//                break;
        boolean containsNum = meetsContainingNumberCriteria(s);
        if(!containsNum) { return PasswordStrength.NORMAL; }
        return PasswordStrength.STRONG;
            }

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
    // NORMAL 만 리턴시 두테스트 모두 통과 불가하여 코드 변경
    // 숫자 관련 코드 추가 , 성공확인후 리팩토링
}
