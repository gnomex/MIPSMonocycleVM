package br.unioeste.mips.components.counter;

public class PCWriteControl {
	
	private Integer PCWRITECOND;
	private Integer PCWRITE;
	
	private Boolean ALUANDPCWRITECOND = Boolean.FALSE;
	private Boolean ALUZEROFLAG = Boolean.FALSE;
	
	public Boolean getPCWriteFlag()	{
		
		/**
		 * @WANRNING: Some POG
		 * */
		
		Boolean PCBOOLEANWRITECOND = Boolean.FALSE;
		Boolean PCBOOLEANWRITE = Boolean.FALSE;
		
		if (PCWRITECOND == 0)	{
			PCBOOLEANWRITECOND = Boolean.TRUE;
		}
		
		if	(PCWRITE == 0)	{
			PCBOOLEANWRITE = Boolean.TRUE;
		}
		
		if ( ALUZEROFLAG && PCBOOLEANWRITECOND)	{
			ALUANDPCWRITECOND = Boolean.TRUE;
		}
		
		if(ALUANDPCWRITECOND || PCBOOLEANWRITE)	{
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
	
	public void setALUZEROFLAG(Boolean aLUZEROFLAG) {
		ALUZEROFLAG = aLUZEROFLAG;
	}
	public void setPCWRITECOND(Integer pCWRITECOND) {
		PCWRITECOND = pCWRITECOND;
	}
	public void setPCWRITE(Integer pCWRITE) {
		PCWRITE = pCWRITE;
	}

	
	
}
