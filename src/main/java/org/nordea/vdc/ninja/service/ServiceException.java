package org.nordea.vdc.ninja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PARTIAL_CONTENT)
public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(ServiceException.class);
	
	public ServiceException(Exception e){
		log.warn("Value not found", e.getMessage());
	}
}
