package org.example.collections;

import org.example.visitor.Visitor;

public class Branches extends Nodes {
    public Branches() {
        super("branches");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
