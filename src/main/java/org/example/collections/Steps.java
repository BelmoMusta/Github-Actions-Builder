package org.example.collections;

import org.example.visitor.Visitor;

public class Steps extends Nodes {
    public Steps() {
        super("steps");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
