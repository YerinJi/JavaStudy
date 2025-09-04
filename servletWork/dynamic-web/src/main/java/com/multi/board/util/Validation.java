package com.multi.board.util;

public class Validation {
    public static void requireText(String s, int min, int max, String field) {
        if (s == null) System.out.println(field + "이(가) 없습니다.");
        String t = s.trim();
        if (t.length() < min || t.length() > max)
            System.out.println(String.format("%s 길이는 %d~%d자여야 합니다.", field, min, max));
    }
}
