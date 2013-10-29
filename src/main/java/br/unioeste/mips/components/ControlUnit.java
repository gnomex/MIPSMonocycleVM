package br.unioeste.mips.components;

import static br.unioeste.mips.util.Util.ZERO;
import br.unioeste.mips.common.vm.VMInterface;

public class ControlUnit implements VMInterface	{

	/**
	 * Datapath flags
	 * ALL ZERO value dafaults!!!
	 * */

	private Integer OPCODE = ZERO;

	private Integer PCWRITECOND	=	ZERO;
	private Integer PCWRITE	=	ZERO;
	private Integer IORD	=	ZERO;
	private Boolean MEMREAD	=	Boolean.TRUE;
	private Boolean MEMWRITE	=	Boolean.FALSE;
	private Integer MEMTOREG	=	ZERO;
	private Boolean IRWRITE	=	Boolean.TRUE;
	private Integer PCSOURCE	=	ZERO;
	private Integer ALUOP	=	ZERO;
	private Integer ALUSRCA	=	ZERO;
	private Integer ALUSRCB	=	ZERO;
	private Boolean REGWRITE	=	Boolean.TRUE;
	private Integer REGDST	=	ZERO;

	/*
	 * Alter flags to default value
	 * */
	public void makeCleanAll()	{

		PCWRITECOND = ZERO;
		PCWRITE = ZERO;
		IORD	=	ZERO;
		MEMREAD	=	Boolean.TRUE;
		MEMWRITE	=	Boolean.FALSE;
		MEMTOREG	=	ZERO;
		IRWRITE	=	Boolean.TRUE;
		PCSOURCE	=	ZERO;
		ALUOP	=	ZERO;
		ALUSRCA	=	ZERO;
		ALUSRCB	=	ZERO;
		REGWRITE	=	Boolean.TRUE;
		REGDST	=	ZERO;
	}

	public void makeSnapshot()	{
		System.out.println("### Control Unit Snapshot:");
		System.out.println("  >PCWRITECOND: " + PCWRITECOND);
		System.out.println("  >PCWRITE: " + PCWRITE);
		System.out.println("  >IORD: " + IORD);
		System.out.println("  >MEMREAD: " + MEMREAD);
		System.out.println("  >MEMWRITE: " + MEMWRITE);
		System.out.println("  >MEMTOREG: " + MEMTOREG);
		System.out.println("  >IRWIRTE: " + IRWRITE);
		System.out.println("  >PCSOURCE: " + PCSOURCE);
		System.out.println("  >ALUOP: " + ALUOP);
		System.out.println("  >ALUSRCA: " + ALUSRCA);
		System.out.println("  >ALUSRCB: " + ALUSRCB);
		System.out.println("  >REGWRITE: " + REGWRITE);
		System.out.println("  >REGDST: " + REGDST);
		System.out.println("### END OF Snapshot ###\n");
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


	public Boolean getMEMREAD() {
		return MEMREAD;
	}


	public void setMEMREAD(Boolean mEMREAD) {
		MEMREAD = mEMREAD;
	}


	public Boolean getMEMWRITE() {
		return MEMWRITE;
	}


	public void setMEMWRITE(Boolean mEMWRITE) {
		MEMWRITE = mEMWRITE;
	}


	public Integer getMEMTOREG() {
		return MEMTOREG;
	}


	public void setMEMTOREG(Integer mEMTOREG) {
		MEMTOREG = mEMTOREG;
	}


	public Boolean getIRWRITE() {
		return IRWRITE;
	}


	public void setIRWRITE(Boolean iRWRITE) {
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


	public Boolean getREGWRITE() {
		return REGWRITE;
	}


	public void setREGWRITE(Boolean rEGWRITE) {
		REGWRITE = rEGWRITE;
	}


	public Integer getREGDST() {
		return REGDST;
	}


	public void setREGDST(Integer rEGDST) {
		REGDST = rEGDST;
	}


	public void setOPCODE(Integer oPCODE) {
		OPCODE = oPCODE;
	}

	public Integer getOPCODE()	{
		return this.OPCODE;
	}
	

}
