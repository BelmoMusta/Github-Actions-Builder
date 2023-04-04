package example.tests;

import org.example.yy.Cron;
import org.example.yy.Release;
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
				.hour(0)
				.dayOfweek(3);
		
		String expected = "0 0 * * 3";
		Assertions.assertEquals(expected, cron.toString());
	}
	
	@Test
	public void testScheduleWithCronBuilder() {
		Schedule release = Schedule.$()
				.cron(Cron.$()
						.minutes(0)
						.hour(0))
				.cron(Cron.$()
						.minutes(2, 10)
						.hour(4, 5))
				.cron(Cron.$()
						.minutes(0)
						.hour(1)
						.dayOfweek(3));
		release.accept(visitor, appender);
		String expected = "schedule:\n" +
				"  - cron: '0 0 * * *'\n" +
				"  - cron: '2,10 4,5 * * *'\n" +
				"  - cron: '20/15 * * * *'\n" +
				"  - cron: '30 4-6 * * *'\n" +
				"  - cron: '0 1 * * 3'";
		Assertions.assertEquals(expected, appender.toString());
	}
}
