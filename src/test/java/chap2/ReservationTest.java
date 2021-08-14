package chap2;


import chap2.policy.NoneDiscountPolicy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTest {

    @Test
    public void create_reservation() {

        Customer customer = new Customer("신수웅");

        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(162),
                Money.amountToWon(10000),
                new NoneDiscountPolicy());

        Screening screening = new Screening(avatar,
                1,
                LocalDateTime.of(LocalDate.of(2020, 11, 23),
                LocalTime.of(10, 23)));

        Money money = new Money(BigDecimal.valueOf(20000.0));

        Reservation reserve = screening.reserve(customer, 2);

        assertEquals(reserve.getCustomer().getName(), "신수웅");
        assertEquals(reserve.getScreening(), screening);
        assertEquals(reserve.getAudienceCount(), 2);
        assertEquals(reserve.getFee(), money);
    }

}