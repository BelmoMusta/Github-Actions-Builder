package org.example.yy;

import org.example.visitor.Visitor;

public class Status extends WorkflowEvent {
    public Status() {
        super("status");
    }

    public static Status $() {
        return new Status();
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
