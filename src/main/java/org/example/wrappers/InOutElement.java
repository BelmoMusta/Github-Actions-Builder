package org.example.wrappers;

public class InOutElement<T> extends NameValuePair {
	T inputValue;
	public InOutElement(String name, T value) {
		this.name = name;
		this.inputValue = value;
		super.value = String.valueOf(value);
	}
	
	@Override
	public boolean wrapValueWithQuotes() {
		return inputValue instanceof String;
	}
	
	@Override
	public boolean addDashAtFirst() {
		return false;
	}
	
}
