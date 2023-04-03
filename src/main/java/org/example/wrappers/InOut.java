package org.example.wrappers;

import org.example.Appender;
import org.example.collections.Options;
import org.example.visitor.VoidVisitor;

import java.util.ArrayList;
import java.util.List;

public class InOut extends Tag {
	public SingleElement name;
	protected InOutElement<String> description;
	protected InOutElement<Boolean> required;
	
	protected InOutElement<Type> type;
	protected Options options = new Options();
	protected InOutElement<String> default_;
	public List<Node> inputElements = new ArrayList<>();
	
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
	
	@Override
	public void accept(VoidVisitor<?>visitor) {
	
	}
	
	public enum Type {
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
