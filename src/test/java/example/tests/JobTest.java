package example.tests;

import org.example.Appender;
import org.example.yy.Job;
import org.example.yy.Step;
import org.example.visitor.DefaultVisitorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JobTest {
	static String EXPECTED = "my_build:\n" +
			"  name: my_build\n" +
			"  id: first-job\n" +
			"  runs-on: ubuntu-latest\n" +
			"  steps:\n" +
			"    - name: Checking out our code\n" +
			"      uses: actions/checkout@master\n" +
			"    - name: Say something\n" +
			"      run: echo lol\n" +
			"  needs:\n" +
			"    - a\n" +
			"    - w\n" +
			"    - b";
	@Test
	public void main() {
		Job job = Job.$().name("my_build")
				.explicitName()
				.id("first-job")
				.runsOn("ubuntu-latest")
				.step(Step.$()
						.name("Checking out our code")
						.uses("actions/checkout@master")
				)
				.needs(Job.$().name("a"))
				.needs("w")
				.needs("w")
				.needs("b")
				.step(Step.$().name("Say something")
						.run("echo lol"));
		DefaultVisitorImpl visitor = new DefaultVisitorImpl();
		Appender appender = new Appender();
		job.accept(visitor, appender);
		Assertions.assertEquals(EXPECTED, appender.toString());
		System.out.println(appender);
	}
}
