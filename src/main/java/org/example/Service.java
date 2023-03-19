package org.example;

public class Service extends Container {
	public static Service image(String image) {
		Service service = new Service();
		//service.image = image; TODO
		return service;
	}
	
	public Service port(String port) {
		this.ports.add(port);
		return this;
	}
}
