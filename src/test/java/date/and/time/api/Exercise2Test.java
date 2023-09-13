package date.and.time.api;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Exercise2Test {

    @Test
    public void localTimeOfHourToMinute() {
        /**
         * Create a {@link LocalTime} of 23:07 by using {@link LocalTime#of}
         */

        LocalTime localTime = LocalTime.of(23, 7);

        assertThat(localTime.toString(), is("23:07"));
    }

    @Test
    public void localTimeOfHourToNanoSec() {
        /**
         * Create a {@link LocalTime} of 23:07:03.1 by using {@link LocalTime#of}
         */

        LocalTime localTime = LocalTime.of(23, 7, 3, 100000000);

        assertThat(localTime.toString(), is("23:07:03.100"));
    }

    @Test
    public void localTimeParse() {
        /**
         * Create a {@link LocalTime} of 23:07:03.1 from String by using {@link LocalTime#parse}
         */

        LocalTime localTime = LocalTime.parse("23:07:03.100");

        assertThat(localTime.toString(), is("23:07:03.100"));
    }

    @Test
    public void localTimeWith() {
        LocalTime lt = LocalTime.of(23, 7, 30, 50);

        /**
         * Create a {@link LocalTime} from {@link lt} with hour 21
         * by using {@link LocalTime#withHour} or {@link LocalTime#with}
         */

        LocalTime localTime = lt.withHour(21);

        assertThat(localTime.getHour(), is(21));
        assertThat(localTime.getMinute(), is(lt.getMinute()));
        assertThat(localTime.getSecond(), is(lt.getSecond()));
    }

    @Test
    public void localTimePlus() {
        LocalTime lt = LocalTime.of(23, 7, 30, 50);

        /**
         * Create a {@link LocalTime} from {@link lt} with 30 minutes later
         * by using {@link LocalTime#plusMinutes} or {@link LocalTime#plus}
         */
        LocalTime localTime = lt.plusMinutes(30);

        assertThat(localTime.getHour(), is(lt.getHour()));
        assertThat(localTime.getMinute(), is(lt.getMinute() + 30));
        assertThat(localTime.getSecond(), is(lt.getSecond()));
    }

    @Test
    public void localTimeMinus() {
        LocalTime lt = LocalTime.of(23, 7, 30, 50);

        /**
         * Create a {@link LocalTime} from {@link lt} with 3 hours before
         * by using {@link LocalTime#minusHours} or {@link LocalTime#minus}
         */

        LocalTime localTime = lt.minusHours(3);

        assertThat(localTime.getHour(), is(lt.getHour() - 3));
        assertThat(localTime.getMinute(), is(lt.getMinute()));
        assertThat(localTime.getSecond(), is(lt.getSecond()));
    }

    @Test
    public void localTimeMinusDuration() {
        LocalTime lt = LocalTime.of(23, 7, 30, 500000000);

        /**
         * Define a {@link Duration} of 3 hours 30 minutes and 20.2 seconds
         * Create a {@link LocalTime} subtracting the duration from {@link lt} by using {@link LocalTime#minus}
         */

        Duration duration = Duration.ofSeconds(12620, 200000000);
        LocalTime localTime = lt.minus(duration);

        assertThat(localTime.getHour(), is(19));
        assertThat(localTime.getMinute(), is(37));
        assertThat(localTime.getSecond(), is(10));
        assertThat(localTime.getNano(), is(300000000));
        assertThat(duration.getSeconds(), is(12620L));
        assertThat(duration.getNano(), is(200000000));
    }

    @Test
    public void localDateIsBefore() {
        LocalTime lt = LocalTime.of(23, 7, 30, 500000000);
        LocalTime lt2 = LocalTime.of(12, 10, 0, 0);

        /**
         * Check whether {@link lt2} is before {@link lt} or not
         * by using {@link LocalTime#isAfter} or {@link LocalTime#isBefore}
         */

        boolean isBefore2307 = lt2.isBefore(lt);

        assertThat(isBefore2307, is(true));
    }

    @Test
    public void localTimeTruncatedTo() {
        LocalTime lt = LocalTime.of(23, 7, 30, 500000000);

        /**
         * Create a {@link LocalTime} from {@link lt} truncated to minutes by using {@link LocalTime#truncatedTo}
         */

        LocalTime localTime = lt.truncatedTo(ChronoUnit.MINUTES);
        System.out.println(lt);
        System.out.println(localTime);

        assertThat(lt.toString(), is("23:07:30.500"));
        assertThat(localTime.toString(), is("23:07"));
    }

}