package org.example.yy;

import org.example.collections.Nodes;
import org.example.visitor.Visitor;
import org.example.wrappers.NameValuePair;

public class Run extends Nodes {
	public Run() {
		super("run");
	}
	
	public static Run $() {
		return new Run();
	}
	
	public Run shell(String shell) {
		add(new NameValuePair("shell", shell));
		return this;
	}
	
	public Run workingDirectory(String wd) {
		add(new NameValuePair("working-directory", wd));
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
