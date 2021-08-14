package chap5;

import chap5.condition.DiscountCondition;

import java.util.List;

public class Movie {
    private String title;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Movie calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    public Money calculateMovieFee(Screening screening) {
        if(isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }
}
