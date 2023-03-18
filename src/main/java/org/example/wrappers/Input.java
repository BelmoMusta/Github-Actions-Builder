package org.example.wrappers;

import org.example.Appender;
import org.example.collections.Options;

import java.util.ArrayList;
import java.util.List;

public class Input extends Indentable {
	public SingleElement name;
	public InputElement<String> description;
	public InputElement<Boolean> required;
	
	public InputElement<Type> type;
	public Options options = new Options();
	public InputElement<String> default_;
	List<Indentable> inputElements = new ArrayList<>();
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (Indentable inputElement : inputElements) {
			inputElement.setIndentLevel(indentLvel + 1);
		}
		options.setIndentLevel(indentLvel + 1);
	}
	
	public static Input name(String name) {
		Input input = new Input();
		input.name = new SingleElement(name);
		return input;
	}
	
	public Input description(String description) {
		this.description = new InputElement<>("description", description);
		inputElements.add(this.description);
		return this;
	}
	
	public Input required() {
		this.required = new InputElement<>("required", true);
		inputElements.add(this.required);
		return this;
	}
	
	
	public Input type(Type type) {
		this.type = new InputElement<>("type", type);
		inputElements.add(this.type);
		return this;
	}
	
	public Input default_(String default_) {
		this.default_ = new InputElement<>("default", default_);
		inputElements.add(this.default_);
		return this;
	}
	
	public Input options(String... options) {
		this.options.addAll(options);
		inputElements.add(this.options);
		return this;
	}
	
	@Override
	public String toString() {
		Appender appender = preAppend();
		appender.append(name);
		appender.append(inputElements);
		return appender.toString();
	}
}
