package org.example.wrappers;

public class Input extends InOut {
	public static Input name(String name) {
		Input input = new Input();
		input.name = new SingleElement(name);
		return input;
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
}
