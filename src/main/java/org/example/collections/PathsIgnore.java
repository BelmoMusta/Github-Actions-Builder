package org.example.collections;

import org.example.visitor.Visitor;

public class PathsIgnore extends Nodes {
    public PathsIgnore() {
        super("paths-ignore");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
