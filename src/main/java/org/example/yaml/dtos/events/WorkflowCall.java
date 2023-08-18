package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.support.Support;

public class WorkflowCall extends Support implements YamlEvent {

    @Override
    public String name() {
        return "workflow_call";
    }
//    public static WorkflowCall $() {
//        return new WorkflowCall();
//    }
//    public WorkflowCall inputs(Input... inputs) {
//        return addInputs(this, inputs);
//    }
//    public WorkflowCall secrets(Secret... secrets) {
//        return addSecrets(this, secrets);
//    }
//    public WorkflowCall outputs(Output... inputs) {
//        return addOutputs(this, inputs);
//    }


}
