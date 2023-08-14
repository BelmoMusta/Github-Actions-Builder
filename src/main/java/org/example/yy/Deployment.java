package org.example.yy;

import org.example.visitor.Visitor;

public class Deployment extends WorkflowEvent {
    public Deployment() {
        super("deployment");
    }

    public static Deployment $() {
        return new Deployment();
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
