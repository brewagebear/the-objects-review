package chap5.condition;

import chap4.DiscountConditionType;
import chap5.DiscountCondition;
import chap5.Screening;

public class SequenceCondition implements DiscountCondition {
    private final int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }

    @Override
    public DiscountConditionType getType() {
        return DiscountConditionType.SEQUENCE;
    }
}
