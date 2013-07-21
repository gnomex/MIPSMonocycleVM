package br.unioeste.mips.common.mux;

import static br.unioeste.mips.util.Util.ZERO;
import br.unioeste.mips.common.exception.MUXSelectionOutOfBounds;

/**
 * 
 * Logical ports 0,1,2,3 - 4gates
 * 
 * */

public class Mux4LogicalGates {

	/*
	 * 2 selection bits
	 * */
	private Integer select	=	ZERO;	//Default

	private Integer currentDataPortA;
	private Integer currentDataPortB;
	private Integer currentDataPortC;
	private Integer currentDataPortD;

	/**
	 * Get open port
	 * @throws MUXSelectionOutOfBounds 
	 * @Param: Select	port [0|1|2|3]
	 * */
	public Integer getData() throws MUXSelectionOutOfBounds		{

		switch (select) {
		case ZERO:
			return currentDataPortA;
		case 1:
			return currentDataPortB;
		case 2:
			return currentDataPortC;
		case 3:
			return currentDataPortD;
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

	public void setCurrentDataPortC(Integer currentDataPortC) {
		this.currentDataPortC = currentDataPortC;
	}

	public void setCurrentDataPortD(Integer currentDataPortD) {
		this.currentDataPortD = currentDataPortD;
	}

	


}
