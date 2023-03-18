package org.example;

public class Main {
	static Job name(String jobName){
		Job job = new Job();
		job.name = jobName;
		return job;
	}
	static Push push(){
		return new Push();
	}
	static WorkflowDispatch workflowDispatch(){
		return new WorkflowDispatch();
	}
	public static void main(String[] args) {
		Workflow wf = Workflow
				.name("My Workflow")
				.on(push().branches("releases/*", "!releases/**-alpha"))
				.on(workflowDispatch().branches("develop", "main", "master"))
				.env("message", "'conversation'")
				.env("my_token", "${{ secrets.GITHUB_TOKEN }}")
				.job(name("my_build")
						.runsOn("ubuntu-latest")
						.step(Step.name("my_build")
								.uses("actions/checkout@master"))
						.step(Step.name("Say something")
								.run("echo lol")))
				.job(name("my_job")
						.needs("my_build")
						.container(Container.image("node:10.16-jessie")
								.volume("my_docker_volume", "/volume_mount")
								.volume("foo", "bar")
								.options("--cpus 1"))
						.service(Service.image("redis")
								.port("6379/tcp")));
		System.out.println(wf.toString());
		
		
	}
}