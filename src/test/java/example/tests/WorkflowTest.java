package example.tests;

import org.example.Appender;
import org.example.visitor.DefaultVisitorImpl;
import org.example.wrappers.Input;
import org.example.wrappers.Output;
import org.example.yy.Container;
import org.example.yy.Job;
import org.example.yy.PullRequest;
import org.example.yy.PullRequestTarget;
import org.example.yy.Push;
import org.example.yy.Schedule;
import org.example.yy.Service;
import org.example.yy.Step;
import org.example.yy.Workflow;
import org.example.yy.WorkflowDispatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("all")
public class WorkflowTest {
	@Test
	public void testWorkflow() {
		
		Workflow wf = Workflow.$()
				.name("My Workflow")
				.on(Push.$().branches("releases/*", "!releases/**-alpha")
								.paths("path_1", "path_2")
								.tags("tag_1"),
						PullRequest.$().branches("master")
								.types(PullRequest.Type.AUTO_MERGE_DISABLED,
										PullRequest.Type.OPENED),
						Schedule.$().cron("30 5 * * 1,3")
								.cron("20 9 * * 3"),
						Push.$(),
						PullRequestTarget.$(),
						WorkflowDispatch.$()
								.inputs(Input.$()
												.name("logLevel")
												.description("Log Level")
												.type(Input.Type.CHOICE)
												.required()
												.default_("'warning'")
												.options("info", "warning", "error"),
										Input.$()
												.name("settings")
												.required()))
				.env("message", "'conversation'")
				.env("my_token", "${{ secrets.GITHUB_TOKEN }}")
				.jobs(Job.$().label("my_build")
								.if_("${{ input.echo == 'true' }}")
								.runsOn("ubuntu-latest")
								.step(Step.$().name("my_build")
										.uses("actions/checkout@master"))
								.step(Step.$().name("Say something")
										.run("echo lol"))
								.outputs(Output.$().name("result")
										.type(Output.Type.STRING)),
						
						Job.$()
								.label("my_job")
								.id("id-1")
								.needs("my_build", "another_one")
								.container(Container.$().image("node:10.16-jessie")
										.volume("my_docker_volume", "/volume_mount")
										.volume("foo", "bar")
										.env("NODE_ENV", "development")
										.options("--cpus 1")
										.port("80"))
								.service(Service.$()
										.name("redis")
										.image("redis:latest")
										.image("redis:latest")
										.port("6379/tcp")));
		String expected = "name: My Workflow\n" +
				"on:\n" +
				"  push:\n" +
				"    branches:\n" +
				"      - 'releases/*'\n" +
				"      - '!releases/**-alpha'\n" +
				"    paths:\n" +
				"      - 'path_1'\n" +
				"      - 'path_2'\n" +
				"    tags:\n" +
				"      - 'tag_1'\n" +
				"  pull_request:\n" +
				"    branches:\n" +
				"      - 'master'\n" +
				"    types:\n" +
				"      - auto_merge_disabled\n" +
				"      - opened\n" +
				"  schedule:\n" +
				"    - cron: '30 5 * * 1,3'\n" +
				"    - cron: '20 9 * * 3'\n" +
				"  pull_request_target:\n" +
				"  workflow_dispatch:\n" +
				"    inputs:\n" +
				"      logLevel:\n" +
				"        description: \"Log Level\"\n" +
				"        type: choice\n" +
				"        required: true\n" +
				"        default: 'warning'\n" +
				"        options:\n" +
				"          - 'info'\n" +
				"          - 'warning'\n" +
				"          - 'error'\n" +
				"      settings:\n" +
				"        required: true\n" +
				"env:\n" +
				"  message: 'conversation'\n" +
				"  my_token: ${{ secrets.GITHUB_TOKEN }}\n" +
				"jobs:\n" +
				"  my_build:\n" +
				"    if: ${{ input.echo == 'true' }}\n" +
				"    runs-on: ubuntu-latest\n" +
				"    steps:\n" +
				"      - name: my_build\n" +
				"        uses: actions/checkout@master\n" +
				"      - name: Say something\n" +
				"        run: echo lol\n" +
				"    outputs:\n" +
				"      result:\n" +
				"        type: string\n" +
				"  my_job:\n" +
				"    id: id-1\n" +
				"    needs:\n" +
				"      - my_build\n" +
				"      - another_one\n" +
				"    container:\n" +
				"      image: node:10.16-jessie\n" +
				"      volumes:\n" +
				"        - my_docker_volume:/volume_mount\n" +
				"        - foo:bar\n" +
				"      env:\n" +
				"        NODE_ENV: development\n" +
				"      options: --cpus 1\n" +
				"      ports:\n" +
				"        - 80\n" +
				"    services:\n" +
				"      redis:\n" +
				"        image: redis:latest\n" +
				"        ports:\n" +
				"          - 6379/tcp";
		System.out.println(wf.toString());
		Appender arg = new Appender();
		wf.accept(new DefaultVisitorImpl(), arg);
		Assertions.assertEquals(expected, arg.toString());
	}
}