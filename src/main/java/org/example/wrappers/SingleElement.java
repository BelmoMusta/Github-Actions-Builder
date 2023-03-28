package org.example.wrappers;

import org.example.Appender;
import org.example.visitor.Visitor;

public class SingleElement extends NameValuePair {
	
	public SingleElement(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		Appender appender = new Appender();
		
		if (addDashAtFirst()) {
			appender.append("- ");
		}
		if (wrapValueWithQuotes()) {
			appender.appendSingleQuote(value);
		} else {
			appender.append(value);
		}
		if (addColumn()) {
			appender.append(":");
		}
		return appender.toString();
	}
	
	protected boolean addColumn() {
		return true;
	}
	
	//@Override
	public <A> void axccept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
