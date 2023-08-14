package org.example.collections;

import org.example.visitor.Visitor;

public class Volumes extends Nodes {
    public Volumes() {
        super("volumes");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
