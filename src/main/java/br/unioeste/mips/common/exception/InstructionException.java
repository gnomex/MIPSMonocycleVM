package br.unioeste.mips.common.exception;

import org.apache.log4j.Logger;

public class InstructionException	extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InstructionException(String message, Logger logger)	{
		super(message);
		
		logger.error("Error: " + message);	//Logger the error	
		
	}
	
}
