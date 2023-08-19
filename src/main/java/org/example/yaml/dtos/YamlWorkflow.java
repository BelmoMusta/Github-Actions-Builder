package org.example.yaml.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.yaml.dtos.jobs.Job;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class YamlWorkflow {
    private String name;
     Map<String, YamlEvent> eventsMap = new LinkedHashMap<>();
     Map<String, Job> jobsMap = new LinkedHashMap<>();

    public static YamlWorkflow $(String name) {
        YamlWorkflow yamlWorkflow = new YamlWorkflow();
        yamlWorkflow.name = name;
        return yamlWorkflow;
    }

    public YamlWorkflow on(YamlEvent... events){
        for (YamlEvent event : events) {
            eventsMap.put(event.name(), event);
        }
        return this;
    }
    public YamlWorkflow jobs(Job... jobs){
        for (Job job : jobs) {
            jobsMap.put(job.name(), job);
        }
        return this;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("on")
//    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public Map<String, YamlEvent> getEvents() {
        return eventsMap;
    }

     public Map<String, Job> getJobs() {
        return jobsMap;
    }
}
