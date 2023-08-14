package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class Output extends InOut {

    public static Output $() {
        return new Output();
    }

    public Output name(String name) {
        this.name = new SingleElement(name);
        return this;
    }

    public Output required() {
        inputElements.add(new InOutElement<>("required", true));
        return this;
    }


    public Output type(Type type) {
        inputElements.add(new InOutElement<>("type", type));
        return this;
    }

    public Output value(String value) {
        inputElements.add(new InOutElement<>("value", value));
        return this;
    }

    public Output description(String desc) {
        inputElements.add(new StringElement("description", desc));
        return this;
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }

}
