package org.example.wrappers;

import org.example.collections.Options;
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
	
	public Output default_(String default_) {
		inputElements.add( new InOutElement<>("default", default_));
		return this;
	}
	public Output description(String desc) {
		inputElements.add(new InOutElement<>("description", desc));
		return this;
	}
	
	public Output options(String... options) {
		Options opts = new Options();
		opts.addAll(options);
		inputElements.add(opts);
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	
}
