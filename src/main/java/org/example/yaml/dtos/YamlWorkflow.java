package org.example.yaml.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class YamlWorkflow {
    private String name;
     Map<String, YamlEvent> eventsMap = new LinkedHashMap<>();
    List<YamlJob> jobs = new ArrayList<>();

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


     public List<YamlJob> getJobs() {
        return jobs;
    }
    public void setJobs(List<YamlJob> jobs) {
        this.jobs = jobs;
    }
}
