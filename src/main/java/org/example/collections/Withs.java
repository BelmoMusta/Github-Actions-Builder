package org.example.collections;

import org.example.visitor.Visitor;

public class Withs extends Nodes {
    public Withs() {
        super("with");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
