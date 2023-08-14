package org.example.collections;

import org.example.visitor.Visitor;

public class TagsIgnore extends Nodes {
    public TagsIgnore() {
        super("tags-ignore");
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
