package example.tests;

import org.example.yy.Cron;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CronHoursTest extends AbstracTest {
    @Test
    public void testZeroHours() {
        Cron cron = Cron.$()
                .hours(0);
        cron.accept(visitor);
        String expected = "* 0 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testNegativeHours() {
        Cron cron = Cron.$()
                .hours(-5);
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testMultiHours() {
        Cron cron = Cron.$()
                .hours(1, 12);
        cron.accept(visitor);
        String expected = "* 1,12 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testInversedMultiHours() {
        Cron cron = Cron.$()
                .hours(12, 1);
        cron.accept(visitor);
        String expected = "* 12,1 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursRanges() {
        Cron cron = Cron.$()
                .hours(Cron.Range.$()
                        .from(10)
                        .to(20));
        cron.accept(visitor);
        String expected = "* 10-20 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testInversedHoursRanges() {
        Cron cron = Cron.$()
                .hours(Cron.Range.$()
                        .from(20)
                        .to(10));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursRangesBothEndsAreEqual() {
        Cron cron = Cron.$()
                .hours(Cron.Range.$()
                        .from(20)
                        .to(20));
        cron.accept(visitor);
        String expected = "* 20-20 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursMultipleRanges() {
        Cron cron = Cron.$()
                .hours(Cron.Range.$()
                                .from(11)
                                .to(12),
                        Cron.Range.$()
                                .from(9)
                                .to(10));
        cron.accept(visitor);
        String expected = "* 11-12,9-10 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursPeriodicsFromZeroMinunte() {
        Cron cron = Cron.$()
                .hours(Cron.Periodic.$()
                        .from(0)
                        .every(20));
        cron.accept(visitor);
        String expected = "* */20 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursPeriodicsEveryZeroMinunte() {
        Cron cron = Cron.$()
                .hours(Cron.Periodic.$()
                        .from(10)
                        .every(0));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursPeriodicsFromNegativeMinunte() {
        Cron cron = Cron.$()
                .hours(Cron.Periodic.$()
                        .from(-10)
                        .every(3));
        cron.accept(visitor);
        String expected = "* * * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursPeriodics() {
        Cron cron = Cron.$()
                .hours(Cron.Periodic.$()
                        .from(10)
                        .every(20));
        cron.accept(visitor);
        String expected = "* 10/20 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursMultiPeriodics() {
        Cron cron = Cron.$()
                .hours(Cron.Periodic.$()
                                .from(1)
                                .every(2),
                        Cron.Periodic.$()
                                .from(4)
                                .every(5));
        cron.accept(visitor);
        String expected = "* 1/2,4/5 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }

    @Test
    public void testHoursHybridTypes() {
        Cron cron = Cron.$()
                .hours(Cron.Periodic.$()
                                .from(10)
                                .every(2),
                        Cron.Range.$()
                                .from(4)
                                .to(5));
        cron.accept(visitor);
        String expected = "* 10/2,4-5 * * *";
        Assertions.assertEquals(expected, visitor.getResult());
    }
}
