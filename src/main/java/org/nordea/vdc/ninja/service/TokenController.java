package org.nordea.vdc.ninja.service;


import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TokenController  {
	
	private static final Logger log = LoggerFactory.getLogger(TokenController.class);
    @Autowired
    private Service service;

    @RequestMapping("/tokenservice/info")
    public Service getServiceInfo() {
    	log.info("Service information found " + service.toString());
        return service;
    } 
    
    @RequestMapping(method=RequestMethod.POST, value ="/tokenservice/register")
    public String registerServiceClient(@RequestBody Client client) {
    	String token=getToken(); 
    	client.setToken(token);
        service.addClients(client);
        log.info("Client " + client.getName() + " is registered with  " + token);
		return token;  	
    }
   
   
   @RequestMapping("/tokenservice/token")
   public String getToken() {
    	String uuid = UUID.randomUUID().toString();
    	return uuid;
    }
   
 }
    
   