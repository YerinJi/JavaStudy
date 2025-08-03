package com.multi.homework.homework0801;

public class MediaFile {
    String fileName;
    double size;

    public MediaFile(String fileName, double size) {
        this.fileName = fileName;
        this.size = size;
    }

    public void open(){

    }

    public void compress(double rate){
        double newSize = size * (1-rate);
        System.out.println(newSize + "MB (압축률 " + (rate *100) + ")");
    }

    public void compress(double rate, String path){
        double newSize = size * (1-rate);
        System.out.println(path + "에 저장 " + newSize + "MB (압축률 " + (rate *100) + ")");
    }

}
