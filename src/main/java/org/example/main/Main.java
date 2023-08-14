package org.example.main;

import org.example.collections.Branches;
import org.example.os.Ubuntu;
import org.example.yy.Job;
import org.example.yy.PullRequest;
import org.example.yy.Push;
import org.example.yy.Step;
import org.example.yy.Workflow;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        String wf = Workflow.$()
                .name("Maven Build")
                .on(Push.$()
                        .branches(Branches.master()))
                .on(PullRequest.$()
                        .branches(Branches.master()))
                .jobs(Job.$("build")
                        .runsOn(Ubuntu.latest())
                        .steps(
                                Step.$()
                                        .uses("actions/checkout@v3"),
                                Step.$()
                                        .name("Set up JDK 17")
                                        .uses("actions/setup-java@v3")
                                        .with("java-version", "'17'")
                                        .with("distribution", "'temurin'")
                                        .with("cache", "maven"),
                                Step.$()
                                        .name("Build with Maven")
                                        .run("mvn clean install -DskipTests --file pom.xml"),
                                Step.$()
                                        .name("Update dependency graph")
                                        .uses("advanced-security/maven-dependency-submission-action" +
                                                "@571e99aab1055c2e71a1e2309b9691de18d6b7d6")))
                .toString();

        FileWriter fileWriter = new FileWriter("maven_generated.yml");
        fileWriter.write(wf);
        fileWriter.close();

    }
}
