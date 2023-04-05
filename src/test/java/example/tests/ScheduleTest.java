package example.tests;

import org.example.yy.Cron;
import org.example.yy.Schedule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScheduleTest extends AbstracTest {
	
	@Test
	public void initTest() {
		Schedule release = Schedule.$()
				.cron("0 0 * * *")
				.cron("0 1 * * *");
		release.accept(visitor, appender);
		String expected = "schedule:\n" +
				"  - cron: '0 0 * * *'\n" +
				"  - cron: '0 1 * * *'";
		Assertions.assertEquals(expected, appender.toString());
	}
	
	@Test
	public void testCronBuilder() {
		Cron cron = Cron.$()
				.minutes(0)
				.hours(0)
				.dayOfweek(3);
		
		String expected = "0 0 * * 3";
		Assertions.assertEquals(expected, cron.toString());
	}
	
	@Test
	public void testScheduleWithCronBuilder() {
		Schedule release = Schedule.$()
				.cron(Cron.$()
						.minutes(0)
						.hours(0))
				.cron(Cron.$()
						.minutes(2, 10)
						.hours(4, 5))
				.cron(Cron.$()
						.minutes(Cron.Range.$()
								.from(0)
								.to(20)))
				.cron(Cron.$()
						.minutes(Cron.Periodic.$()
								.from(20)
								.every(15)))
				.cron(Cron.$()
						.minutes(30)
						.hours(Cron.Range.$()
								.from(4)
								.to(6)))
				.cron(Cron.$()
						.minutes(0)
						.hours(1)
						.dayOfweek(3))
				.cron(Cron.$().minutes(23)
						.hours(Cron.Range.$()
								.from(0)
								.to(20)
								.pastEvery(2)))
				.cron(Cron.$()
						.minutes(5)
						.hours(4)
						.dayOfweek(Cron.DaysOfWeek.SUN));
		release.accept(visitor, appender);
		String expected = "schedule:\n" +
				"  - cron: '0 0 * * *'\n" +
				"  - cron: '2,10 4,5 * * *'\n" +
				"  - cron: '0-20 * * * *'\n" +
				"  - cron: '20/15 * * * *'\n" +
				"  - cron: '30 4-6 * * *'\n" +
				"  - cron: '0 1 * * 3'\n" +
				"  - cron: '23 0-20/2 * * *'\n" +
				"  - cron: '5 4 * * SUN'";
		Assertions.assertEquals(expected, appender.toString());
	}
}
