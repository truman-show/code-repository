package chapter1;

public class EuclideanAlgorithm {

  public static void main(String[] args) {
    /*
    12와 18의 최대 공약수를 알아보자
    - 12의 약수 : 1, 2, 3, 4, 6, 12
    - 18의 약수 : 1, 2, 3, 6, 9, 18
    - 12와 18의 최대 공약수 : 18
     */
    System.out.println("12와 18의 최대 공약수 : " + gcd(12, 18));
    System.out.println("15와 60의 최대 공약수 : " + gcd(15, 60));
    System.out.println("42와 70의 최대 공약수 : " + gcd(42, 70));

  }

  /**
   * 유클리드 알고리즘
   * 최대공약수 찾기
   * @param p
   * @param q
   * @return
   */
  public static int gcd(int p, int q) {
    if (q == 0) return p;
    int r = p % q;
    // 12 = 12 & 18;
    // gcd(18, 12)

    // 6 = 18 % 12
    // gcd(12, 6)

    // 0 = 12 % 6
    // gcd(6, 0)

    // q == 0
    // return 6
    return gcd(q, r);
  }

}
