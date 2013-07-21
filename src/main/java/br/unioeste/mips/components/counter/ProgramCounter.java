package br.unioeste.mips.components.counter;

import static br.unioeste.mips.util.Util.ZERO;
import br.unioeste.mips.common.exception.IncrasePCOverflow;
import br.unioeste.mips.common.exception.PCWritePermissionDenied;

/**
 * Classe que representa o contador de instruções - Program Counter
 * 
 * */

public class ProgramCounter {

	//Program Counter default is zero
	private Integer programCounter = new Integer(ZERO);		//
	private Boolean PCWRITEFLAG = new Boolean(Boolean.TRUE);
	

	public void incrasePC(Integer incrasevalue)	throws IncrasePCOverflow{
		
		try {
			
			if(PCWRITEFLAG)	{
				this.programCounter = this.programCounter + incrasevalue;
			}	else	{
				throw new PCWritePermissionDenied("You no have permission to write on PC!!!");
			}
			
		} catch (Exception e) {
			throw new IncrasePCOverflow("Value Out of bonds to PC!!!");
		}
		
	}
	
	public Integer getPC()	{
		return this.programCounter;	
	}

	public void setPCWRITEFLAG(Boolean pCWRITEFLAG) {
		PCWRITEFLAG = pCWRITEFLAG;
	}
	
	
	
}
