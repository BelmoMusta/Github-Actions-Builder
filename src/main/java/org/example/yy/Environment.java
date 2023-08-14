package org.example.yy;

import org.example.visitor.Visitor;
import org.example.wrappers.leaves.NameValuePair;

public class Environment extends NameValuePair {

    public Environment(String name, String value) {
        super(name, value);
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
