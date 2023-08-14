package org.example.wrappers.leaves;

import org.example.visitor.Visitor;

public class Credentials extends InOut {
    public Credentials() {
        this.name = new SingleElement("credentials");
    }

    public static Credentials $() {
        return new Credentials();
    }

    public Credentials username(String username) {
        inputElements.add(new StringElement("username", username));
        return this;
    }

    public Credentials password(String pass) {
        inputElements.add(new StringElement("password", pass));
        return this;
    }

    @Override
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
