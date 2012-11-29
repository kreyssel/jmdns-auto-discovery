package org.kreyssel.jmdns;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

public abstract class ServiceAdapter implements ServiceListener {

	@Override
	public void serviceAdded(final ServiceEvent event) {
	}

	@Override
	public void serviceRemoved(final ServiceEvent event) {
	}

	@Override
	public void serviceResolved(final ServiceEvent event) {
	}

}
