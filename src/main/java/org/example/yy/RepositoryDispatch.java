package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.yy.support.CustomTypesSupport;
import org.example.yy.support.TypesSupport;

public class RepositoryDispatch extends WorkflowEvent implements CustomTypesSupport {
	
	protected RepositoryDispatch() {
		super("repository_dispatch");
	}
	
	public RepositoryDispatch types(String ... types){
		return addTypes(this, types);
	}
	
	public static RepositoryDispatch $() {
		return new RepositoryDispatch();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor<?> visitor) {
		visitor.visit(this);
	}
	
}
