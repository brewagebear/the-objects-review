package chap5;

import chap5.condition.PeriodCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationAgencyTest {
    @Test
    @DisplayName("Reservation Agency를 통해서 Reservation 생성할 수 있다.")
    public void  create_reservation() throws Exception {
        //given
        List<DiscountCondition> conditions = new ArrayList<>();
        conditions.add(new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)));
        conditions.add(new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(8, 0), LocalTime.of(12, 59)));

        Movie movie = new AmountDiscountMovie("어바웃 타임",
                Duration.ofMinutes(200),
                new Money(8000L),
                conditions,
                Money.amountToWon(800));

        Screening screening = new Screening(movie,
                1,
                LocalDateTime.of(LocalDate.of(2020, 11, 23), LocalTime.of(10, 23)));

        Customer customer = new Customer("신수웅");

        ReservationAgency agency = new ReservationAgency();

        //when
        Reservation reserve = agency.reserve(screening, customer, 2);

        //then
        assertAll(
                () -> assertEquals(reserve.getCustomer(), customer),
                () -> assertEquals(new Money(14400L), reserve.getFee()),
                () -> assertEquals(reserve.getScreening(), screening),
                () -> assertEquals(reserve.getAudienceCount(), 2)
        );
    }


}