package chap5;

import chap4.DiscountConditionType;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
    DiscountConditionType getType();
}
