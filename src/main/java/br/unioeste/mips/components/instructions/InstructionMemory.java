package br.unioeste.mips.components.instructions;

/**
 * Classe que representa a memoria de instruçoes - Instruction Memory
 * 
 * */


import java.util.ArrayList;

public class InstructionMemory {

	private ArrayList<br.unioeste.mips.common.instruction.Instruction> instructions;

	public void setInstructions(ArrayList<br.unioeste.mips.common.instruction.Instruction> instructions) {
		
		this.instructions = instructions;
	}

	
}
