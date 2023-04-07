package org.example.wrappers;

import org.example.visitor.Visitor;

public class Secret extends InOut {
	public static Secret $() {
		return new Secret();
	}
	
	public Secret name(String name) {
		this.name = new SingleElement(name);
		return this;
	}
	
	public Secret description(String description) {
		inputElements.add(new StringElement("description", description));
		return this;
	}
	
	public Secret required() {
		inputElements.add(new InOutElement<>("required", true));
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
