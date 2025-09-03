package basic.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
Stream은 흐름을 말한다..
Byte를 가지고 흘러가면 ByteStream이고 Character를 가지고 흘러가면 CharacterStream이다.
 */
public class FileIOExample {//ByteStream
    public static void main(String[] args) {
        try{
            //"C:\\iowrite.txt" 목적지
            // new FileOutputStream 목적지로 전달하는 객체(운반객체)
            // Stream 붙으면 byte를 운송함
            FileOutputStream fos = new FileOutputStream("c:\\iowrite.txt");
            //Buffer에 모았다가 한번에 보냄
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            String content = "Hello, this is a file IO example in Java!";
            bos.write(content.getBytes());
            bos.flush();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
