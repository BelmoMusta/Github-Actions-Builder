package org.example.wrappers.leaves;

public class StringElement extends InOutElement<String> {


    public StringElement(String name, String value) {
        super(name, value);
    }

    public boolean withDoubleQuotes() {
        return true;
    }

}
