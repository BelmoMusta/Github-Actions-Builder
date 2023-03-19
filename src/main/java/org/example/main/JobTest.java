package org.example.main;

import org.example.Job;
import org.example.Step;

public class JobTest {
	public static void main(String[] args) {
		Job job = Job.name("my_build")
				.runsOn("ubuntu-latest")
				.step(Step.name("Checking out our code")
						.uses("actions/checkout@master"))
				.step(Step.name("Say something")
						.run("echo lol"));
		job.setIndentLevel(0);
		System.out.println(job);
		System.out.println("_____");
	}
}
