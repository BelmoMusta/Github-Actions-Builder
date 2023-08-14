package org.example.yy;

import org.example.visitor.Visitor;

public class PageBuild extends WorkflowEvent {
    public PageBuild() {
        super("page_build");
    }

    public static PageBuild $() {
        return new PageBuild();
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
