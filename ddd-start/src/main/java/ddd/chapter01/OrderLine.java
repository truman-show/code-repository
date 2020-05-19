package ddd.chapter01;

public class OrderLine {

  private Product product;

  private Money price;
  private int quantity;
  private Money amounts;

  public OrderLine(Product product, Money price, int quantity) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
    this.amounts = this.calculateAmounts();
  }

  /**
   * 구매가격을 계산한다.
   *
   * @return 개당 상품가격 * 구매 수량
   */
  private Money calculateAmounts() {
    return price.multiply(quantity);
  }


  public int getAmounts() {
    return 0;
  }
}
