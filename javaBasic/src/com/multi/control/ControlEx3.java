package com.multi.control;

// 요일 (1988/5/1) 나이,띠,요일
// 나이 = (올해년도 - 생년) + 1
// 띠 = (생년 % 12 ) 나머지값
// 닭 개 돼지 쥐 소 호랑이 토끼 용 뱀 말 양 원숭이

// 4, 100, 400 으로 나누어떨어지면 윤년
// (year-1) * 365 + 윤달 --> 1987년까지의 일수
// (month-1) --> 1월부터 month-1까지의 총 일수 + 일수

import java.util.Calendar;

public class ControlEx3 {

    public int getAge(int year) {
        return Calendar.getInstance().get(Calendar.YEAR) - year + 1;
    }

    public String getZodiacSign(int year) { //띠
        switch (year % 12) {
            case 0:
                return "원숭이";
            case 1:
                return "닭";
            case 2:
                return "개";
            case 3:
                return "돼지";
            case 4:
                return "쥐";
            case 5:
                return "소";
            case 6:
                return "호랑이";
            case 7:
                return "토끼";
            case 8:
                return "용";
            case 9:
                return "뱀";
            case 10:
                return "말";
            case 11:
                return "양";
        }
        return "";
    }

    public boolean leapYear(int year) {

        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public int getCountDay(int year, int month, int day) {
        int countDay = 0;
        countDay = (year - 1) * 365;
        for (int i = 1; i < year; i++) { //서기1년부터 태어난 년도 전까지 윤달체크
            if (leapYear(i)) {
                countDay++;
            }
            ;
        }
        for (int j = 1; j < month; j++) {
            switch (j) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    countDay += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    countDay += 30;
                    break;
                case 2:
                    countDay += leapYear(year) ? 29 : 28;
                    break;
            }
        }
        countDay += day;
        return countDay;
    }

    public String getWeek(int countday) {
        switch (countday % 7) {
            case 0:
                return "일";
            case 1:
                return "월";
            case 2:
                return "화";
            case 3:
                return "수";
            case 4:
                return "목";
            case 5:
                return "금";
            case 6:
                return "토";
        }
        return "";
    }

    public int input(int year, int month, int day) {
        int age = getAge(year);
        String zodiacSign = getZodiacSign(year);
        int countDay = getCountDay(year, month, day);
        String week = getWeek(countDay);
        output(age, zodiacSign, week);

        return 0;
    }

    public void output(int age, String zodiacSign, String week) {
        System.out.println("당신은 " + age + "살이고 " + zodiacSign + "띠이고 " + week + "요일에 태어남");
    }

    public static void main(String[] args) {
        ControlEx3 c = new ControlEx3();
        c.input(2002, 6, 27);
    }

}
