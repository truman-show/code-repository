package chapter04;

import java.io.IOException;

public class QStopExample {

  public static void main(String[] args) throws IOException {
    int keyCode;

    while (true) {
      keyCode = System.in.read();
      System.out.println("keyCode " + keyCode);
      if(keyCode == 113){
        break;
      }
    }
    System.out.println("종료");
  }
}
