package org.example.collections;

import org.example.visitor.Visitor;

public class Environments extends Nodes {
    public Environments() {
        super("env");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

}
