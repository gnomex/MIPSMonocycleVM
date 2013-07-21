package br.unioeste.mips.common.mux;

import static br.unioeste.mips.util.Util.ZERO;
import br.unioeste.mips.common.exception.MUXSelectionOutOfBounds;

/**
 * 
 * Logical ports 1 and 0
 * 
 * */

public class Mux2LogicalGates {

	private Integer select	=	ZERO;	//Default

	private Integer currentDataPortA;
	private Integer currentDataPortB;

	/**
	 * Get open port
	 * @Param: Select	port [0|1]
	 * */
	public Integer getData() throws MUXSelectionOutOfBounds		{

		switch (select) {
		case ZERO:
			return currentDataPortA;
		case 1:
			return currentDataPortB;
		default:
			throw new MUXSelectionOutOfBounds("MUX Selection ["+select+"] is not valid!");
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
