package org.example.collections;

import org.example.visitor.Visitor;

public class Inputs extends Nodes {
    public Inputs() {
        super("inputs");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
