package org.example.yy;

import org.example.visitor.Visitor;
import org.example.wrappers.leaves.Input;
import org.example.wrappers.leaves.Output;
import org.example.wrappers.leaves.Secret;
import org.example.yy.support.InputSupport;
import org.example.yy.support.OutputSupport;
import org.example.yy.support.SecretSupport;

public class WorkflowCall extends WorkflowEvent implements InputSupport, OutputSupport, SecretSupport {

    protected WorkflowCall() {
        super("workflow_call");
    }
    public static WorkflowCall $() {
        return new WorkflowCall();
    }
    public WorkflowCall inputs(Input... inputs) {
        return addInputs(this, inputs);
    }
    public WorkflowCall secrets(Secret... secrets) {
        return addSecrets(this, secrets);
    }
    public WorkflowCall outputs(Output... inputs) {
        return addOutputs(this, inputs);
    }
    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

}
