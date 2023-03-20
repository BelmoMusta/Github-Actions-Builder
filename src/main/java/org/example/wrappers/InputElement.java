package org.example.wrappers;

public class InputElement<T> extends NameValuePair {
	public InputElement(String name, T value) {
		this.name = name;
		String boundary = "";
		if(value instanceof String){
			boundary = "'";
		}
		this.value = boundary + value.toString() + boundary;
	}
	
	@Override
	public boolean addDashAtFirst() {
		return false;
	}
	
}
