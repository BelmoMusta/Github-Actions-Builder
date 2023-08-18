package org.example.yaml.dtos.events;

import org.example.collections.Workflows;
import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;
import org.example.yaml.dtos.support.WithBranches;
import org.example.yaml.dtos.support.WithIgnoreBranches;
import org.example.yaml.dtos.support.WithTypes;

import java.util.Arrays;

public class WorkflowRun extends Support implements YamlEvent,
        WithBranches,
        WithIgnoreBranches,
        WithTypes<WorkflowRun.Type> {


    public static WorkflowRun $() {
        return new WorkflowRun();
    }


    public WorkflowRun types(Type... types) {
        putEnum(TYPES, Arrays.asList(types));
        return this;
    }

    public WorkflowRun workflows(String... workflows) {
        return this;
       // return addElements(this, Workflows::new, Workflows.class, workflows);
    }

    public WorkflowRun branches(String... branches) {
        put(BRANCHES, Arrays.asList(branches));
        return this;
    }

    @Override
    public String name() {
        return "workflow_run";
    }
    @Override
    public WorkflowRun ignoreBranches(String... branches) {
        putIgnore(BRANCHES, Arrays.asList(branches));
        return this;
    }

    public enum Type implements TypeI {
        COMPLETED,
        IN_PROGRESS,
        REQUESTED;

    }

}
