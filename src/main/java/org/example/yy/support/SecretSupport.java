package org.example.yy.support;

import org.example.collections.Secrets;
import org.example.wrappers.Secret;
import org.example.yy.WorkflowEvent;

public interface SecretSupport extends InOutSupport {
	
	default <E extends WorkflowEvent> E addSecrets(E event, Secret... secrets) {
		return addInouts(event, Secrets.class, Secrets::new, secrets);
	}
	
	
}
