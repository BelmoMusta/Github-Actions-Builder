package org.example.main;

import org.example.Container;
import org.example.Job;
import org.example.PullRequest;
import org.example.PullRequestTarget;
import org.example.Push;
import org.example.Schedule;
import org.example.Service;
import org.example.Step;
import org.example.Workflow;
import org.example.WorkflowDispatch;
import org.example.wrappers.Input;
import org.example.wrappers.Type;

public class Main {
	public static void main(String[] args) {
		Workflow wf = Workflow
				.name("My Workflow")
				.on(Push.branches("releases/*", "!releases/**-alpha")
								.paths("path_1", "path_2")
								.tags("tag_1"),
						PullRequest.types("auto_merge_disabled", "opened")
								.branches("master"),
						Schedule.cron("30 5 * * 1,3")
								.thenCron("20 9 * * 3"),
						Push.$(),
						//WorkflowDispatch.$(),
						PullRequestTarget.$(),
						WorkflowDispatch.inputs(
								Input.name("logLevel")
										.description("Log Level")
										.type(Type.choice)
										.required()
										.default_("warning")
										.options("info", "warning", "error"),
								Input.name("settings").required()
						)
				)
				
				.env("message", "'conversation'")
				.env("my_token", "${{ secrets.GITHUB_TOKEN }}")
				.job(Job.name("my_build")
						.runsOn("ubuntu-latest")
						.step(Step.name("my_build")
								.uses("actions/checkout@master"))
						.step(Step.name("Say something")
								.run("echo lol")))
				.job(Job.name("my_job")
						.needs("my_build")
						.container(Container.image("node:10.16-jessie")
								.volume("my_docker_volume", "/volume_mount")
								.volume("foo", "bar")
								.env("NODE_ENV", "development")
								.options("--cpus 1")
								.port("80"))
						.service(Service.image("redis")
								.port("6379/tcp")));
		System.out.println(wf.toString());
		
		
	}
}