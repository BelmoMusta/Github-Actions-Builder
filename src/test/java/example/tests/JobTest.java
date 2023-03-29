package example.tests;

import org.example.Job;
import org.example.Step;

public class JobTest {
	public static void main(String[] args) {
		Job job = Job.$().name("my_build")
				.explicitName()
				.id("first-job")
				.runsOn("ubuntu-latest")
				.step(Step.$().name("Checking out our code")
						.uses("actions/checkout@master"))
				.needs(Job.$().name("a"))
				.needs("w")
				.needs("b")
				.step(Step.$().name("Say something")
						.run("echo lol"));
		System.out.println(job);
		System.out.println("_____");
	}
}
