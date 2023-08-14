package org.example.yy;

import org.example.collections.Workflows;
import org.example.visitor.Visitor;
import org.example.yy.support.BranchesIgnoreSupport;
import org.example.yy.support.BranchesSupport;
import org.example.yy.support.ElementsSupport;
import org.example.yy.support.TypesSupport;

public class WorkflowRun extends WorkflowEvent implements BranchesSupport,
        BranchesIgnoreSupport,
        TypesSupport,
        ElementsSupport {
    public WorkflowRun() {
        super("workflow_run");
    }

    public static WorkflowRun $() {
        return new WorkflowRun();
    }


    public WorkflowRun types(Type... types) {
        return addTypes(this, types);
    }

    public WorkflowRun workflows(String... workflows) {
        return addElements(this, Workflows::new, Workflows.class, workflows);
    }

    public WorkflowRun branches(String... branches) {
        return addBranches(this, branches);
    }

    public WorkflowRun branchesIgnore(String... branches) {
        return addBranchesIgnore(this, branches);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public enum Type implements TypeI {
        COMPLETED,
        IN_PROGRESS,
        REQUESTED;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

}
