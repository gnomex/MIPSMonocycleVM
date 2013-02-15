package br.unioeste.mips.components.circuit;

import static br.unioeste.mips.util.Util.BITMASK;

public class NOT{

	/**
	 * Only 1 bit data way
	 * */
	public Integer doNot(Integer rawPort) {
		/*
		 * Invert bit of lowest order
		 * 
		 * */
		Integer result	=	(~rawPort);
		result	=	(result & BITMASK);
		
		return result;
	}

}
