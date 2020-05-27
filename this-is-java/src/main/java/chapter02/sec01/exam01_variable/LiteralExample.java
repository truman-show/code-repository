package chapter02.sec01.exam01_variable;

public class LiteralExample {

  public static void main (String[] args){
    int var1 = 10;  // 10진수
    System.out.println(var1);

    int var2 = 010; // 0 으로 시작한다면 8진수 : 1 * 8의 1승 + 0 * 8의 0승
    System.out.println(var2);

    int var3 = 0x10;  // 0x로 시작 한다면 16 진수 : 1 * 16의 1승 + 0 * 16의 0승
    System.out.println(var3);

    double var4 = 0.25;
    System.out.println(var4);

    double var5 = 2E5;  // 지수와 가수는 반드시 double 타입에 저장해야한다. double값으로 저장이되면서 .0 이 붙는다
    System.out.println(var5);

    char var6 = 'A';
    System.out.println(var6);

    char var7 = '한';
    System.out.println(var7);

    System.out.println('\t' + "들여쓰기");
    System.out.println("\t들여쓰기");
    System.out.println("대한" + '\n' + "민국"); //n을 하나 r을 하나 동일하게 줄바꿈이다
    System.out.println("This" + '\'' + "s Java");
    System.out.println("이것은" + '\"' + "중요" + "\"" + "합니다");
    System.out.println("가격이 \\ 300 입니다");

    char var8 = '\u0041'; //16진수  : 4 * 16의 1승 + 1 * 16의 0승 = 64 + 1
    System.out.println(var8);

    String var9 = "자바";
    System.out.println(var9);

    boolean var10 = true;
    boolean var11 = false;
    System.out.println(var10);
    System.out.println(var11);
  }
}
