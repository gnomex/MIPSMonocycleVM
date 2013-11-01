package br.unioeste.mips.components;

import java.awt.EventQueue;
import java.io.Serializable;

import br.unioeste.mips.common.bit.BitDecoder;
import br.unioeste.mips.common.exception.IncrasePCOverflow;
import br.unioeste.mips.common.exception.MUXSelectionOutOfBounds;
import br.unioeste.mips.common.exception.PCWritePermissionDenied;
import br.unioeste.mips.common.mux.Mux2LogicalGates;
import br.unioeste.mips.common.mux.Mux4LogicalGates;
import br.unioeste.mips.common.shift.Shifter;
import br.unioeste.mips.common.vm.VMInterface;
import br.unioeste.mips.components.counter.PCWriteControl;
import br.unioeste.mips.components.counter.ProgramCounter;
import br.unioeste.mips.components.instructions.InstructionRegister;
import br.unioeste.mips.components.memory.DataMemory;
import br.unioeste.mips.components.memory.TemporaryMemory;
import br.unioeste.mips.components.registers.Register;
import br.unioeste.mips.components.registers.Registers;
import br.unioeste.mips.components.ula.ALU;
import br.unioeste.mips.components.ula.ALUControlUnit;
import static br.unioeste.mips.util.Util.PC_OFFSET;
import static br.unioeste.mips.util.Util.LEFT;

/**
 * Risc Multicycle datapath
 * */

public class Datapath implements VMInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	
	private ALU ula	=	null;
	private ALUControlUnit aluControl	=	null;
	//
	private ControlUnit controlUnit	=	null;

	private ProgramCounter pc	=	null;
	private PCWriteControl pcwriteControl = null;
	private DataMemory memory	=	null;
	/*
	 * Registers
	 * */
	private InstructionRegister instructionRegister	=	null;
	private Registers registers	=	null;
	/*
	 * All Mux's
	 * */
	private Mux2LogicalGates IORD	=	null;
	private Mux2LogicalGates REGDST	=	null;
	private Mux2LogicalGates MEMTOREG	=	null;
	private Mux2LogicalGates ALUSRCA	=	null;
	private Mux4LogicalGates ALUSRCB	=	null;
	private Mux4LogicalGates PCSOURCE	=	null;
	/*
	 * Temporary memorys
	 * */
	private TemporaryMemory A	=	null;	//Name is default on MIPS
	private TemporaryMemory B	=	null;	//Name is default on MIPS
	private TemporaryMemory ALUOUT	=	null;	//Name is default on MIPS

	private Register memoryDataRegister	=	null;

	//private DumpListener dump;	//Clone and make a Datapath snapshot

	/**
	 * Big Constructor
	 * Initializes all datapath components
	 * */
	public Datapath()	{

		ula = new ALU();
		aluControl = new ALUControlUnit();

		pcwriteControl = new PCWriteControl();
		pc = new ProgramCounter();
		memory = new DataMemory();
		instructionRegister = new InstructionRegister();

		registers = new Registers();

		IORD = new Mux2LogicalGates();
		REGDST = new Mux2LogicalGates();
		MEMTOREG = new Mux2LogicalGates();
		ALUSRCA = new Mux2LogicalGates();
		ALUSRCB = new Mux4LogicalGates();
		ALUSRCB.setCurrentDataPortB(PC_OFFSET);	//Default offset SUM
		PCSOURCE = new Mux4LogicalGates();

		this.A = new TemporaryMemory();
		this.B = new TemporaryMemory();
		ALUOUT = new TemporaryMemory();

		memoryDataRegister = new Register();
		memoryDataRegister.setName("Memory Data Register");
		memoryDataRegister.setWritePermission(Boolean.TRUE);

		System.err.println("##\n\n  Datapath loaded, waiting for work!\n\n##");

	}

	/**
	 * The methods below interpreter the transmission of bits of one component to another
	 * ========================================================================
	 * */
	/*
	 * Set Muxs flags
	 */
	protected void setSelectIORD(Integer selectFlag)	{
		IORD.setSelect(selectFlag);
	}
	protected void setSelectREGDST(Integer selectFlag)	{
		REGDST.setSelect(selectFlag);
	}
	protected void setSelectMEMTOREG(Integer selectFlag)	{
		MEMTOREG.setSelect(selectFlag);	
	}
	protected void setSelectALUSRCA(Integer selectFlag)	{
		ALUSRCA.setSelect(selectFlag);
	}
	protected void setSelectALUSRCB(Integer selectFlag)	{
		ALUSRCB.setSelect(selectFlag);
	}
	protected void setSelectPCSOURCE(Integer selectFlag)	{
		PCSOURCE.setSelect(selectFlag);
	}
	protected void setIRWRITE(Boolean flagIRWRITE)	{
		instructionRegister.setIRWRITE(flagIRWRITE);	
	}

	protected void setPCWRITE(Integer flagPCWIRTE)	{
		pcwriteControl.setPCWRITE(flagPCWIRTE);
	}

	protected void setPCWRITECOND(Integer flagPCWRITECOND)	{
		pcwriteControl.setPCWRITECOND(flagPCWRITECOND);
	}

	protected void setMEMREAD(Boolean flagMEMREAD){
		memory.setMEMREAD(flagMEMREAD);
	}

	protected void setMEMWRITE(Boolean flagMEMWRITE)	{
		memory.setMEMWRITE(flagMEMWRITE);
	}

	protected void setREGWRITE(Boolean flagREGWRITE)	{
		registers.setRegWrite(flagREGWRITE);
	}	

	public ControlUnit getControlUnit()	{
		return this.controlUnit;
	}

	public void notifyFlafs()	{
		this.setSelectIORD(controlUnit.getIORD());
		this.setSelectREGDST(controlUnit.getREGDST());
		this.setSelectMEMTOREG(controlUnit.getMEMTOREG());
		this.setSelectALUSRCA(controlUnit.getALUSRCA());
		this.setSelectALUSRCB(controlUnit.getALUSRCB());
		this.setSelectPCSOURCE(controlUnit.getPCSOURCE());
		//POG
		this.aluControl.setALUOPFALG(controlUnit.getALUOP());
		this.setIRWRITE(controlUnit.getIRWRITE());
		this.setPCWRITE(controlUnit.getPCWRITE());
		this.setPCWRITECOND(controlUnit.getPCWRITECOND());
		this.ALUZeroToPcWriteControl();

		this.setMEMREAD(controlUnit.getMEMREAD());
		this.setMEMWRITE(controlUnit.getMEMWRITE());

		this.setREGWRITE(controlUnit.getREGWRITE());
		//Print current control unit state
		controlUnit.makeSnapshot();
	}

	/*
	 * Shortcuts
	 * */
	/**
	 * Load Instruction from atual PC
	 * @throws Exception
	 * */
	public void loadInstructionByAtualPC() throws Exception	{
		this.PcToIORD();
		this.IorDToMemory();
		this.MemoryToInstructionRegister();
	}

	public void increasePC() throws MUXSelectionOutOfBounds, IncrasePCOverflow, PCWritePermissionDenied	{
		this.ALUSRCAToAlu();
		this.ALUSRCBToAlu();
		
		this.aluControl.setALUOPFALG(controlUnit.getALUOP());
		this.aluControl.setRaw6bits(instructionRegister.get50()); //Funct
		
		this.ALUCONTROLToULA();
		this.ALUEXECUTE();
		this.ALUToPCSource();
		this.PcSourceToPC();
	}
	
	public void setRegisters() throws MUXSelectionOutOfBounds	{
		this.InstructionRegisterR2521ToRSRegister();
		this.InstructionRegisterR2016ToRTRegister();
		this.InstructionRegisterR2016ToREGDST();
		this.InstructionRegisterR1511ToREGDST();
		this.REGDSTToRDRegister();
		this.InstructionRegisterR150ToALUSRCB();
		this.InstructionRegisterR150SHIFTERToALUSRCB();
		
		this.registers.makeSnapshot();
	}
	
	/*
	 * All ways
	 * ========================================================================
	 * */
	public void PcToIORD(){
		System.out.println(">Moving pc to IORD");
		IORD.setCurrentDataPortA(pc.getPC());

	}
	public void PcToALUSRCA()	{
		System.out.println(">Moving pc to ALUSRCA");
		ALUSRCA.setCurrentDataPortA(pc.getPC());

	}
	public void ALUOUTToIORD()	{
		System.out.println(">Moving ALUOUT to IORD");
		IORD.setCurrentDataPortB(ALUOUT.getRawValue());

	}
	public void IorDToMemory() throws MUXSelectionOutOfBounds{
		System.out.println(">Moving IORD to Memory");
		memory.setAdrress(IORD.getData());

	}
	public void MemoryToMemoryDataRegister() throws Exception{
		System.out.println(">Moving Memory to MemoryDataRegister");
		memoryDataRegister.setValue(memory.getData());

	}
	public void MemoryToInstructionRegister() throws Exception{
		System.out.println(">Moving Memory to InstructionRegister");
		instructionRegister.setInstruction(memory.getInstruction());

	}
	public void InstructionRegisterR3126ToControlUnit(){
		System.out.println(">Moving opcode to ControlUnit");
		controlUnit.setOPCODE(instructionRegister.getR3126());

	}
	public void InstructionRegisterR2521ToRSRegister(){
		System.out.println(">Moving InstructionRegister [25-21] to RS");
		registers.setRS(instructionRegister.getR2520());

	}
	public void InstructionRegisterR2016ToRTRegister(){
		System.out.println(">Moving InstructionRegister [20-16] to RT");
		registers.setRT(instructionRegister.getR2015());

	}
	public void InstructionRegisterR2016ToREGDST(){
		System.out.println(">Moving InstructionRegister [20-16] to REGDST");
		REGDST.setCurrentDataPortA(instructionRegister.getR2015());;

	}
	public void InstructionRegisterR1511ToREGDST(){
		System.out.println(">Moving InstructionRegister [15-11] to REGDST");
		REGDST.setCurrentDataPortB(instructionRegister.getR1511());

	}
	public void REGDSTToRDRegister() throws MUXSelectionOutOfBounds{
		System.out.println(">Moving REGDST to RD");
		registers.setRD(REGDST.getData());

	}
	public void MEMTOREGToWriteDataRegister() throws MUXSelectionOutOfBounds{
		System.out.println(">Moving MEMTOREG to WriteDataRegister");
		registers.setWriteData(MEMTOREG.getData());

	}
	public void MemoryDataRegisterToMEMTOREG(){
		System.out.println(">Moving MemoryDataRegister to MEMTOREG");
		MEMTOREG.setCurrentDataPortB(memoryDataRegister.getValue());

	}
	public void ALUOUTToMEMTOREG(){
		System.out.println(">Moving ALUOUT to MEMTOREG");
		MEMTOREG.setCurrentDataPortA(ALUOUT.getRawValue());

	}
	public void ALUOUTToPCSource()	{
		System.out.println(">Moving ALUOUT To PCSOURCE");
		PCSOURCE.setCurrentDataPortB(ALUOUT.getRawValue());

	}
	public void RegisterReadData1ToA(){
		System.out.println("Datapath.RegisterReadData1ToA");
		A.setTemporaryValue(registers.getALUOp1());

	}
	public void RegisterReadData1ToB(){
		System.out.println("Datapath.RegisterReadData1ToB");
		B.setTemporaryValue(registers.getALUOp2());

	}
	public void AToALUSRCA()	{
		System.out.println("Datapath.AToALUSRCA()");
		ALUSRCA.setCurrentDataPortB(A.getRawValue());

	}
	public void BToALUSRCB(){
		System.out.println("Datapath.BToALUSRCB()");
		ALUSRCB.setCurrentDataPortA(B.getRawValue());

	}
	public void BToMemoryWriteData() {
		System.out.println("Datapath.BToMemoryWriteData()");
		try {
			memory.push(B.getRawValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("- ERROR - #Can't push data to memory");
		}

	}
	public void InstructionRegisterR150ToALUSRCB()	{
		System.out.println("Datapath.InstructionRegisterR150ToALUSRCB()");
		ALUSRCB.setCurrentDataPortC(instructionRegister.getR150());

	}
	public void InstructionRegisterR150SHIFTERToALUSRCB()	{
		System.out.println("Datapath.InstructionRegisterR150SHIFTERToALUSRCB()");
		Integer toshift = instructionRegister.getR150();
		Shifter.shift(toshift, 2, LEFT);

	}
	public void ALUSRCAToAlu() throws MUXSelectionOutOfBounds	{
		System.out.println("Datapath.ALUSRCAToAlu()");
		ula.setRawInput1(ALUSRCA.getData());

	}
	public void ALUSRCBToAlu() throws MUXSelectionOutOfBounds	{
		System.out.println("Datapath.ALUSRCBToAlu");
		ula.setRawInput2(ALUSRCB.getData());

	}
	public void ALUToALUOUT()	{
		System.out.println("Datapath.ALUToALUOUT()");
		ALUOUT.setTemporaryValue(ula.getResult());

	}
	public void ALUToPCSource()	{
		System.out.println("Datapath.ALUToPCSource()");
		PCSOURCE.setCurrentDataPortA(ula.getResult());

	}
	public void ALUZeroToPcWriteControl()	{
		System.out.println("Datapath.ALUZeroToPcWriteControl()");
		pcwriteControl.setALUZEROFLAG(ula.isActiveZeroFlag());

	}
	public void ALUCONTROLToULA()	{
		System.out.println("Datapath.ALUCONTROLToULA()");
		
		this.aluControl.decode();
		
		this.ula.setOperation(this.aluControl.getALUOPERATION());
		
	}
	
	public void PcSourceToPC() throws IncrasePCOverflow, MUXSelectionOutOfBounds, PCWritePermissionDenied	{
		System.out.println("Datapath.PcSourceToPC()");
		pc.incrasePC(PCSOURCE.getData());
	}

	public void InstructionRegisterJumpAddressToPcSource()	{
		System.out
				.println("Datapath.InstructionRegisterJumpAddressToPcSource()");
		Integer j250 = instructionRegister.get250();

		Shifter.shift(j250, 2, LEFT);

		BitDecoder decoder = new BitDecoder();
		/*
		 * Merge higth pc bits with jump address
		 * */
		int hightbits = decoder.getRangeBits(pc.getPC(), 28, 31);

		Integer jadrress = new Integer(decoder.merge(hightbits, j250));

		PCSOURCE.setCurrentDataPortC(jadrress);

	}

	public void ALUEXECUTE()	{
		ula.execute();
	}

	/*
	 * ALU Control Unit
	 * */

	public void setALUOP(Integer aluop){
		
		System.out.println("Datapath.setALUOP()");
		
		aluControl.setALUOPFALG(aluop);
		aluControl.decode();
		/**
		 * @NEEDCHANGE: alu singleton ! 
		 * */
		ula.setOperation(aluControl.getALUOPERATION());
	}

	public void setControlUnit(ControlUnit current)	{
		this.controlUnit = current;
	}
	
	/* Another POG
	 * */
	
	public Boolean haveMoreInstructions()	{
		if (memory.haveInstructions(pc.getPC()))	{
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/*
	 * ===============================================#########################
	 * */
	
	public Datapath clone() {
		try {
			return this.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// Datapah snapshot
	public void makeSnapshot() {
		
		System.out.println("\n\n  # # # END OF VM - Final Snapshot # # # \n");
		
	}

	public DataMemory getMemorySnapshot()	{
		return this.memory;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((version == null) ? 0 : version.hashCode());
//		return result;
//	}
	
	/*	Invoker - Test Only
	 * ========================================================================
	 * */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Try new instance datapath
					Datapath datapath = new Datapath();

					System.out.println("Work!");

				} catch (Exception e) {
					System.out.println("Problems :(\n\n\n###########################");
					e.printStackTrace();
				}
			}
		});
	}
}
