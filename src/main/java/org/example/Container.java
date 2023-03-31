package org.example;

import org.example.collections.Nodes;
import org.example.collections.Ports;
import org.example.collections.Volumes;
import org.example.visitor.Visitor;
import org.example.wrappers.DashSingleElement;
import org.example.wrappers.NameValuePair;

public class Container extends Nodes {
	
	protected Container() {
		super("container");
	}
	
	public static Container $() {
		return new Container();
	}
	
	public Container image(String img) {
		NameValuePair image = new NameValuePair("image", img);
		this.add(image);
		return this;
	}
	
	public Container port(String... ports) {
		Ports aPorts = new Ports();
		for (String port : ports) {
			aPorts.add(new DashSingleElement(port));
		}
		this.add(aPorts);
		return this;
	}
	
	public Container volume(String name, String value) {
		Volumes volumes = findTag(Volumes.class);
		if (volumes == null) {
			volumes = new Volumes();
			add(volumes);
		}
		Volume volume = new Volume();
		volume.name = name;
		volume.value = value;
		volumes.add(volume);
		return this;
	}
	
	public Container env(String name, String value) {
		return getEnv(this, name, value);
	}
	
	public Container options(String... optionsArray) {
		String options = String.join(" ", optionsArray);
		add(new NameValuePair("options", options));
		return this;
	}
	
	@Override
	public <A> void accept(Visitor<A> visitor, A arg) {
		visitor.visit(this, arg);
	}
}
