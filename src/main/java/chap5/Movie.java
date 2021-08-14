package chap5;

import java.time.Duration;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    abstract protected Money calculateDiscountAmount();
    abstract protected MovieType getMovieType();

    public Movie(String title, Duration runningTime, Money fee,
                 List<DiscountCondition> discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = discountConditions;
    }

    protected Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        if(isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", runningTime=" + runningTime +
                ", fee=" + fee +
                ", discountConditions=" + discountConditions +
                '}';
    }
}
