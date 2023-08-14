package org.example.collections;

import org.example.visitor.Visitor;

public class Workflows extends Nodes {
    public Workflows() {
        super("workflows");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

}
