package chap5;

import java.time.Duration;
import java.util.List;

public class PercentDiscountMovie extends Movie {
    private final double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee,
                                List<DiscountCondition> discountConditions, double percent) {
        super(title, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
