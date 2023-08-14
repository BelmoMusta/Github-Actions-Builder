package org.example.collections;

import org.example.visitor.Visitor;

public class Outputs extends Nodes {
    public Outputs() {
        super("outputs");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
