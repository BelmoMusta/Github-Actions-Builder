package org.example.collections;

import org.example.visitor.Visitor;

public class Types extends Nodes {
    public Types() {
        super("types");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
