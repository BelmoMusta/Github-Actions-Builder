package example.tests;

import org.example.collections.Jobs;
import org.example.wrappers.leaves.Credentials;
import org.example.yy.Concurrency;
import org.example.yy.Container;
import org.example.yy.Defaults;
import org.example.yy.Job;
import org.example.yy.Matrix;
import org.example.yy.Permissions;
import org.example.yy.Pipe;
import org.example.yy.Run;
import org.example.yy.Service;
import org.example.yy.Step;
import org.example.yy.Strategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JobTest extends AbstracTest {
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
	public void testJob() {
		Job job = Job.$()
				.label("my_build")
				.name("my_build")
				.id("first-job")
				.runsOn("ubuntu-latest")
				.step(Step.$()
						.name("Checking out our code")
						.uses("actions/checkout@master")
				)
				
				.needs("a")
				.needs("w")
				.needs("w")
				.needs("b")
				.step(Step.$().name("Say something")
						.run("echo lol"));
		job.accept(visitor);
		Assertions.assertEquals(EXPECTED, visitor.getResult());
	}
	
	static String EXP = "jobs:\n" +
			"  update-concourse-tasks:\n" +
			"    cancel-timeout-minutes: 5\n" +
			"    concurrency:\n" +
			"      group: ${{ github.ref }}\n" +
			"      cancel-in-progress: true\n" +
			"    container:\n" +
			"      image: ubuntu\n" +
			"      env:\n" +
			"        h: \"h\"\n" +
			"      options: --cpu1\n" +
			"      ports:\n" +
			"        - 80\n" +
			"      volumes:\n" +
			"        - env:/\n" +
			"      credentials:\n" +
			"        username: \"s\"\n" +
			"        password: \"ee\"\n" +
			"    runs-on: self-hosted\n" +
			"    continue-on-error: false\n" +
			"    defaults:\n" +
			"      run:\n" +
			"        shell: echo 1\n" +
			"        working-directory: .\n" +
			"    env:\n" +
			"      ok: true\n" +
			"    if: \"${{github.inputs.id}}\"\n" +
			"    name: toto\n" +
			"    permissions:\n" +
			"      actions: read\n" +
			"      checks: write\n" +
			"      contents: write\n" +
			"      deployments: write\n" +
			"      discussions: write\n" +
			"      packages: write\n" +
			"      statuses: write\n" +
			"      pages: write\n" +
			"      id-token: write\n" +
			"      pull-requests: write\n" +
			"      repository-projects: write\n" +
			"      security-events: write\n" +
			"      issues: none\n" +
			"    services:\n" +
			"      redis:\n" +
			"        ports:\n" +
			"          - 90\n" +
			"        image: ubuntu\n" +
			"        env:\n" +
			"          h: ok\n" +
			"        options: --ls\n" +
			"        volumes:\n" +
			"          - v:/\n" +
			"        credentials:\n" +
			"          username: \"s\"\n" +
			"          password: \"ee\"\n" +
			"    steps:\n" +
			"      - name: Checkout\n" +
			"        uses: actions/checkout@v3\n" +
			"        continue-on-error: false\n" +
			"        id: eee\n" +
			"        if: dsd\n" +
			"        timeout-minutes: 2\n" +
			"        with:\n" +
			"          d: sd\n" +
			"        env:\n" +
			"          f: ok\n" +
			"      - name: Import Secrets\n" +
			"        id: secrets\n" +
			"        uses: hashicorp/vault-action@v2.5.0\n" +
			"        with:\n" +
			"          url: https://vault.hash.com\n" +
			"          method: approle\n" +
			"          secrets: |\n" +
			"            concourse/cloud-pipelines/github-access-token-pr value | TOKEN ;\n" +
			"      - name: Set Up Python\n" +
			"        run: echo 1\n" +
			"        shell: a\n" +
			"      - shell: b\n" +
			"        name: last-one";
	
	@Test
	public void testJobBis() {
		
		Job job = Job.$()
				.label("update-concourse-tasks")
				.cancelTimeOutMinutes(5)
				.concurrency(Concurrency.$()
						.group("${{ github.ref }}")
						.cancelInProgress(true))
				.container(Container.$().image("ubuntu")
						.env("h", "\"h\"")
						.options("--cpu1")
						.port(80)
						.volume("env", "/")
						.credentials(Credentials.$()
								.username("s")
								.password("ee")))
				.environment("NonProd")
				.runsOn("self-hosted")
				.continueOnError(false)
				.defaults(Defaults.$()
						.run(Run.$()
								.shell("echo 1")
								.workingDirectory(".")))
				.env("ok", "true")
				.if_("\"${{github.inputs.id}}\"")
				.name("toto")
				.permissions(Permissions.$()
						.actions(Permissions.Type.READ)
						.checks(Permissions.Type.WRITE)
						.contents(Permissions.Type.WRITE)
						.deployments(Permissions.Type.WRITE)
						.discussions(Permissions.Type.WRITE)
						.packages(Permissions.Type.WRITE)
						.statuses(Permissions.Type.WRITE)
						.pages(Permissions.Type.WRITE)
						.idToken(Permissions.Type.WRITE)
						.pullRequests(Permissions.Type.WRITE)
						.repositoryProjects(Permissions.Type.WRITE)
						.securityEvents(Permissions.Type.WRITE)
						.issues(Permissions.Type.NONE))
				.service(Service.$()
						.name("redis")
						.port("90")
						.image("ubuntu")
						.env("h", "ok")
						.options("--ls")
						.volume("v", "/")
						.credentials(Credentials.$()
								.username("s")
								.password("ee")))
				.step(Step.$()
						.name("Checkout")
						.uses("actions/checkout@v3")
						.continueOnError(false)
						.id("eee")
						.if_("dsd")
						.timeoutMinutes(2)
						.with("d", "sd")
						.env("f", "ok"))
				.step(Step.$()
						.name("Import Secrets")
						.id("secrets")
						.uses("hashicorp/vault-action@v2.5.0")
						.with("url", "https://vault.hash.com")
						.with("method", "approle")
						.with("secrets", Pipe.$()
								.entries("concourse/cloud-pipelines/github-access-token-pr value | " +
										"TOKEN ;")))
				.step(Step.$()
						.name("Set Up Python")
						.run("echo 1")
						.shell("a"))
				.step(Step.$()
						.shell("b")
						.name("last-one"));
		
		Jobs jobs = new Jobs();
		jobs.add(job);
		
		jobs.accept(visitor);
		Assertions.assertEquals(EXP, visitor.getResult());
	}
	
	static String EXPECTED_MATRIX = "jobs:\n" +
			"  example_matrix:\n" +
			"    strategy:\n" +
			"      matrix:\n" +
			"        os: [ubuntu-22.04, ubuntu-20.04, ubuntu-21.04]\n" +
			"        version: [10, 12, 14, 8]\n" +
			"    runs-on: ${{ matrix.os }}\n" +
			"    steps:\n" +
			"      - uses: actions/setup-node@v3\n" +
			"        with:\n" +
			"          node-version: ${{ matrix.version }}";
	
	@Test
	public void testJobMatrix() {
		
		Job job = Job.$()
				.label("example_matrix")
				.strategy(Strategy.$()
						.matrix(Matrix.$()
								.line("os", "ubuntu-22.04", "ubuntu-20.04")
								.line("os", "ubuntu-21.04")
								.line("version", "10", "12", "14")
								.line("version", "8")))
				.runsOn("${{ matrix.os }}")
				.step(Step.$().uses("actions/setup-node@v3")
						.with("node-version", "${{ matrix.version }}"));
		
		Jobs jobs = new Jobs();
		jobs.add(job);
		
		jobs.accept(visitor);
		Assertions.assertEquals(EXPECTED_MATRIX, visitor.getResult());
	}
	
}
