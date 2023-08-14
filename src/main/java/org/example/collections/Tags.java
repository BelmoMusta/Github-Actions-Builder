package org.example.collections;

import org.example.visitor.Visitor;

public class Tags extends Nodes {
    public Tags() {
        super("tags");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
