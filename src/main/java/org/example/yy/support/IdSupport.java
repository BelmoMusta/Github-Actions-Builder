package org.example.yy.support;

import org.example.collections.Nodes;
import org.example.wrappers.DashedId;
import org.example.wrappers.Id;
import org.example.wrappers.Node;

public interface IdSupport  {
	
	default <E extends Nodes> E addId(E node, String id) {
		final Node nodeId;
		if (node.children.isEmpty()) {
			nodeId = new DashedId(id);
		} else {
			nodeId = new Id(id);
		}
		node.add(nodeId);
		return node;
	}
	
	
	
}
