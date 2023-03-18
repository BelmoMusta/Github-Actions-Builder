package org.example;

import java.util.ArrayList;
import java.util.List;

public class Container extends Indentable {
	String image;
	private List<Environment> env = new ArrayList<>();
	List<String> ports = new ArrayList<>();
	List<Volume> volumes = new ArrayList<>();
	String options;
	
	public static Container image(String image) {
		Container container = new Container();
		container.image = image;
		return container;
	}
	
	public Container port(String port) {
		this.ports.add(port);
		return this;
	}
	
	public Container volume(String name, String value) {
		Volume volume = new Volume();
		volume.name = name;
		volume.value = value;
		volumes.add(volume);
		return this;
	}
	
	public Container options(String options){
		this.options = options;
		return this;
	}
}
