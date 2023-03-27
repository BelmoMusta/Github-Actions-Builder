package org.example;

import org.example.collections.Ports;
import org.example.collections.SubNode;
import org.example.wrappers.DashSingleElement;

public class Service extends SubNode {
	protected Service(String name) {
		super(name);
	}
	
	public static Service name(String name) {
		return new Service(name);
	}
	
	@Override
	protected boolean acceptEmptyCollection() {
		return true;
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
}
