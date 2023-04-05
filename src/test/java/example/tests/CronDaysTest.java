package example.tests;

import org.example.yy.Cron;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CronDaysTest extends AbstracTest {
	@Test
	public void testZeroDay() {
		Cron cron = Cron.$()
				.day(0);
		cron.accept(visitor, appender);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	@Test
	public void testFirstDay() {
		Cron cron = Cron.$()
				.day(1);
		cron.accept(visitor, appender);
		String expected = "* * 1 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testNegativeDay() {
		Cron cron = Cron.$()
				.day(-5);
		cron.accept(visitor, appender);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testMultiDay() {
		Cron cron = Cron.$()
				.day(1, 12);
		cron.accept(visitor, appender);
		String expected = "* * 1,12 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testInversedMultiDay() {
		Cron cron = Cron.$()
				.day(12, 1);
		cron.accept(visitor, appender);
		String expected = "* * 12,1 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysRanges() {
		Cron cron = Cron.$()
				.day(Cron.Range.$()
						.from(10)
						.to(20));
		cron.accept(visitor, appender);
		String expected = "* * 10-20 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testInversedDaysRanges() {
		Cron cron = Cron.$()
				.day(Cron.Range.$()
						.from(20)
						.to(10));
		cron.accept(visitor, appender);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysRangesBothEndsAreEqual() {
		Cron cron = Cron.$()
				.day(Cron.Range.$()
						.from(20)
						.to(20));
		cron.accept(visitor, appender);
		String expected = "* * 20-20 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysMultipleRanges() {
		Cron cron = Cron.$()
				.day(Cron.Range.$()
								.from(11)
								.to(12),
						Cron.Range.$()
								.from(9)
								.to(10));
		cron.accept(visitor, appender);
		String expected = "* * 11-12,9-10 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysPeriodicsFromZeroMinunte() {
		Cron cron = Cron.$()
				.day(Cron.Periodic.$()
						.from(3)
						.every(20));
		cron.accept(visitor, appender);
		String expected = "* * 3/20 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	@Test
	public void testDaysPeriodicsEvery20Days() {
		Cron cron = Cron.$()
				.day(Cron.Periodic.$()
						.every(20));
		cron.accept(visitor, appender);
		String expected = "* * */20 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysPeriodicsEveryZeroMinunte() {
		Cron cron = Cron.$()
				.day(Cron.Periodic.$()
						.from(10)
						.every(0));
		cron.accept(visitor, appender);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysPeriodicsFromNegativeMinunte() {
		Cron cron = Cron.$()
				.day(Cron.Periodic.$()
						.from(-10)
						.every(3));
		cron.accept(visitor, appender);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysPeriodics() {
		Cron cron = Cron.$()
				.day(Cron.Periodic.$()
						.from(10)
						.every(20));
		cron.accept(visitor, appender);
		String expected = "* * 10/20 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysMultiPeriodics() {
		Cron cron = Cron.$()
				.day(Cron.Periodic.$()
								.from(1)
								.every(2),
						Cron.Periodic.$()
								.from(4)
								.every(5));
		cron.accept(visitor, appender);
		String expected = "* * 1/2,4/5 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testDaysHybridTypes() {
		Cron cron = Cron.$()
				.day(Cron.Periodic.$()
								.from(10)
								.every(2),
						Cron.Range.$()
								.from(4)
								.to(5));
		cron.accept(visitor, appender);
		String expected = "* * 10/2,4-5 * *";
		Assertions.assertEquals(expected, appender.toString());
	}
}
