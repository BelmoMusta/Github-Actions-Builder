package org.example.yy;

import org.example.collections.Nodes;
import org.example.collections.Ports;
import org.example.visitor.Visitor;
import org.example.visitor.VoidVisitor;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.SingleElement;

public class Service extends Nodes {
	protected Service(String name) {
		super(name);
	}
	
	public static Service $() {
		return new Service(null);
	}
	
	public Service name(String name) {
		this.name = new SingleElement(name);
		return this;
	}
	
	
	public Service port(String port) {
		Ports ports = new Ports();
		ports.add(new DashSingleElement(port));
		add(ports);
		return this;
	}
	
	public Service image(String image) {
		Image existingImage = findTag(Image.class);
		if (existingImage == null) {
			add(new Image(image));
		}
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}@Override
	public void accept(VoidVisitor<?>visitor) {
		visitor.visit(this);
	}
}
