package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application01 {

    public static void main(String[] args) {

        // 수업목표. BufferWriter 와 BufferReader 에 대해 이해하고 사용할 수 있다.

        /* 필기.
            java.io 패키지의 입출력 스트림은 기본 스트림과 필터 스트림으로 분류할 수 있다.
            기본 스트림은 외부 데이터에 직접 연결되는 스트림이고.
            필터 스트림은 외부 데이터에 직접 연결하는 것이 아니라 기본 스트림에 추가로
            시용할 수 있는 스트림이다.
            주로 성능을 향상시키는 목적으로 사용된다.
            생성자 쪽에 매개변수로 다른 스트림을 이용하는 클래스는 필터스트림 이라고 볼 수 있다.
         */

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/section03/filterstream/testBufferWriter.txt"));
            bw.write("안녕하세요~~\n");
            bw.write("반갑습니다!!\n");
            bw.write("반갑습니다!!\n");
            // 필기. 버퍼를 사용하는 경우 버퍼가 가득 차지 않은 상태에서는 강제로 내보내기(flush) 를 해야한다.
            //      finally 블럭에서 닫아줘도 똑같음.
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // 필기. 버퍼에 미리 읽어온 후 한 줄 단위로 읽어들이는 기능을 제공한다.
        //      기존 스트림보다 성능을 개선시킨다.

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/com/ohgiraffers/section03/filterstream/testBufferWriter.txt"));
            // 필기. readLine() : 버퍼의 한 줄을 읽어와서 문자열로 반환해준다.

            String temp;
            while ((temp = br.readLine()) != null ){
                System.out.println(temp);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader br1 = null;
//        while ()
    }
}
