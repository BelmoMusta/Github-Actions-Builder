package org.example.yaml.dtos.events;

import org.example.yaml.dtos.YamlEvent;
import org.example.yaml.dtos.inputs.Input;
import org.example.yaml.dtos.inputs.Output;

import java.util.LinkedHashMap;
import java.util.Map;

public class WorkflowDispatch  implements YamlEvent { // needs inputs
    Map<String, Input> inputsMap = new LinkedHashMap<>();
    Map<String, Output> outputs = new LinkedHashMap<>();

    public static WorkflowDispatch $() {
        return new WorkflowDispatch();
    }

    public WorkflowDispatch inputs(Input... inputs) {
        for (Input input : inputs) {
            inputsMap.put(input.name(), input);
        }
        return this;
    }
    public WorkflowDispatch outputs(Output... inputs) {
        for (Output input : inputs) {
            outputs.put(input.name(), input);
        }
        return this;
    }
    public Map<String, Input> getInputs() {
        return inputsMap;
    }
    public Map<String, Output> getOutputs() {
        return outputs;
    }
    @Override
    public String name() {
        return "workflow_dispatch";
    }
}
