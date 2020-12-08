package chap3;

import java.util.Objects;

public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Screening getScreening() {
        return screening;
    }

    public Money getFee() {
        return fee;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "customer=" + customer +
            ", screening=" + screening +
            ", fee=" + fee +
            ", audienceCount=" + audienceCount +
            '}';
    }
}
