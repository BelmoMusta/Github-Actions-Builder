package example.tests;

import org.example.yy.Cron;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CronMinutesTest extends AbstracTest {
	@Test
	public void testZeroMinutes() {
		Cron cron = Cron.$()
				.minutes(0);
		cron.accept(visitor);
		String expected = "0 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testNegativeMinutes() {
		Cron cron = Cron.$()
				.minutes(-5);
		cron.accept(visitor);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMultiMinutes() {
		Cron cron = Cron.$()
				.minutes(1, 30);
		cron.accept(visitor);
		String expected = "1,30 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testInversedMultiMinutes() {
		Cron cron = Cron.$()
				.minutes(30, 1);
		cron.accept(visitor);
		String expected = "30,1 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesRanges() {
		Cron cron = Cron.$()
				.minutes(Cron.Range.$()
						.from(10)
						.to(20));
		cron.accept(visitor);
		String expected = "10-20 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testInversedMinutesRanges() {
		Cron cron = Cron.$()
				.minutes(Cron.Range.$()
						.from(20)
						.to(10));
		cron.accept(visitor);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesRangesBothEndsAreEqual() {
		Cron cron = Cron.$()
				.minutes(Cron.Range.$()
						.from(20)
						.to(20));
		cron.accept(visitor);
		String expected = "20-20 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesMultipleRanges() {
		Cron cron = Cron.$()
				.minutes(Cron.Range.$()
								.from(10)
								.to(20),
						Cron.Range.$()
								.from(30)
								.to(40));
		cron.accept(visitor);
		String expected = "10-20,30-40 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesPeriodicsFromZeroMinunte() {
		Cron cron = Cron.$()
				.minutes(Cron.Periodic.$()
						.from(0)
						.every(20));
		cron.accept(visitor);
		String expected = "*/20 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesPeriodicsEveryZeroMinunte() {
		Cron cron = Cron.$()
				.minutes(Cron.Periodic.$()
						.from(10)
						.every(0));
		cron.accept(visitor);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesPeriodicsFromNegativeMinunte() {
		Cron cron = Cron.$()
				.minutes(Cron.Periodic.$()
						.from(-10)
						.every(3));
		cron.accept(visitor);
		String expected = "* * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesPeriodics() {
		Cron cron = Cron.$()
				.minutes(Cron.Periodic.$()
						.from(10)
						.every(20));
		cron.accept(visitor);
		String expected = "10/20 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesMultiPeriodics() {
		Cron cron = Cron.$()
				.minutes(Cron.Periodic.$()
								.from(10)
								.every(20),
						Cron.Periodic.$()
								.from(40)
								.every(5));
		cron.accept(visitor);
		String expected = "10/20,40/5 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
	
	@Test
	public void testMinutesHybridTypes() {
		Cron cron = Cron.$()
				.minutes(Cron.Periodic.$()
								.from(10)
								.every(20),
						Cron.Range.$()
								.from(4)
								.to(5));
		cron.accept(visitor);
		String expected = "10/20,4-5 * * * *";
		Assertions.assertEquals(expected, visitor.getResult());
	}
}
