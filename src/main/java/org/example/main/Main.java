package org.example.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.example.actions.Actions;
import org.example.collections.Branches;
import org.example.condition.Condition;
import org.example.os.Ubuntu;
import org.example.yy.Cron;
import org.example.yy.Job;
import org.example.yy.Matrix;
import org.example.yy.Permissions;
import org.example.yy.Pipe;
import org.example.yy.PullRequest;
import org.example.yy.Push;
import org.example.yy.Schedule;
import org.example.yy.Step;
import org.example.yy.Strategy;
import org.example.yy.Workflow;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        Workflow wf = Workflow.$()
                .name("Maven Build")
                .on(
                        Schedule.$()
                                .cron(
                                        Cron.$()
                                                .dayOfweek(Cron.DaysOfWeek.MON)
                                                .hours(0)
                                                .minutes(30)
                                                .month(Cron.Periodic.$().from(3).every(9))),
                        Push.$()
                                .branches(Branches.master()),
                        PullRequest.$()
                                .branches(Branches.master()))
                .env("TEST", "KEY")
                .jobs(Job.$("build")
                                .runsOn(Ubuntu.latest())
                                .steps(
                                        Step.$()
                                                .uses(Actions.checkoutV3()),
                                        Step.$()
                                                .name("Set up JDK 17")
                                                .uses(Actions.$("setup-java", "v3"))
                                                .with("java-version", Pipe.$().entries("11", "17"))
                                                .with("distribution", "'temurin'")
                                                .with("cache", "maven"),
                                        Step.$()
                                                .name("Build with Maven")
                                                .run("mvn clean install -DskipTests --file pom.xml"),
                                        Step.$()
                                                .name("Update dependency graph")
                                                .uses("advanced-security/maven-dependency-submission-action" +
                                                        "@571e99aab1055c2e71a1e2309b9691de18d6b7d6")),

                        Job.$("another-job")
                                .needs("build")
                                .strategy(Strategy.$()
                                        .failFast(false)
                                        .matrix(Matrix.$()
                                                .line("os", "ubuntu-20.04", "mac-os")
                                                .line("variant", "sdkman")
                                                .include("os","mac-os")
                                        )
                                )
                                .permissions(Permissions.$()
                                        .actions(Permissions.Type.READ)
                                        .checks(Permissions.Type.WRITE)
                                        .contents(Permissions.Type.NONE)
                                )
                                .steps(Step.$()
                                        .name("step-0")
                                        .if_(Condition.always())
                                        .run(Pipe.$().entries("less test.txt", "echo 1")))

                )

                //.toString()
                ;

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

        FileWriter fileWriter = new FileWriter("maven_generated.yml");
        //fileWriter.write(wf);
       // fileWriter.close();
        mapper.writeValue(fileWriter, wf);

    }
}
