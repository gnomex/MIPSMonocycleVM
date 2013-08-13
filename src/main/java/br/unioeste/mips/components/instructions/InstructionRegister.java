package br.unioeste.mips.components.instructions;

import br.unioeste.mips.common.instruction.Instruction;
import br.unioeste.mips.components.registers.Register;

public class InstructionRegister {

	private Integer r3126;	//rs
	private Integer r2521;	//rt
	private Integer r2016;	//rd
	private Integer r150;	//Shamt, funct, imm
	private Instruction instruction;
	
	private Boolean IRWRITE;
	
	public void setInstruction(Instruction currentInstruction)	{
		this.instruction = currentInstruction;
	}
	
	public void transcodeInstruction(){
		
		System.out.println("Nothing implemented yet!!!\n\nSEE Instruction Register");
		
	}

	public Integer getR3126() {
		return r3126;
	}

	public Integer getR2521() {
		return r2521;
	}

	public Integer getR2016() {
		return r2016;
	}

	public Integer getR150() {
		return r150;
	}

	public Instruction getInstruction() {
		return instruction;
	}

	
	
	public void setIRWRITE(Boolean iRWRITE) {
		IRWRITE = iRWRITE;
	}

	public Integer get250() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer get50() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
