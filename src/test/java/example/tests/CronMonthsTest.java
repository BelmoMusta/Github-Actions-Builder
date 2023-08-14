package example.tests;

import org.example.yy.Cron;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CronMonthsTest extends AbstracTest {
    @Test
    public void testZeroMonth() {
        Cron cron = Cron.$()
                .month(0);
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testFirstMonth() {
        Cron cron = Cron.$()
                .month(1);
        cron.accept(visitor);
        String expected = "* * * 1 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testNegativeMonth() {
        Cron cron = Cron.$()
                .month(-5);
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMultiMonth() {
        Cron cron = Cron.$()
                .month(1, 12);
        cron.accept(visitor);
        String expected = "* * * 1,12 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testInversedMultiMonth() {
        Cron cron = Cron.$()
                .month(12, 1);
        cron.accept(visitor);
        String expected = "* * * 12,1 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsRanges() {
        Cron cron = Cron.$()
                .month(Cron.Range.$()
                        .from(10)
                        .to(12));
        cron.accept(visitor);
        String expected = "* * * 10-12 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testInversedMonthsRanges() {
        Cron cron = Cron.$()
                .month(Cron.Range.$()
                        .from(20)
                        .to(10));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsRangesBothEndsAreEqual() {
        Cron cron = Cron.$()
                .month(Cron.Range.$()
                        .from(2)
                        .to(2));
        cron.accept(visitor);
        String expected = "* * * 2-2 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsRangesNamed() {
        Cron cron = Cron.$()
                .month(Cron.MonthRange.$()
                        .from(Cron.Month.JAN)
                        .to(Cron.Month.DEC), null);
        cron.accept(visitor);
        String expected = "* * * JAN-DEC *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsMultipleRanges() {
        Cron cron = Cron.$()
                .month(Cron.Range.$()
                                .from(11)
                                .to(12),
                        Cron.Range.$()
                                .from(9)
                                .to(10));
        cron.accept(visitor);
        String expected = "* * * 11-12,9-10 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsPeriodicsFromZeroMinunte() {
        Cron cron = Cron.$()
                .month(Cron.Periodic.$()
                        .from(3)
                        .every(20));
        cron.accept(visitor);
        String expected = "* * * 3/20 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsPeriodicsEvery20Months() {
        Cron cron = Cron.$()
                .month(Cron.Periodic.$()
                        .every(20));
        cron.accept(visitor);
        String expected = "* * * */20 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsPeriodicsEveryZeroMinunte() {
        Cron cron = Cron.$()
                .month(Cron.Periodic.$()
                        .from(10)
                        .every(0));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsPeriodicsFromNegativeMinunte() {
        Cron cron = Cron.$()
                .month(Cron.Periodic.$()
                        .from(-10)
                        .every(3));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsPeriodics() {
        Cron cron = Cron.$()
                .month(Cron.Periodic.$()
                        .from(10)
                        .every(20));
        cron.accept(visitor);
        String expected = "* * * 10/20 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsMultiPeriodics() {
        Cron cron = Cron.$()
                .month(Cron.Periodic.$()
                                .from(1)
                                .every(2),
                        Cron.Periodic.$()
                                .from(4)
                                .every(5));
        cron.accept(visitor);
        String expected = "* * * 1/2,4/5 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMonthsHybridTypes() {
        Cron cron = Cron.$()
                .month(Cron.Periodic.$()
                                .from(10)
                                .every(2),
                        Cron.Range.$()
                                .from(4)
                                .to(5));
        cron.accept(visitor);
        String expected = "* * * 10/2,4-5 *";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
