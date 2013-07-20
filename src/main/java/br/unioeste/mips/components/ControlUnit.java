package br.unioeste.mips.components;

import static br.unioeste.mips.util.Util.ZERO;

public class ControlUnit {
	
	/**
	 * Datapath flags
	 * ALL ZERO value dafaults!!!
	 * */
	
	private Integer PCWRITECOND	=	new Integer(ZERO);
	private Integer PCWRITE	=	new Integer(ZERO);
	private Integer IORD	=	new Integer(ZERO);
	private Integer MEMREAD	=	new Integer(ZERO);
	private Integer MEMWRITE	=	new Integer(ZERO);
	private Integer MEMTOREG	=	new Integer(ZERO);
	private Integer IRWRITE	=	new Integer(ZERO);
	private Integer PCSOURCE	=	new Integer(ZERO);
	private Integer ALUOP	=	new Integer(ZERO);
	private Integer ALUSRCA	=	new Integer(ZERO);
	private Integer ALUSRCB	=	new Integer(ZERO);
	private Integer REGWRITE	=	new Integer(ZERO);
	private Integer REGDST	=	new Integer(ZERO);
	
	
	/*
	 * Alter flags to default value
	 * */
	public void makeCleanAll()	{
		
		PCWRITECOND = ZERO;
		PCWRITE = ZERO;
		IORD	=	ZERO;
		MEMREAD	=	ZERO;
		MEMWRITE	=	ZERO;
		MEMTOREG	=	ZERO;
		IRWRITE	=	ZERO;
		PCSOURCE	=	ZERO;
		ALUOP	=	ZERO;
		ALUSRCA	=	ZERO;
		ALUSRCB	=	ZERO;
		REGWRITE	=	ZERO;
		REGDST	=	ZERO;
		
	}
	
	public Integer getPCWRITECOND() {
		return PCWRITECOND;
	}
	public void setPCWRITECOND(Integer pCWRITECOND) {
		PCWRITECOND = pCWRITECOND;
	}
	public Integer getPCWRITE() {
		return PCWRITE;
	}
	public void setPCWRITE(Integer pCWRITE) {
		PCWRITE = pCWRITE;
	}
	public Integer getIORD() {
		return IORD;
	}
	public void setIORD(Integer iORD) {
		IORD = iORD;
	}
	public Integer getMEMREAD() {
		return MEMREAD;
	}
	public void setMEMREAD(Integer mEMREAD) {
		MEMREAD = mEMREAD;
	}
	public Integer getMEMWRITE() {
		return MEMWRITE;
	}
	public void setMEMWRITE(Integer mEMWRITE) {
		MEMWRITE = mEMWRITE;
	}
	public Integer getMEMTOREG() {
		return MEMTOREG;
	}
	public void setMEMTOREG(Integer mEMTOREG) {
		MEMTOREG = mEMTOREG;
	}
	public Integer getIRWRITE() {
		return IRWRITE;
	}
	public void setIRWRITE(Integer iRWRITE) {
		IRWRITE = iRWRITE;
	}
	public Integer getPCSOURCE() {
		return PCSOURCE;
	}
	public void setPCSOURCE(Integer pCSOURCE) {
		PCSOURCE = pCSOURCE;
	}
	public Integer getALUOP() {
		return ALUOP;
	}
	public void setALUOP(Integer aLUOP) {
		ALUOP = aLUOP;
	}
	public Integer getALUSRCA() {
		return ALUSRCA;
	}
	public void setALUSRCA(Integer aLUSRCA) {
		ALUSRCA = aLUSRCA;
	}
	public Integer getALUSRCB() {
		return ALUSRCB;
	}
	public void setALUSRCB(Integer aLUSRCB) {
		ALUSRCB = aLUSRCB;
	}
	public Integer getREGWRITE() {
		return REGWRITE;
	}
	public void setREGWRITE(Integer rEGWRITE) {
		REGWRITE = rEGWRITE;
	}
	public Integer getREGDST() {
		return REGDST;
	}
	public void setREGDST(Integer rEGDST) {
		REGDST = rEGDST;
	}
	
	

}
