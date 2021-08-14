package chap5;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO = Money.amountToWon(0);

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount.setScale(0);
    }

    public Money(Long amount) {
        this.amount = BigDecimal.valueOf(amount).setScale(0);
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money times(double discountPercent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(discountPercent)));
    }

    public static Money amountToWon(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
