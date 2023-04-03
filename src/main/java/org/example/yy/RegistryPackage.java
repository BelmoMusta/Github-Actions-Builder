package org.example.yy;

import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.yy.support.TypesSupport;

public class RegistryPackage extends WorkflowEvent implements  TypesSupport {
	
	protected RegistryPackage() {
		super("registry_package");
	}
	
	public RegistryPackage types(Type ... types){
		return addTypes(this, types);
	}
	
	public static RegistryPackage $() {
		return new RegistryPackage();
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
	
	@Override
	public void accept(VoidVisitor<?> visitor) {
		visitor.visit(this);
	}
	public enum Type implements TypeI {
		PUBLISHED,
		UPDATED
		
		;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
}
