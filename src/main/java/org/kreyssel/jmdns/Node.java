package org.kreyssel.jmdns;

import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import org.apache.catalina.startup.Tomcat;

public class Node {
	public static void main(final String[] args) throws Exception {

		Tomcat tomcat = new Tomcat();
		// tomcat.setPort((int) Math.round(Math.random() * 63000 + 2000));
		tomcat.start();

		System.out.println("start node");

		InetAddress intf = InetAddress.getLocalHost();
		JmDNS jmdns = JmDNS.create(intf, Constants.MDNS_NAME);

		System.out.println("register service");

		ServiceInfo serviceInfo = ServiceInfo.create(Constants.TYPE_OCR, "ocr", tomcat.getServer()
				.getPort(), "local ocr service");
		jmdns.registerService(serviceInfo);

		System.out.println("service registered");

		Thread.sleep(15000);

		System.out.println("close");
		jmdns.close();
	}
}
