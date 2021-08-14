package chap5;

import java.math.BigDecimal;

public class Money {
    public static final chap2.Money ZERO = chap2.Money.amountToWon(0);

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money times(double discountPercent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(discountPercent)));
    }
}
