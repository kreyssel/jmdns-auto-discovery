package org.kreyssel.jmdns;

import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;

public class Master {

	public static void main(final String[] args) throws Exception {

		System.out.println("start master");

		InetAddress intf = InetAddress.getLocalHost();

		JmDNS jmdns = JmDNS.create(intf, Constants.MDNS_NAME);

		System.out.println("register listener");

		jmdns.addServiceListener(Constants.TYPE_OCR, new ServiceAdapter() {
			@Override
			public void serviceResolved(final ServiceEvent event) {
			}
		});

		System.out.println("running");

		while (true) {

			ServiceInfo[] servcies = jmdns.list(Constants.TYPE_OCR);

			System.out.println("listing services: " + servcies.length);

			for (ServiceInfo serviceInfo : servcies) {
				System.out.println(serviceInfo);
			}

			System.out.println();

			Thread.sleep(5000);
		}
	}
}
