package chapter1;

public class IntegerLiteralExample {

  public static void main(String[] args) {
    //2진수 : 0b 또는 0B로 시작하고 0과 1로 구성됩니다.
    int var1 = 0b1011;   // (1 * 2^0) + (1 * +2^1) + 0 + (1 * 2^3) = 11
    System.out.println("var1 : " + var1);

    // 8진수 : 0으로 시작하고 0 ~ 7 숫자로 구성됩니다.
    int var2 = 013; // (3 * 8^0) + (1 * 8^1) = 11
    System.out.println("var2 : " + var2);

    // 10진수 : 소수점이 없는 0 ~ 9 숫자로 구성됩니다.
    int var3 = 11;
    System.out.println("var3 : " + var3);

    // 16진수 : 0x 또는 0X 로 시작하고 0 ~ 9 숫자와 A, B, C, D, E, F 또는 a, b, c, d, e, f 로 구성
    // A : 10, B : 11, C : 12, D : 13, E : 14, F : 15
    int var4 = 0xB3; // 3 * 16^0 + B * 16^1 = 179
    System.out.println("var4 : " + var4);

  }

}
