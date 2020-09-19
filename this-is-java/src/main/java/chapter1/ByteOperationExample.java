package chapter1;

public class ByteOperationExample {

  public static void main(String[] args) {

    byte result1 = 10 + 20; // 타입이 아직 정해지지 않았기에 좌측의 타입에 맞춰서 연산이 이뤄진다.

    byte x = 10;
    byte y = 20;
    int result2 = x + y; // byte타입이 int 타입으로 변환되어서 연산이 이루어지기 때문에 결과 타입은 int로 해줘야한다.

    byte x2 = 30;
    long y2 = 40;
    long result3 = x2 + y2; // byte타입이 long으로 변환되어 long + long 타입으로 연산이 이뤄진다.

  }

}
