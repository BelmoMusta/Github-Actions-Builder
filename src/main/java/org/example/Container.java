package org.example;

import org.example.collections.AbstractCollection;
import org.example.wrappers.NameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Container extends AbstractCollection {
	NameValuePair image;
	private List<Environment> env = new ArrayList<>();
	List<String> ports = new ArrayList<>();
	List<Volume> volumes = new ArrayList<>();
	String options;
	
	protected Container() {
		super("container");
	}
	
	public static Container image(String image) {
		Container container = new Container();
		NameValuePair image_ = new NameValuePair("image", image);
		container.add(image_);
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
