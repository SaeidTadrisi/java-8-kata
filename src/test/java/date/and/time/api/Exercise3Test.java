package date.and.time.api;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise3Test {

    @Test
    public void localDateTimeOf() {
        /**
         * Create a {@link LocalDateTime} of 2015-06-20 23:07:30 by using {@link LocalDateTime#of}
         */

        LocalDateTime localDateTime = LocalDateTime.of(2015,6,20,23,7,30);

        assertThat(localDateTime.toString(), is("2015-06-20T23:07:30"));
    }

    @Test
    public void localDateTimeParse() {
        /**
         * Create a {@link LocalDateTime} of 2015-06-20 23:07:30 by using {@link LocalDateTime#parse}
         */

        LocalDateTime localDateTime = LocalDateTime.parse("2015-06-20T23:07:30");

        assertThat(localDateTime.toString(), is("2015-06-20T23:07:30"));
    }

    @Test
    public void localTimeWith() {
        LocalDateTime ldt = LocalDateTime.of(2015,6,18,23,7,30,50);

        /**
         * Create a {@link LocalDateTime} from {@link ldt}
         * with first day of the next month and also truncated to hours.
         */

        LocalDateTime localDateTime = ldt.with(TemporalAdjusters.firstDayOfNextMonth()).truncatedTo(ChronoUnit.HOURS);

        assertThat(localDateTime.toString(), is("2015-07-01T23:00"));
    }

    @Test
    public void localDatePlusMinus() {
        LocalDateTime ldt = LocalDateTime.of(2015,6,18,23,7,30,500000000);

        /**
         * Create a {@link LocalDateTime} from {@link ldt} with 10 month later and 5 hours before
         * by using {@link LocalDateTime#plus*} or {@link LocalDateTime#minus*}
         */

        LocalDateTime localDateTime = ldt.plusMonths(10).minusHours(5);

        assertThat(localDateTime.toString(), is("2016-04-18T18:07:30.500"));
    }

    @Test
    public void localDateTimeFormat() {
        LocalDateTime ldt = LocalDateTime.of(2015,6,18,23,7,30);

        /**
         * Format {@link ldt} to a {@link String} as "2015_06_18_23_07_30"
         * by using {@link LocalDateTime#format} and {@link DateTimeFormatter#ofPattern}
         */

            String strLdt = ldt.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));

        assertThat(strLdt, is("2015_06_18_23_07_30"));
    }

    @Test
    public void toLocalDateAndTime() {
        LocalDateTime ldt = LocalDateTime.of(2015,6,18,23,7,30,500000000);

        /**
         * Create a {@link LocalDate} and a {@link LocalTime} from {@link ldt}
         * by using {@link LocalDateTime#toLocalDate} and {@link LocalDateTime#toLocalTime}
         */

        LocalDate localDate = ldt.toLocalDate();
        LocalTime localTime = ldt.toLocalTime();

        assertThat(localDate.toString(), is("2015-06-18"));
        assertThat(localTime.toString(), is("23:07:30.500"));
    }

    @Test
    public void toLocalDateTime() {
        LocalDate ld = LocalDate.of(2015,6,18);
        LocalTime lt = LocalTime.of(23,7,30,500000000);

        /**
         * Create two equal {@link LocalDateTime} from {@link ld} and {@link lt}
         * by using {@link LocalDate#atTime} and {@link LocalTime#atDate}
         */
        LocalDateTime localDateTime1 = ld.atTime(lt);
        LocalDateTime localDateTime2 = lt.atDate(ld);

        assertThat(localDateTime1.toString(), is("2015-06-18T23:07:30.500"));
        assertThat(localDateTime1.isEqual(localDateTime2), is(true));
    }
}