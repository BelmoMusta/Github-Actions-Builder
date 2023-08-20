package org.example.yaml.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.example.yaml.dtos.events.CheckRun;
import org.example.yaml.dtos.events.CheckSuite;
import org.example.yaml.dtos.events.Push;
import org.example.yaml.dtos.events.RegistryPackage;
import org.example.yaml.dtos.events.Schedule;
import org.example.yaml.dtos.events.WorkflowDispatch;
import org.example.yaml.dtos.inputs.Input;
import org.example.yaml.dtos.inputs.Output;
import org.example.yaml.dtos.jobs.Concurrency;
import org.example.yaml.dtos.jobs.Container;
import org.example.yaml.dtos.jobs.Credentials;
import org.example.yaml.dtos.jobs.Defaults;
import org.example.yaml.dtos.jobs.Job;
import org.example.yaml.dtos.jobs.Permissions;
import org.example.yaml.dtos.jobs.Run;
import org.example.yaml.dtos.jobs.Service;
import org.example.yaml.dtos.jobs.Step;

import java.io.FileWriter;

public class YamlMain {
    public static void main(String[] args) throws Exception {
        YamlWorkflow wf = YamlWorkflow.$("test-WF")
                .on(
                        Schedule.$()
                                .cron("* * * * *")
                                .cron("1 * * * *")
                                .cron("2 * * * *"),
                        CheckSuite.$()
                                .types(CheckSuite.Type.COMPLETED),
                        CheckRun.$()
                                .types(CheckRun.Type.COMPLETED,
                                        CheckRun.Type.COMPLETED,
                                        CheckRun.Type.CREATED),
                        WorkflowDispatch.$()
                                .inputs(Input.$()
                                                .name("in")
                                                .description("totoootot")
                                                .type(Input.Type.BOOLEAN)
                                                .default_("false")
                                                .required(),
                                        Input.$().name("test")
                                                .options("lol", "foo"))
                                .outputs(Output.$().name("version")
                                        .value("1.0.0")),
                        Push.$()
                                .branches("master")
                                .ignoreBranches("not_master")
                                .tags("my_tag")
                                .ignoreTags("not_my_tag")
                                .paths("/path1", "/path 2")
                                .ignorePaths("test/path"),
                        RegistryPackage.$().types(RegistryPackage.Type.PUBLISHED)
                )
                .jobs(Job.$()
                        .name("update-concourse-tasks")
                        .cancelTimeoutMinutes(5)
                        .concurrency(Concurrency.$()
                                .group("grp")
                                .cancelInProgress(true)
                        )
                        .container(Container.$().image("alpine")
                                .options("--cpu 1")
                                .env("h", "v")
                                .port(80, 90)
                                .volumes("/etc", "~/test")
                                .volumes("/opt", "~/test")
                                .credentials(Credentials.$()
                                        .username("user")
                                        .password("1234"))
                        )
                        .services(Service.$("redis")
                                .image("redis")
                                .options("--cpu 1")
                                .env("h", "v")
                                .port(80, 90)
                                .volumes("/etc", "~/test")
                                .volumes("/opt", "~/test")
                                .credentials(Credentials.$()
                                        .username("user")
                                        .password("1234")))
                        .environment("NonProd")
                        .runsOn("self-hosted")
                        .continueOnError(true)
                        .defaults(Defaults.$()
                                .run(Run.$()
                                        .shell("bash")
                                        .workingDirectory(".")
                                )
                        )
                        .env("key", "value")
                        .env("key2", "value2")
                        .if_("${{ condition }}")
                        .permissions(Permissions.$()
                                .actions(Permissions.Type.READ))
                        .steps(Step.$().name("my_build")
                                .uses("actions/checkout@master"))
                        .steps(Step.$().name("Say something")
                                .run("echo lol"))

                );
        YAMLFactory yamlFactory = new MyFactory()
                .enable(YAMLGenerator.Feature.INDENT_ARRAYS_WITH_INDICATOR)
                // .enable(WRITE_SINGLE_QUOTES)
                ;
        ObjectMapper mapper = new ObjectMapper(yamlFactory);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);


        FileWriter fileWriter = new FileWriter("yaml_maven_generated.yml");
        //fileWriter.write(wf);
        // fileWriter.close();
        mapper.writeValue(fileWriter, wf);
    }
}
