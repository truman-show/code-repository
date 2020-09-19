package chapter1;

public class FloatDoubleExample {

  public static void main(String[] args) {
    //float var1 = 3.14;
    float var2 = 3.14f;
    double var3 = 3.14;

    System.out.println(var2);
    System.out.println(var2);

    // float : 소수점 이하자리 약 7
    float var4 = 0.1234567890123456789f;
    System.out.println(var4);

    // double : 소수점 이하자리 약 15
    double var5 = 0.1234567890123456789;
    System.out.println(var5);

    double var6 = 3e6;
    float var7 = 3e6f;
    System.out.println(var6);
    System.out.println(var7);

  }
}
