package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class DashedNameValuePair extends NameValuePair {

    public DashedNameValuePair(String name, String value) {
        super(name, value);
    }


    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }


}
