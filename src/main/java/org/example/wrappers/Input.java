package org.example.wrappers;

import org.example.visitor.Visitor;

public class Input extends InOut {
	public static Input $() {
		return new Input();
	}
	
	public Input name(String name) {
		this.name = new SingleElement(name);
		return this;
	}
	
	public Input description(String description) {
		inputElements.add(new InOutElement<>("description", description));
		return this;
	}
	
	public Input required() {
		return required(true);
	}
	
	public Input required(boolean value) {
		inputElements.add(new InOutElement<>("required", value));
		return this;
	}
	
	
	public Input type(Type type) {
		inputElements.add(new InOutElement<>("type", type));
		return this;
	}
	
	public Input default_(String default_) {
		inputElements.add(new InOutElement<>("default", default_));
		return this;
	}
	
	public Input options(String... options) {
		this.options.addAll(options);
		inputElements.add(this.options);
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
