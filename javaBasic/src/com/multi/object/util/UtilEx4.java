package com.multi.object.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class UtilEx4 {
    public static void main(String[] args) {
        // 현재 날짜
        Date date = new Date();
        System.out.println("Current Date: " + date);

        // 날짜 포맷
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);
        System.out.println("Formatted Date: " + formattedDate);

        // Calendar 사용
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 5); // 5일 후
        System.out.println("5 Days Later: " + calendar.getTime());
    }
}
