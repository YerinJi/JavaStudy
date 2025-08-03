package com.multi.homework.homework0801;

public class MediaFileMain {
    public static void main(String[] args) {
        MediaFile[] mediaFiles = new MediaFile[3];
        mediaFiles[0] = new ImageFile("cat.png",5);
        mediaFiles[1] = new VideoFile("movie.mp4",500);
        mediaFiles[2] = new AudioFile("music.mp3",20);

        for(MediaFile mediaFile : mediaFiles){
            mediaFile.open();
            mediaFile.compress(0.3);
            mediaFile.compress(0.3,"C:/yerin");
            System.out.println();

        }
    }
}
