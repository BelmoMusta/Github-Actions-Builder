package org.example;

import org.example.collections.AbstractCollection;
import org.example.collections.Environments;
import org.example.collections.Options;
import org.example.collections.Ports;
import org.example.collections.Volumes;
import org.example.wrappers.NameValuePair;
import org.example.wrappers.Port;
import org.example.wrappers.SingleElement;

public class Container extends AbstractCollection {
	
	protected Container() {
		super("container");
	}
	
	public static Container image(String image) {
		Container container = new Container();
		NameValuePair image_ = new NameValuePair("image", image);
		container.add(image_);
		return container;
	}
	
	public Container port(String... ports) {
		Ports aPorts = new Ports();
		for (String port : ports) {
			aPorts.add(new Port(port));
		}
		this.add(aPorts);
		return this;
	}
	
	public Container volume(String name, String value) {
		Volumes volumes = findTag(Volumes.class);
		if(volumes == null){
			volumes = new Volumes();
			add(volumes);
		}
		Volume volume = new Volume();
		volume.name = name;
		volume.value = value;
		volumes.add(volume);
		return this;
	}
	
	public Container env(String name, String value ) {
		Environments environments = findTag(Environments.class);
		if(environments == null){
			environments = new Environments();
			add(environments);
		}
		Environment environment = new Environment(name, value);
		environments.add(environment);
		return this;
	}
	
	public Container options(String... optionsArray) {
		String options = String.join(" ", optionsArray);
		add(new NameValuePair("options", options));
		return this;
	}
}
