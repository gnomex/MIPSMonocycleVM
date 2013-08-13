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
	private Integer programCounter = ZERO;		//
	private Boolean PCWRITEFLAG = Boolean.TRUE;


	public void incrasePC(Integer incrasevalue)	throws PCWritePermissionDenied{

		if(PCWRITEFLAG)	{
			this.programCounter = this.programCounter + incrasevalue;
			System.out.println(" ~> Increasing PC, new value are: " + this.programCounter);
		}	else	{
			throw new PCWritePermissionDenied("You no have permission to write on PC!!!");
		}

	}

	public Integer getPC()	{
		return this.programCounter;	
	}

	public void setPCWRITEFLAG(Boolean pCWRITEFLAG) {
		PCWRITEFLAG = pCWRITEFLAG;
	}



}
