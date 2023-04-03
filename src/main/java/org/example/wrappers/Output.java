package org.example.wrappers;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

public class Output extends InOut {
	
	public static Output $() {
		return new Output();
	}
	
	public Output name(String name) {
		this.name = new SingleElement(name);
		return this;
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
	
	@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
