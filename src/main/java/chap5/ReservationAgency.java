package chap5;

import chap4.DiscountConditionType;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return createReservation(screening, fee, audienceCount, customer);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie()
                .getDiscountConditions()
                .stream()
                .anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        return screening.getMovie()
                .calculateMovieFee(screening)
                .times(audienceCount);
    }

    private Reservation createReservation(Screening screening, Money fee, int audienceCount, Customer customer) {
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
