package br.unioeste.mips.components.instructions;

import br.unioeste.mips.common.bit.BitDecoder;
import br.unioeste.mips.common.instruction.Instruction;

public class InstructionRegister {

	private Instruction instruction;
	
	private Boolean IRWRITE = Boolean.TRUE;	//Default Value
	
	private BitDecoder decoder = new BitDecoder();
	
	public void setInstruction(Instruction currentInstruction) throws Exception	{
		if (IRWRITE)	{
			this.instruction = currentInstruction;
		} else	{
			throw new Exception("You can't assign this instruction, the IRWRITE Flag is " + IRWRITE);
		}
	}

	public Integer getR3126() {
		return instruction.getOpcode();
	}

	public Integer getR2520() {
		return decoder.getRangeBits(instruction.getRawinstruction(), 20, 25);
	}

	public Integer getR2015() {
		return decoder.getRangeBits(instruction.getRawinstruction(), 15, 20);
	}

	public Integer getR150() {
		return decoder.getRangeBits(instruction.getRawinstruction(), 0, 15);
	}

	public Instruction getInstruction() {
		return instruction;
	}

	
	
	public void setIRWRITE(Boolean iRWRITE) {
		IRWRITE = iRWRITE;
	}

	public Integer get250() {
		return decoder.getRangeBits(instruction.getRawinstruction(), 0, 25);
	}

	public Integer get50() {
		return decoder.getRangeBits(instruction.getRawinstruction(), 0, 5);
	}

	public Integer getR1511() {
		return decoder.getRangeBits(instruction.getRawinstruction(), 15, 10);
	}
	
	
}
