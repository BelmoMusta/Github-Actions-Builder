package example.tests;

import org.example.Appender;
import org.example.Container;
import org.example.Job;
import org.example.Pipe;
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

public class CommentTest {
	
	public static final String EXPECTED = "name: generated\n" +
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
			"  build_for_UbuntuLatest:\n" +
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
								.id("step-1")
								.name("Install Kotlin")
								.run("sudo snap install --classic kotlin"))
						.step(Step.$()
								.id("step-2")
								.if_("\"true\"")
								.name("Consistency check")
								.run("diff -u '.github/workflows/build.yaml' <('.github/workflows/build.main.kts')")
								.env("HELLO", "ok")
								.env("PAT", "rick")
						),
						
						Job.$()
								.name("build_for_UbuntuLatest")
								.runsOn("\"ubuntu-latest\"")
								.env("COLOR", "blue")
								.env("SIZE", "XXL")
								.needs("\"check_yaml_consistency\"")
								.step(Step.$()
										.id("step-0")
										.name("Checkout")
										.uses("actions/checkout@v3")
										.env("HELLO", "ok")
										.env("PAT", "rick"))
								.step(Step.$()
										.id("step-1")
										.name("Set up JDK")
										.uses("actions/setup-java@v3")
										.with("java-version", "11")
										.with("distribution", "adopt")
										.env("HELLO", "ok")
										.env("PAT", "rick"))
								
								.step(Step.$()
										.id("step-2")
										.name("Build")
										.uses("gradle/gradle-build-action@v2")
										.with("arguments", "build"))
								.step(Step.$()
										.id("step-3")
										.name("setup")
										.uses("docker/setup-buildx-action@v1")
										.with("driver-opts", Pipe.$().entries("hello", "world"))
										.with("install", "true"))
				);
		DefaultVisitorImpl defaultVisitor = new DefaultVisitorImpl();
		Appender appender = new Appender();
		wf.accept(defaultVisitor, appender);
		Assertions.assertEquals(EXPECTED, appender.toString());
		
	}
}
