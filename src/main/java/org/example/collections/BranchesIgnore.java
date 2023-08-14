package org.example.collections;

import org.example.visitor.Visitor;

public class BranchesIgnore extends Nodes {
    public BranchesIgnore() {
        super("branches-ignore");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
