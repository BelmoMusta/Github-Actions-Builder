package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;

public class WorkflowDispatch implements YamlEvent {
    public static WorkflowDispatch $(){
        return new WorkflowDispatch();
    }
    @Override
    public String name() {
        return "workflow_dispatch";
    }
}
