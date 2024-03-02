package com.ohgiraffers.section02.stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Application04 {

    public static void main(String[] args) {

        // 수업목표. FileWriter 를 이해하고 사용할 수 있다.
        /* 필기.
            FileWriter
            프로그램의 데이터를 파일로 내보내기 위한 용도의 스트림이다.
            1 글자 단위로 데이터를 처리한다. (문자)
         */

        FileWriter fw = null;

        try {
            fw = new FileWriter("src/main/java/com/ohgiraffers/section02/stream/testWriter.txt");
            fw.write(97);
            fw.write('A');
            fw.write(new char[]{'a','p','p','l','e','\n'});
            fw.write("하이미디어\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
