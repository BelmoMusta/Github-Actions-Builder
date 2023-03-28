package org.example.wrappers;

import org.example.visitor.Visitor;

public class Output extends InOut {
	
	public static Output name(String name) {
		Output input = new Output();
		input.name = new SingleElement(name);
		return input;
	}
	
	public Output required() {
		this.required = new InOutElement<>("required", true);
		inputElements.add(this.required);
		return this;
	}
	
	
	public Output type(Type type) {
		this.type = new InOutElement<>("type", type);
		inputElements.add(this.type);
		return this;
	}
	
	public Output default_(String default_) {
		this.default_ = new InOutElement<>("default", default_);
		inputElements.add(this.default_);
		return this;
	}
	
	public Output options(String... options) {
		this.options.addAll(options);
		inputElements.add(this.options);
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
