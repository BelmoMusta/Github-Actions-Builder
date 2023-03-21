package org.example.wrappers;

public class Output extends InOut {
	
	public static Output name(String name) {
		Output input = new Output();
		input.name = new SingleElement(name);
		return input;
	}
	
	public Output description(String description) {
		this.description = new InOutElement<>("description", description);
		inputElements.add(this.description);
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
}
