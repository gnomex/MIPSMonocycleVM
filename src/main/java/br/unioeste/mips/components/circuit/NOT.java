package br.unioeste.mips.components.circuit;

import static br.unioeste.mips.util.Util.BITMASK;

public class NOT{

	/**
	 * Only 1 bit data way
	 * */
	public static Integer doNot(Integer rawPort) {
		/*
		 * Invert bit of lowest order
		 * 
		 * */
		Integer result	=	rawPort & BITMASK;
		
		return result;
	}

}
