package org.nordea.vdc.ninja.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
public class Service {

	    @Value("${spring.application.name}")
	    private String name;
	    @Value("${server.address}")
	    private String host;
	    @Value("${server.port}")
	    private String port;
	    @Value("${app.version}")
	    private String version;
	    private Set<Client> clients;
	    
	    public Service() {}
		
		public Service(String name, String version, String host, String port, Set<Client> clients) {
			super();
			this.name=name;
			this.version=version;
			this.host=host;
			this.port=port;
		    this.clients=clients;
		}

		public String getName() {
			return name;
		}

		public String getHost() {		
				try {
					if("".equals(host) || null== host ){
						host = InetAddress.getLocalHost().getHostAddress();
					}
				} catch (UnknownHostException e) {	
					throw new ServiceException(e);
				}

			return host;
		}

		public String getPort() {
			return port;
		}
			
		public String getVersion() {
			return version;
		}

		public Set<Client> getClients() {
			if(null==clients) {
				clients = new HashSet<Client>();
			}
			return clients;
		}
		
		public void addClients(Client client) {
			getClients().add(client);
		}

		@Override
		public String toString() {
			return "Service [name=" + name + ", host=" + host
					+ ", port=" + port + ", version=" + version + ", clients="
					+ clients + "]";
		}

		
	   
}

