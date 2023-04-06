package org.example.yy;

import org.example.visitor.Visitor;

public class PageBuild extends WorkflowEvent {
	public PageBuild() {
		super("page_build");
	}
	
	public static PageBuild $() {
		return new PageBuild();
	}
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
