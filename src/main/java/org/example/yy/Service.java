package org.example.yy;

import org.example.collections.Nodes;
import org.example.collections.Ports;
import org.example.visitor.Visitor;
import org.example.wrappers.leaves.Credentials;
import org.example.wrappers.leaves.DashSingleElement;
import org.example.wrappers.leaves.NameValuePair;
import org.example.wrappers.leaves.SingleElement;
import org.example.yy.support.EnvSupport;
import org.example.yy.support.VolumesSupport;

public class Service extends Nodes implements EnvSupport, VolumesSupport {
    protected Service() {
        super(null);
    }

    public static Service $() {
        return new Service();
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
    public <R> void accept(Visitor<R> visitor) {
        visitor.visit(this);
    }
}
