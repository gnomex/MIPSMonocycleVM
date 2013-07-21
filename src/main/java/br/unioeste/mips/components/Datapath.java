package br.unioeste.mips.components;

import br.unioeste.mips.common.mux.Mux;
import br.unioeste.mips.components.counter.ProgramCounter;
import br.unioeste.mips.components.instructions.InstructionRegister;
import br.unioeste.mips.components.memory.DataMemory;
import br.unioeste.mips.components.memory.TemporaryMemory;
import br.unioeste.mips.components.registers.Register;
import br.unioeste.mips.components.registers.Registers;
import br.unioeste.mips.components.ula.ALU;
import br.unioeste.mips.components.ula.control.ALUControlUnit;
import br.unioeste.mips.dump.DumpListener;

	/**
	 * Risc Multicycle datapath
	 * */

public class Datapath {
	
	private ALU ula	=	null;
	private ALUControlUnit aluControl	=	null;
	private ControlUnit controlUnit	=	null;
	private ProgramCounter pc	=	null;
	private DataMemory memory	=	null;
	
	private InstructionRegister instructionRegister	=	null;
	private Registers registers	=	null;
	
	/**
	 * All Mux's
	 * */
	private Mux IORD	=	null;
	private Mux REGDST	=	null;
	private Mux MEMTOREG	=	null;
	private Mux ALUSRCA	=	null;
	private Mux ALUSRCB	=	null;
	private Mux PCSOURCE	=	null;
	
	private TemporaryMemory A	=	null;
	private TemporaryMemory B	=	null;
	private TemporaryMemory ALUOUT	=	null;
	
	private Register memoryDataRegister	=	null;
	
	/**
	 * Makes a datapath Snapshot and send to GUI
	 * */
	private DumpListener dump;	//Observer Pattern
	
	public Datapath()	{
		ula = new ALU();
		aluControl = new ALUControlUnit(ula);
		
		controlUnit = new ControlUnit();
		pc = new ProgramCounter();
		memory = new DataMemory();
		instructionRegister = new InstructionRegister();
		
		registers = new Registers();
	}
	
	
	
}
