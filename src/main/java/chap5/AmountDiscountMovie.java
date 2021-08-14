package chap5;

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
    protected MovieType getMovieType() {
        return MovieType.AMOUNT_DISCOUNT;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
