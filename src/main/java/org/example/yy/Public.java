package org.example.yy;

import org.example.visitor.Visitor;

public class Public extends WorkflowEvent {
    public Public() {
        super("public");
    }

    public static Public $() {
        return new Public();
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
