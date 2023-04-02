package org.example.wrappers;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class Input extends InOut {
	public static Input $() {
		return new Input();
	}
	
	public Input name(String name) {
		this.name = new SingleElement(name);
		return this;
	}
	
	public Input description(String description) {
		this.description = new InOutElement<>("description", description);
		inputElements.add(this.description);
		return this;
	}
	
	public Input required() {
		this.required = new InOutElement<>("required", true);
		inputElements.add(this.required);
		return this;
	}
	
	
	public Input type(Type type) {
		this.type = new InOutElement<>("type", type);
		inputElements.add(this.type);
		return this;
	}
	
	public Input default_(String default_) {
		this.default_ = new InOutElement<>("default", default_);
		inputElements.add(this.default_);
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
	}@Override
	public void accept(VoidVisitor visitor) {
		visitor.visit(this);
	}
}
