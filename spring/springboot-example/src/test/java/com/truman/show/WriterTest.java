package com.truman.show;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterTest {

  public static void main(String[] args) {
    final var byteArrayOutputStream = new ByteArrayOutputStream();
    PrintWriter writer = new PrintWriter(byteArrayOutputStream);
    writer.println("1111");
    writer.println("2222");

    writer.flush(); // flush를 해줘야 byteArrayOutputStream에 써진다..
    // flush의 역할을 알아야겠다.
    System.out.println("================");
    System.out.println(byteArrayOutputStream.size());
    System.out.println(byteArrayOutputStream.toString());
    System.out.println(byteArrayOutputStream.toByteArray().length);
    System.out.println("================");
    writer.close();
  }

  public static void main2(String[] args) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintWriter fw = new PrintWriter(out);
    for (int i = 1; i < 11; i++) {
      String data = i + " 번째 줄입니다.!!!\r\n";
      fw.write(data);
    }
    fw.close();
  }
//
//  PrintWriter pw = new PrintWriter("./out.txt");
//    for (int i = 1; i < 11; i++) {
//    String data = i + " 번째 줄입니다.!";
////      pw.write(data);
//    pw.println(data);
//  }
//    pw.close();


}
