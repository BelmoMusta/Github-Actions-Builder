package org.example.yy;

import org.example.collections.Nodes;
import org.example.collections.Ports;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.Credentials;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.wrappers.leaves.NameValuePair;
import org.example.yy.support.EnvSupport;
import org.example.yy.support.VolumesSupport;

public class Container extends Nodes implements EnvSupport, VolumesSupport {
	
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
	
	public Container port(int... ports) {
		Ports aPorts = new Ports();
		for (int port : ports) {
			aPorts.add(new DashSingleElement(String.valueOf(port)));
		}
		this.add(aPorts);
		return this;
	}
	
	public Container volume(String name, String value) {
		return addVolume(this, name, value);
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
	public <R> void accept(Visitor<R> visitor) {
		visitor.visit(this);
	}
	
	public Container credentials(Credentials credentials) {
		add(credentials);
		return this;
	}
}
