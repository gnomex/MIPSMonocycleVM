package br.unioeste.mips.common.mux;

import static br.unioeste.mips.util.Util.ZERO;
import br.unioeste.mips.components.circuit.NOT;

	/**
	 * 
	 * Logical ports 1 and 0
	 * 
	 * */

public class Mux {

	/*
	 * Logical ports
	 * */
	private final Integer portA	=	0;
	private final Integer portB	=	1;
	private final Integer portC	=	2;
	private final Integer portD	=	3;
	
	private Integer select	=	ZERO;	//Default

	private Integer currentDataPortA;
	private Integer currentDataPortB;

	/**
	 * Get open port
	 * @Param: Select	port [0|1]
	 * */
	public Integer logicalMUX()		{

		Integer result	=	new Integer(ZERO);
		/*
		 * (portA and not Select) or (portB and select)
		 * 
		 * The not are applied only in the first bit
		 * 
		 * */
		/**
		 * It's only 2 ports
		 * Nedds change to 4 ports
		 * */
		NOT notCircuit	=	new NOT();
		result	=	((portA & (notCircuit.doNot(select))) | (portB & select));

		return result;

	}

	/**
	 * Returns data of opened port
	 * */
	public Integer getData()	{
		
		if(logicalMUX().equals(portA))	{
			return currentDataPortA;
		}else	{
			return currentDataPortB;
		}
	}

	
	public void setSelect(Integer select) {
		this.select = select;
	}

	public void setCurrentDataPortA(Integer currentDataPortA) {
		this.currentDataPortA = currentDataPortA;
	}

	public void setCurrentDataPortB(Integer currentDataPortB) {
		this.currentDataPortB = currentDataPortB;
	}



}
