package reservation;

import java.time.LocalDateTime;

/**
 * 영화를 예매할 책임을 맡는다.
 */
public class Screening {

    // 책임을 수행할 인스턴스 변수들
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    // Screening는 Reservation인스턴스를 생성할 책임자다. (CREATOR 패턴)
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, calculateFee(audienceCount), audienceCount);
    }

    /**
     * Movie 객체에 영화요금을 계산하라 메시지를 요청한다.
     * @param audienceCount 관객 수
     * @return 계산된 영화요금
     */
    private Money calculateFee(int audienceCount) {
        // movie의 내부구현에는 신경쓰지 않고 필요한 메시지만 결정했다.
        return movie.calculateMoviceFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }
}
