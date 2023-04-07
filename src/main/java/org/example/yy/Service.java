package org.example.yy;

import org.example.collections.Nodes;
import org.example.collections.Ports;
import org.example.visitor.Visitor;
import org.example.wrappers.Credentials;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.SingleElement;
import org.example.yy.support.VolumesSupport;

public class Service extends Nodes implements VolumesSupport {
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
	
	public Service env(String name, String value) {
		return getEnv(this, name, value);
	}
	
	public Service options(String... optionsArray) {
		String options = String.join(" ", optionsArray);
		add(new NameValuePair("options", options));
		return this;
	}
	public Service volume(String name, String value) {
		return addVolume(this, name, value);
	}
	
	public Service credentials(Credentials credentials) {
		add(credentials);
		return this;
	}
	
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
visitor.visit(this, arg);
	}
}
