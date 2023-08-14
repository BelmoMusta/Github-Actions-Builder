package example.tests;

import org.example.yy.Cron;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CronDayOfWeekTest extends AbstracTest {
    @Test
    public void testZeroDayOfweek() {
        Cron cron = Cron.$()
                .dayOfweek(0);
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testFirstDayOfweek() {
        Cron cron = Cron.$()
                .dayOfweek(1);
        cron.accept(visitor);
        String expected = "* * * * 1";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testNegativeDayOfweek() {
        Cron cron = Cron.$()
                .dayOfweek(-5);
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testOutOfRangeDayOfweek() {
        Cron cron = Cron.$()
                .dayOfweek(7);
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMultiDayOfweek() {
        Cron cron = Cron.$()
                .dayOfweek(1, 2);
        cron.accept(visitor);
        String expected = "* * * * 1,2";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testInversedMultiDayOfweek() {
        Cron cron = Cron.$()
                .dayOfweek(2, 1);
        cron.accept(visitor);
        String expected = "* * * * 2,1";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksRanges() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Range.$()
                        .from(3)
                        .to(6));
        cron.accept(visitor);
        String expected = "* * * * 3-6";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testInversedDayOfweeksRanges() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Range.$()
                        .from(2)
                        .to(1));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksRangesBothEndsAreEqual() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Range.$()
                        .from(2)
                        .to(2));
        cron.accept(visitor);
        String expected = "* * * * 2-2";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksMultipleRanges() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Range.$()
                                .from(1)
                                .to(2),
                        Cron.Range.$()
                                .from(4)
                                .to(6));
        cron.accept(visitor);
        String expected = "* * * * 1-2,4-6";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksPeriodicsFromZeroMinunte() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Periodic.$()
                        .from(3)
                        .every(20));
        cron.accept(visitor);
        String expected = "* * * * 3/20";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksPeriodicsEvery20DayOfweeks() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Periodic.$()
                        .every(20));
        cron.accept(visitor);
        String expected = "* * * * */20";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksPeriodicsEveryZeroDay() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Periodic.$()
                        .from(10)
                        .every(0));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksPeriodicsFromNegativeDay() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Periodic.$()
                        .from(-10)
                        .every(3));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksPeriodics() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Periodic.$()
                        .from(1)
                        .every(20));
        cron.accept(visitor);
        String expected = "* * * * 1/20";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksMultiPeriodics() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Periodic.$()
                                .from(1)
                                .every(2),
                        Cron.Periodic.$()
                                .from(4)
                                .every(5));
        cron.accept(visitor);
        String expected = "* * * * 1/2,4/5";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksHybridTypes() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.Periodic.$()
                                .from(1)
                                .every(2),
                        Cron.Range.$()
                                .from(4)
                                .to(5));
        cron.accept(visitor);
        String expected = "* * * * 1/2,4-5";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testDayOfweeksNamedDays() {
        Cron cron = Cron.$()
                .dayOfweek(Cron.DayRange.$()
                        .from(Cron.DaysOfWeek.MON)
                        .to(Cron.DaysOfWeek.WED));
        cron.accept(visitor);
        String expected = "* * * * MON-WED";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
