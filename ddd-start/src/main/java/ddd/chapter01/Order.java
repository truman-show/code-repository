package ddd.chapter01;

import java.util.List;

public class Order {

  // 식별자
  private String orderNumber;
  private Orderer orderer;
  private List<OrderLine> orderLines;
  private Money totalAmounts;
  private ShippingInfo shippingInfo;
  private OrderState state;

  public Order(Orderer orderer, List<OrderLine> orderLines,
               ShippingInfo shippingInfo) {
    setOrderer(orderer);
    setOrderLines(orderLines);
    setShippingInfo(shippingInfo);
  }

  private void setOrderer(Orderer orderer) {
    if (orderer == null) throw new IllegalArgumentException("no orderer");
    this.orderer = orderer;
  }

  private void setShippingInfo(ShippingInfo newShippingInfo) {
    if (shippingInfo == null) {
      throw new IllegalArgumentException("no ShippingInfo");
    }
    // 밸류 타입의 데이터를 변경할 떄는 새로운 객체로 교체한다.
    this.shippingInfo = newShippingInfo;
  }

  private void setOrderLines(List<OrderLine> orderLines) {
    verifyAtLeastOneOrMoreOrderLines(orderLines);
    this.orderLines = orderLines;
    calculateTotalAmounts();
  }


  private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
    if (orderLines == null || orderLines.isEmpty()) {
      throw new IllegalArgumentException("no OrderLine");
    }
  }

  private void calculateTotalAmounts() {
    this.totalAmounts = new Money(
        orderLines.stream()
            .mapToInt(OrderLine::getAmounts)
            .sum()
    );
  }

  //도메인 모델 엔티티는 도메인 기능도 함께 제공한다
  /**
   * 배송지 정보를 변경한다.
   *
   * @param newShippingInfo 새로운 배송지 정보
   */
  public void changeShippingInfo(ShippingInfo newShippingInfo) {
    verifyNotYetShipped();
    setShippingInfo(newShippingInfo);
  }

  public void cancel() {
    verifyNotYetShipped();
    this.state = OrderState.CANCELED;
  }

  private void verifyNotYetShipped() {
    if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
      throw new IllegalStateException("already shipped");
    }
  }

  public void changeShipped() {
  }


  public void completePayment() {
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (obj.getClass() != Order.class) {
      return false;
    }

    Order other = (Order) obj;
    if (this.orderNumber == null) {
      return false;
    }
    return this.orderNumber.equals(other.orderNumber);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
    return result;
  }
}
