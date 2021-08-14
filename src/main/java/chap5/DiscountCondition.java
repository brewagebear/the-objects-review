package chap5;

import chap5.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
