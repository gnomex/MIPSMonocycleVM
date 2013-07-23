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
import br.unioeste.mips.gui.MipsMonitorGUI;
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
	
	private InstructionRegister instructionRegister	=	null;
	private Registers registers	=	null;
	
	/**
	 * All Mux's
	 * */
	private Mux2LogicalGates IORD	=	null;
	private Mux2LogicalGates REGDST	=	null;
	private Mux2LogicalGates MEMTOREG	=	null;
	private Mux2LogicalGates ALUSRCA	=	null;
		
	private Mux4LogicalGates ALUSRCB	=	null;
	private Mux4LogicalGates PCSOURCE	=	null;
	
	
	private TemporaryMemory A	=	null;
	private TemporaryMemory B	=	null;
	private TemporaryMemory ALUOUT	=	null;
	
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
