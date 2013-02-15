package br.unioeste.mips.common.mux;

import static br.unioeste.mips.util.Util.ZERO;

public class Mux {

	/*
	 * Logical ports
	 * */
	private final Integer portA	=	0;
	private final Integer portB	=	1;
	
	private Integer select	=	ZERO;	//Default

	private Integer currentDataPortA;
	private Integer currentDataPortB;

	/**
	 * Get open port
	 * @Param: Select	[0|1]
	 * */
	public Integer logicalMUX()		{

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
