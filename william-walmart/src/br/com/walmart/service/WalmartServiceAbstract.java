package br.com.walmart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author William.Galindo
 */
public abstract class WalmartServiceAbstract {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WalmartServiceAbstract.class);

	/**
	 * @return O logger 
	 */
	protected static Logger getLogger() {
		return LOGGER;
	}
	
}
