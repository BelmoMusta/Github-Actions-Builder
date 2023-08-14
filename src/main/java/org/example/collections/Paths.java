package org.example.collections;

import org.example.visitor.Visitor;

public class Paths extends Nodes {
    public Paths() {
        super("paths");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
