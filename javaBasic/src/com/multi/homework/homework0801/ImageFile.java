package com.multi.homework.homework0801;

public class ImageFile extends MediaFile{


    public ImageFile(String fileName, double size) {
        super(fileName, size);
    }

    public void compress(double rate){
        double newSize = size * (1-rate);
        System.out.println(newSize + "MB (압축률 " + (rate *100) + ")");
    }

    public void compress(double rate, String path){
        double newSize = size * (1-rate);
        System.out.println(path + "에 저장 " + newSize + "MB (압축률 " + (rate *100) + ")");
    }

    @Override
    public void open() {
        System.out.println("Image File Open");
    }
}
