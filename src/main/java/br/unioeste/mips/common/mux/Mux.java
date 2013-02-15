package br.unioeste.mips.common.mux;

import static br.unioeste.mips.util.Util.ZERO;

public class Mux {

	private Integer select;

	public Integer logicalMUX(Integer portA, Integer portB)	{

		Integer result	=	new Integer(ZERO);
		/*
		 * (portA and Select) or (portB and not select)
		 * 
		 * The not are applied only in the first bit
		 * 
		 * */
		result	=	((portA & select) | (portB & ( br.unioeste.mips.components.circuit.NOT.doNot(select))));
		
		return result;

	}

	public void setSelect(Integer select) {
		this.select = select;
	}
	
}
