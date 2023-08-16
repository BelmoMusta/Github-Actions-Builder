package org.example.yaml.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.yy.Workflow;

import java.util.ArrayList;
import java.util.List;

public class YamlWorkflow {
    private String name;
    List<YamlEvent> events = new ArrayList<>();
    List<YamlJob> jobs = new ArrayList<>();

    public static YamlWorkflow $(String name) {
        YamlWorkflow yamlWorkflow = new YamlWorkflow();
        yamlWorkflow.name = name;
        return yamlWorkflow;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("on")
//    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public List<YamlEvent> getEvents() {
        return events;
    }
    public void setEvents(List<YamlEvent> events) {
        this.events = events;
    }
    public List<YamlJob> getJobs() {
        return jobs;
    }
    public void setJobs(List<YamlJob> jobs) {
        this.jobs = jobs;
    }
}
