package br.unioeste.mips.common.mux;

import static br.unioeste.mips.util.Util.ONE;
import static br.unioeste.mips.util.Util.ZERO;
import br.unioeste.mips.components.circuit.NOT;

	/**
	 * 
	 * Logical ports 1 and 2
	 * 
	 * */

public class Mux {

	/*
	 * Logical ports
	 * */
	private final Integer portA	=	0;
	private final Integer portB	=	1;
	
	private Integer select	=	ONE;	//Default

	private Integer currentDataPortA;
	private Integer currentDataPortB;

	/**
	 * Get open port
	 * @Param: Select	port [1|2]
	 * */
	public Integer logicalMUX()		{

		Integer result	=	new Integer(ZERO);
		/*
		 * (portA and Select) or (portB and not select)
		 * 
		 * The not are applied only in the first bit
		 * 
		 * */
		br.unioeste.mips.components.circuit.NOT notCircuit	=	new NOT();
		result	=	((portA & select) | (portB & ( notCircuit.doNot(select))));

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
