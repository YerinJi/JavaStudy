package com.multi.object.util;

import java.util.*;

public class UtilEx8 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("numbers","1,2,3,4,5,6,7,8,9,10");
        prop.setProperty("max","10");
        prop.setProperty("min","5");
        System.out.println("Properties: " + prop);
    }
}
