package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;

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
	}@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
