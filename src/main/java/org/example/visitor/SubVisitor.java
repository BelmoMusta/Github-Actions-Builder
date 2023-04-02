package org.example.visitor;

import org.example.collections.Branches;
import org.example.wrappers.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubVisitor<A> extends AbstractVisitor<A> {
	List<Visitor<A>> visitors = new ArrayList<>();
	
	@Override
	public void support(Visitor<A> anotherVisitor) {
		visitors.add(anotherVisitor);
	}
	
	protected void visitChildren(Collection<? extends Node> children, A arg, boolean addNewLine) {
		for (Node child : children) {
			for (Visitor<A> visitor : visitors) {
				child.accept(visitor, arg);
			}
		}
	}
	
	@Override
	public void visit(Branches branches, A arg) {
		for (Visitor<A> visitor : visitors) {
			visitor.visit(branches, arg);
		}
	}
	
	
}
