package org.example.collections;

import org.example.Appender;
import org.example.wrappers.Indentable;
import org.example.wrappers.Input;

import java.util.ArrayList;
import java.util.List;

public class Inputs extends Indentable {
	private final List<Input> inputs = new ArrayList<>();
	
	public void add(Input input) {
		inputs.add(input);
	}
	
	@Override
	public void setIndentLevel(int indentLvel) {
		super.setIndentLevel(indentLvel);
		for (Input input : inputs) {
			input.setIndentLevel(getIndentLevel() + 1);
		}
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		appender.append(inputs);
		return appender.toString();
	}
	
	@Override
	public boolean isEmpty() {
		return inputs.isEmpty();
	}
}
