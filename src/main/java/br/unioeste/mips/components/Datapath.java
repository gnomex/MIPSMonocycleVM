package br.unioeste.mips.components;

import java.awt.EventQueue;

import br.unioeste.mips.common.mux.Mux2LogicalGates;
import br.unioeste.mips.common.mux.Mux4LogicalGates;
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
	private DumpListener dump;	//Observer Pattern - to get snapshots and send to GUI
	
	/**
	 * Big Constructor
	 * Initializes all datapath components
	 * */
	public Datapath()	{
		
		ula = new ALU();
		aluControl = new ALUControlUnit(ula);
		
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
	 * 
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
	*/
		
	public void notifyFlags()	{
		// [31-26] bits to control unit - Decode flags and
		//set components flags
		//update all datapath
	}
	
	/*
	 * All ways
	 * */
	public void PcToIORD(){
		
	}
	public void PcToALUSRCA()	{
		
	}
	public void ALUOUTToIORD()	{
		
	}
	public void IorDToMemory(){
		
	}
	public void MemoryToMemoryDataRegister(){
		
	}
	public void MemoryToInstructionRegister(){
		
	}
	public void InstructionRegisterR3126ToControlUnit(){
		
	}
	public void InstructionRegisterR2521ToRSRegister(){
		
	}
	public void InstructionRegisterR2016ToRTRegister(){
		
	}
	public void InstructionRegisterR2016ToREGDST(){
		
	}
	public void InstructionRegisterR150ToREGDST(){
		
	}
	public void REGDSTToRDRegister(){
		
	}
	public void MEMTOREGToWriteDataRegister(){
		
	}
	public void MemoryDataRegisterToMEMTOREG(){
		
	}
	public void ALUOUTToMEMTOREG(){
		
	}
	public void ALUOUTToPCSource()	{
		
	}
	public void RegisterReadData1ToA(){
		
	}
	public void RegisterReadData1ToB(){
		
	}
	public void AToALUSRCA()	{
		
	}
	public void BToALUSRCB(){
		
	}
	public void BToMemoryWriteData()	{
		
	}
	public void InstructionRegisterR150ToALUSRCB()	{
		
	}
	public void InstructionRegisterR150SHIFTERToALUSRCB()	{
		
	}
	public void ALUSRCAToAlu()	{
		
	}
	public void ALUSRCBToAlu()	{
		
	}
	public void ALUToALUOUT()	{
		
	}
	public void ALUToPCSource()	{
		
	}
	public void ALUZeroToPcWriteControl()	{
		
	}
	public void PcSourceToPC()	{
		
	}
	//Needs get PC[31-28] bits
	public void InstructionRegisterJumpAddressToPcSource()	{
		
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
