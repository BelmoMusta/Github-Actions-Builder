package org.example.wrappers;

import org.example.visitor.Visitor;

public class Credentials extends InOut {
	public Credentials(){
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
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
