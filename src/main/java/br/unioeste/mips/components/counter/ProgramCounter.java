package br.unioeste.mips.components.counter;

import static br.unioeste.mips.util.Util.PC_OFFSET;
import static br.unioeste.mips.util.Util.ZERO;
import br.unioeste.mips.common.exception.IncrasePCOverflow;

/**
 * Classe que representa o contador de instruções - Program Counter
 * 
 * */

public class ProgramCounter {

	//Program Counter default is zero
	private Integer programCounter = new Integer(ZERO);		//
	
	@DEPRECATED
	public void simpleIncPC()	{
		
		this.programCounter = this.programCounter + PC_OFFSET;
		
	}
	
	public void incrasePC(Integer incrasevalue	)	throws IncrasePCOverflow{
		
		try {
			
			this.programCounter = this.programCounter + incrasevalue;
			
		} catch (Exception e) {
			throw new IncrasePCOverflow("Value Out of bonds to PC!!!");
		}
		
	}
	
	public Integer getPC()	{
		return this.programCounter;	
	}
	
}
