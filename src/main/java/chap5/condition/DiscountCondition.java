package chap5.condition;

import chap5.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
