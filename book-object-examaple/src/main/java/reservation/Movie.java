package reservation;

import java.time.Duration;
import java.util.List;

/**
 * 영화 요금을 계산하는 책임을 갖는다.
 */
public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions; // 할인 조건은 여러개 적용이 가능하기때문에 List 타입이다.

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    /**
     * 영화요금을 계산한다.
     * 영화 요금을 계산하기위해선 기본금액, 할인 조건, 할인 정책 등 정보가 필요하다.
     *
     * @param screening 예매정보
     * @return 계산된 영화요금
     */
    public Money calculateMoviceFee(Screening screening) {

        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    /**
     * 여러 할인조건 중 할인조건이 만족하는지 확인한다.
     *
     * @param screening 예매정보
     * @return
     */
    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }
        throw new IllegalStateException();
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

}
