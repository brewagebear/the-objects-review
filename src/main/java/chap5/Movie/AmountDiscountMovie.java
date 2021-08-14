package chap5.Movie;

import chap5.Money;
import chap5.Movie;
import chap5.DiscountCondition;

import java.time.Duration;
import java.util.List;

public class AmountDiscountMovie extends Movie {
    private final Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee,
                               List<DiscountCondition> discountConditions, Money discountAmount) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
