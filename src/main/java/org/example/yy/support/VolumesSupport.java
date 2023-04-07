package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.collections.Volumes;
import org.example.yy.Volume;

public interface VolumesSupport {
	default <E extends Nodes> E addVolume(E node, String name, String value) {
		Volumes volumes = node.findTag(Volumes.class);
		if (volumes == null) {
			volumes = new Volumes();
			node.add(volumes);
		}
		Volume volume = new Volume();
		volume.name = name;
		volume.value = value;
		volumes.add(volume);
		return node;
	}
}
