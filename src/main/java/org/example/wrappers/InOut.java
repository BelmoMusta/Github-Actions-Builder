package org.example.wrappers;

import org.example.Appender;
import org.example.collections.Options;

import java.util.ArrayList;
import java.util.List;

public class InOut extends Tag {
	protected SingleElement name;
	protected InOutElement<String> description;
	protected InOutElement<Boolean> required;
	
	protected InOutElement<Type> type;
	protected Options options = new Options();
	protected InOutElement<String> default_;
	protected List<Indentable> inputElements = new ArrayList<>();
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (Indentable inputElement : inputElements) {
			inputElement.setIndentLevel(indentLvel + 1);
		}
		options.setIndentLevel(indentLvel + 1);
	}
	
	public static InOut name(String name) {
		InOut input = new InOut();
		input.name = new SingleElement(name);
		return input;
	}
	
	public InOut description(String description) {
		this.description = new InOutElement<>("description", description);
		inputElements.add(this.description);
		return this;
	}
	
	public InOut required() {
		this.required = new InOutElement<>("required", true);
		inputElements.add(this.required);
		return this;
	}
	
	public InOut default_(String default_) {
		this.default_ = new InOutElement<>("default", default_);
		inputElements.add(this.default_);
		return this;
	}
	
	public InOut options(String... options) {
		this.options.addAll(options);
		inputElements.add(this.options);
		return this;
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.append(name);
		if (!inputElements.isEmpty()) {
			appender.newLine();
			appender.appendCollection(inputElements);
		}
		return appender.toString();
	}
	
	public enum Type{
		choice,
		environment,
		boolean_,
		string_;
		
		@Override
		public java.lang.String toString() {
			return super.toString().replace("_", "");
		}
	}
}
