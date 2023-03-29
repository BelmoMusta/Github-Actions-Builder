package example.tests;

import org.example.Appender;
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
import org.example.visitor.DefaultVisitorImpl;
import org.example.wrappers.Input;
import org.example.wrappers.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VisitorTest {
	@Test
	public void main() {
		
		Workflow wf = Workflow.$().name("My Workflow")
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
						WorkflowDispatch.$().inputs(Input.$().name("logLevel")
										.description("log level")
										.type(Input.Type.choice)
										.required()
										.default_("warning")
										.options("info", "warning", "error"),
								Input.$().name("settings")
										.required()))
				.env("message", "'conversation'")
				.env("my_token", "${{ secrets.GITHUB_TOKEN }}")
				.jobs(Job.$().name("my_build")
								.if_("${{ input.echo == 'true' }}")
								.runsOn("ubuntu-latest")
								.step(Step.$().name("my_build")
										.uses("actions/checkout@master"))
								.step(Step.$().name("Say something")
										.run("echo lol"))
								.outputs(Output.$().name("result")
										.type(Output.Type.string_)),
						
						Job.$().name("my_job")
								.id("id-1")
								.needs("my_build", "another_one")
								.container(Container.$().image("node:10.16-jessie")
										.volume("my_docker_volume", "/volume_mount")
										.volume("foo", "bar")
										.env("NODE_ENV", "development")
										.options("--cpus 1")
										.port("80"))
								.service(Service.$().name("redis")
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
				"        description: 'log level'\n" +
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
		DefaultVisitorImpl defaultVisitor = new DefaultVisitorImpl();
		Appender appender = new Appender();
		wf.accept(defaultVisitor, appender);
		Assertions.assertEquals(expected, appender.toString());
		
	}
	
	@Test
	public void test2() {
		
		Workflow wf = Workflow.$().name("generated")
				.on(Push.$().branches("branch1", "branch2")
								.tags("tag1", "tag2")
								.paths("path1", "path2"),
						PullRequest.$()
								.types(PullRequest.Type.AUTO_MERGE_DISABLED,
										PullRequest.Type.OPENED)
								.branches("branch1", "branch2")
								.paths("path1", "path2"),
						Schedule.$().cron("0 0 * * *"),
						WorkflowDispatch.$()
								.inputs(Input.$()
												.name("logLevel")
												.description("log level")
												.type(Input.Type.choice)
												.required()
												.default_("warning")
												.options("info", "warning", "debug"),
										Input.$().name("settings")
												.required()),
						PullRequestTarget.$())
				.env("GRADLE_ENTERPRISE_ACCESS_KEY", "${{ secrets.GRADLE_ENTERPRISE_ACCESS_KEY }}")
				.env("GRADLE_BUILD_ACTION_CACHE_DEBUG_ENABLED", "true")
				.jobs(Job.$()
								.name("check_yaml_consistency")
								.label("Check YAML consistency")
								//.if_("${{ input.echo == 'true' }}")
								.runsOn("ubuntu-latest")
								.step(Step.$()
										.id("step-0")
										.name("Check out")
										.uses("actions/checkout@v3"))
								.step(Step.$()
										.name("Install Kotlin")
										.run("sudo snap install --classic kotlin"))
								.outputs(Output.$().name("result")
										.type(Output.Type.string_)),
						
						Job.$()
								.name("my_job")
								.id("id-1")
								.needs("my_build", "another_one")
								.container(Container.$().image("node:10.16-jessie")
										.volume("my_docker_volume", "/volume_mount")
										.volume("foo", "bar")
										.env("NODE_ENV", "development")
										.options("--cpus 1")
										.port("80"))
								.service(Service.$().name("redis")
										.image("redis:latest")
										.image("redis:latest")
										.port("6379/tcp")));
		String expected = "name: generated\n" +
				"on:\n" +
				"  push:\n" +
				"    branches:\n" +
				"      - 'branch1'\n" +
				"      - 'branch2'\n" +
				"    tags:\n" +
				"      - 'tag1'\n" +
				"      - 'tag2'\n" +
				"    paths:\n" +
				"      - 'path1'\n" +
				"      - 'path2'\n" +
				"  pull_request:\n" +
				"    types:\n" +
				"      - auto_merge_disabled\n" +
				"      - opened\n" +
				"    branches:\n" +
				"      - 'branch1'\n" +
				"      - 'branch2'\n" +
				"    paths:\n" +
				"      - 'path1'\n" +
				"      - 'path2'\n" +
				"  schedule:\n" +
				"    - cron: '0 0 * * *'\n" +
				"  workflow_dispatch:\n" +
				"    inputs:\n" +
				"      logLevel:\n" +
				"        description: 'log level'\n" +
				"        type: choice\n" +
				"        required: true\n" +
				"        default: 'warning'\n" +
				"        options:\n" +
				"          - 'info'\n" +
				"          - 'warning'\n" +
				"          - 'debug'\n" +
				"      settings:\n" +
				"        required: true\n" +
				"  pull_request_target:\n" +
				"env:\n" +
				"  GRADLE_ENTERPRISE_ACCESS_KEY: ${{ secrets.GRADLE_ENTERPRISE_ACCESS_KEY }}\n" +
				"  GRADLE_BUILD_ACTION_CACHE_DEBUG_ENABLED: true\n" +
				"jobs:\n" +
				"  check_yaml_consistency:\n" +
				"    name: Check YAML consistency\n" +
				"    runs-on: ubuntu-latest\n" +
				"    steps:\n" +
				"      - id: step-0\n" +
				"        name: Check out\n" +
				"        uses: actions/checkout@v3\n" +
				"      - id: step-1\n" +
				"        name: Install Kotlin\n" +
				"        run: sudo snap install --classic kotlin\n" +
				"      - id: step-2\n" +
				"        if: \"true\"\n" +
				"        name: Consistency check\n" +
				"        run: diff -u '.github/workflows/build.yaml' <('.github/workflows/build.main.kts')\n" +
				"        env:\n" +
				"          HELLO: ok\n" +
				"          PAT: rick\n" +
				"  \"build_for_UbuntuLatest\":\n" +
				"    runs-on: \"ubuntu-latest\"\n" +
				"    env:\n" +
				"      COLOR: blue\n" +
				"      SIZE: XXL\n" +
				"    needs:\n" +
				"      - \"check_yaml_consistency\"\n" +
				"    steps:\n" +
				"      - id: step-0\n" +
				"        name: Checkout\n" +
				"        uses: actions/checkout@v3\n" +
				"        env:\n" +
				"          HELLO: ok\n" +
				"          PAT: rick\n" +
				"      - id: step-1\n" +
				"        name: Set up JDK\n" +
				"        uses: actions/setup-java@v3\n" +
				"        with:\n" +
				"          java-version: 11\n" +
				"          distribution: adopt\n" +
				"        env:\n" +
				"          HELLO: ok\n" +
				"          PAT: rick\n" +
				"      - id: step-2\n" +
				"        name: Build\n" +
				"        uses: gradle/gradle-build-action@v2\n" +
				"        with:\n" +
				"          arguments: build\n" +
				"      - id: step-3\n" +
				"        name: setup\n" +
				"        uses: docker/setup-buildx-action@v1\n" +
				"        with:\n" +
				"          driver-opts: |\n" +
				"            hello\n" +
				"            world\n" +
				"          install: true";
		DefaultVisitorImpl defaultVisitor = new DefaultVisitorImpl();
		Appender appender = new Appender();
		wf.accept(defaultVisitor, appender);
		Assertions.assertEquals(expected, appender.toString());
		
	}
}
