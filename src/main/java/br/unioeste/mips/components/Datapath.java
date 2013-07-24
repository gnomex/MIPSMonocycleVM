package br.unioeste.mips.components;

import java.awt.EventQueue;

import br.unioeste.mips.common.exception.IncrasePCOverflow;
import br.unioeste.mips.common.exception.MUXSelectionOutOfBounds;
import br.unioeste.mips.common.mux.Mux2LogicalGates;
import br.unioeste.mips.common.mux.Mux4LogicalGates;
import br.unioeste.mips.common.shift.Shifter;
import br.unioeste.mips.components.counter.PCWriteControl;
import br.unioeste.mips.components.counter.ProgramCounter;
import br.unioeste.mips.components.instructions.InstructionRegister;
import br.unioeste.mips.components.memory.DataMemory;
import br.unioeste.mips.components.memory.TemporaryMemory;
import br.unioeste.mips.components.registers.Register;
import br.unioeste.mips.components.registers.Registers;
import br.unioeste.mips.components.ula.ALU;
import br.unioeste.mips.components.ula.control.ALUControlUnit;
import br.unioeste.mips.dump.DumpListener;
import static br.unioeste.mips.util.Util.PC_OFFSET;
import static br.unioeste.mips.util.Util.LEFT;

	/**
	 * Risc Multicycle datapath
	 * */

public class Datapath {
	
	private ALU ula	=	null;
	private ALUControlUnit aluControl	=	null;
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
	
	/**
	 * Makes a datapath Snapshot and send to GUI
	 * */
	//private DumpListener dump;	//Observer Pattern - to get snapshots and send to GUI
	
	/**
	 * Big Constructor
	 * Initializes all datapath components
	 * */
	public Datapath()	{
		
		ula = new ALU();
		aluControl = new ALUControlUnit();
		
		controlUnit = new ControlUnit();
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
	 * */
	/*
	 * Set Muxs flags
	 */
	public void setSelectIORD(Integer selectFlag)	{
		IORD.setSelect(selectFlag);
	}
	public void setSelectREGDST(Integer selectFlag)	{
		REGDST.setSelect(selectFlag);
	}
	public void setSelectMEMTOREG(Integer selectFlag)	{
		MEMTOREG.setSelect(selectFlag);
	}
	public void setSelectALUSRCA(Integer selectFlag)	{
		ALUSRCA.setSelect(selectFlag);
	}
	public void setSelectALUSRCB(Integer selectFlag)	{
		ALUSRCB.setSelect(selectFlag);
	}
	public void setSelectPCSOURCE(Integer selectFlag)	{
		PCSOURCE.setSelect(selectFlag);
	}
	
		
	public void notifyFlags()	{
		// [31-26] bits to control unit - Decode flags and
		//set components flags
		//update all datapath
		/*
		 * */
	}
	
	public void setIRWRITE(Boolean flagIRWRITE)	{
		
		instructionRegister.setIRWRITE(flagIRWRITE);
		
	}
	
	public void setPCWRITE(Integer flagPCWIRTE)	{
		pcwriteControl.setPCWRITE(flagPCWIRTE);
	}
	
	public void setMEMREAD(Boolean flagMEMREAD){
		//memory.setMEMREAD(flagMEMREAD);
	}
	
	public void setMEMWRITE(Boolean flagMEMWRITE)	{
		//memory.setMEMWIRTE(flagMEMWRITE);
	}

	public void setREGWRITE(Boolean flagREGWRITE)	{
		
	}
	
	/*
	 * All ways
	 * */
	public void PcToIORD(){
		
		IORD.setCurrentDataPortA(pc.getPC());
		
	}
	public void PcToALUSRCA()	{
		
		ALUSRCA.setCurrentDataPortA(pc.getPC());
		
	}
	public void ALUOUTToIORD()	{
		
		IORD.setCurrentDataPortB(ALUOUT.getRawValue());
		
	}
	public void IorDToMemory() throws MUXSelectionOutOfBounds{
		
		memory.setAdrress(IORD.getData());
		
	}
	public void MemoryToMemoryDataRegister() throws Exception{
		
		memoryDataRegister.setValue(memory.getData());
		
	}
	public void MemoryToInstructionRegister() throws Exception{
		
		instructionRegister.setInstruction(memory.getInstruction());
		
		instructionRegister.transcodeInstruction();
		
	}
	public void InstructionRegisterR3126ToControlUnit(){
		
		
		
	}
	public void InstructionRegisterR2521ToRSRegister(){
		
		registers.setRS(instructionRegister.getR2521());
		
	}
	public void InstructionRegisterR2016ToRTRegister(){
		
		registers.setRT(instructionRegister.getR2016());
		
	}
	public void InstructionRegisterR2016ToREGDST(){
	
		REGDST.setCurrentDataPortA(instructionRegister.getR2016());;
		
	}
	public void InstructionRegisterR150ToREGDST(){
	
		REGDST.setCurrentDataPortB(instructionRegister.getR150());
		
	}
	public void REGDSTToRDRegister() throws MUXSelectionOutOfBounds{
		
		registers.setRD(REGDST.getData());
		
	}
	public void MEMTOREGToWriteDataRegister() throws MUXSelectionOutOfBounds{
		
		registers.setWriteData(MEMTOREG.getData());
		
	}
	public void MemoryDataRegisterToMEMTOREG(){
		
		MEMTOREG.setCurrentDataPortB(memoryDataRegister.getValue());
		
	}
	public void ALUOUTToMEMTOREG(){
		
		MEMTOREG.setCurrentDataPortA(ALUOUT.getRawValue());
		
	}
	public void ALUOUTToPCSource()	{
		
		PCSOURCE.setCurrentDataPortB(ALUOUT.getRawValue());
		
	}
	public void RegisterReadData1ToA(){
		
		A.setTemporaryValue(registers.getALUOp1());
		
	}
	public void RegisterReadData1ToB(){
		
		B.setTemporaryValue(registers.getALUOp2());
		
	}
	public void AToALUSRCA()	{
		
		ALUSRCA.setCurrentDataPortB(A.getRawValue());
		
	}
	public void BToALUSRCB(){
		
		ALUSRCB.setCurrentDataPortA(B.getRawValue());
		
	}
	public void BToMemoryWriteData() throws Exception	{
		
		memory.push(B.getRawValue());
		
	}
	public void InstructionRegisterR150ToALUSRCB()	{
		
		ALUSRCB.setCurrentDataPortC(instructionRegister.getR150());
		
	}
	public void InstructionRegisterR150SHIFTERToALUSRCB()	{
		
		Integer toshift = instructionRegister.getR150();
		Shifter.shift(toshift, 2, LEFT);
		
	}
	public void ALUSRCAToAlu() throws MUXSelectionOutOfBounds	{
		
		ula.setRawInput1(ALUSRCA.getData());
		
	}
	public void ALUSRCBToAlu() throws MUXSelectionOutOfBounds	{
		
		ula.setRawInput2(ALUSRCB.getData());
		
	}
	public void ALUToALUOUT()	{
	
		ALUOUT.setTemporaryValue(ula.getResult());
		
	}
	public void ALUToPCSource()	{
		
		PCSOURCE.setCurrentDataPortA(ula.getResult());
		
	}
	public void ALUZeroToPcWriteControl()	{
		
		pcwriteControl.setALUZEROFLAG(ula.isActiveZeroFlag());
		
	}
	public void PcSourceToPC() throws IncrasePCOverflow, MUXSelectionOutOfBounds	{
		
		pc.incrasePC(PCSOURCE.getData());
		
	}
	//Needs get PC[31-28] bits
	public void InstructionRegisterJumpAddressToPcSource()	{
		
		Integer j250 = instructionRegister.get250();
		
		Shifter.shift(j250, 2, LEFT);
		
	}
	
	public void ALUEXECUTE()	{
		ula.execute(aluControl.getALUOPERATION());
	}
	
	/*
	 * ALU Control Unit
	 * */
	
	public void setALUOP(Integer aluop){
		aluControl.setRaw6bits(aluop);
		aluControl.decode();
	}
	
	/*
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
