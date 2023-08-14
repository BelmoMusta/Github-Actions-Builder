package org.example.wrappers.leaves;

import org.example.visitor.Visitor;
import org.example.wrappers.Tag;

public class NameValuePair extends Tag {
    private final String name;
    private final String value;

    public NameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
