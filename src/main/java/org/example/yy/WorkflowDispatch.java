package org.example.yy;

import org.example.visitor.Visitor;
import org.example.wrappers.leaves.Input;
import org.example.yy.support.InputSupport;

public class WorkflowDispatch extends WorkflowEvent implements InputSupport {

    protected WorkflowDispatch() {
        super("workflow_dispatch");
    }
    public static WorkflowDispatch $() {
        return new WorkflowDispatch();
    }
    public WorkflowDispatch inputs(Input... inputs) {
        return addInputs(this, inputs);

    }
    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

}
