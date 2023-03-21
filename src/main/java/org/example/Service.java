package org.example;

import org.example.collections.SecondLevel;
import org.example.wrappers.SingleElement;

public class Service extends SecondLevel {
	protected Service(String name) {
		super(name);
	}
	
	public static Service image(String image) {
		Service service = new Service(image);
		//service.add(element);
		//service.image = image; TODO
		return service;
	}
	
	@Override
	protected boolean acceptEmptyCollection() {
		return true;
	}
	
	public Service port(String port) {
		//this.ports.add(port);
		return this;
	}
}
