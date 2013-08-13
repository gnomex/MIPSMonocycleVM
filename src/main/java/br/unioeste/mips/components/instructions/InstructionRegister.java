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
		System.out.println(" >> Instruction OPCODE: " + instruction.getOpcode());
		return instruction.getOpcode();
	}

	public Integer getR2520() {
		Integer reg = decoder.getRangeBits(instruction.getRawinstruction(), 20, 25);
		System.out.println(" >> Intruction [25-20] : " + reg);
		return reg;
	}

	public Integer getR2015() {
		Integer reg = decoder.getRangeBits(instruction.getRawinstruction(), 15, 20);
		System.out.println(" >> Intruction [20-15] : " + reg);
		return reg;
	}

	public Integer getR150() {
		Integer reg = decoder.getRangeBits(instruction.getRawinstruction(), 0, 15);
		System.out.println(" >> Intruction [15-0] : " + reg);
		return reg; 
	}

	public Instruction getInstruction() {
		return instruction;
	}

	
	
	public void setIRWRITE(Boolean iRWRITE) {
		IRWRITE = iRWRITE;
	}

	public Integer get250() {
		
		Integer reg = decoder.getRangeBits(instruction.getRawinstruction(), 0, 25);
		System.out.println(" >> Intruction [25-0] : " + reg);
		return reg;
	}

	public Integer get50() {
		
		Integer reg = decoder.getRangeBits(instruction.getRawinstruction(), 0, 5);
		System.out.println(" >> Intruction [5-0] : " + reg);
		return reg;
	}

	public Integer getR1511() {
		
		Integer reg = decoder.getRangeBits(instruction.getRawinstruction(), 15, 10);
		System.out.println(" >> Intruction [15-10] : " + reg);
		return reg;
	}
	
	
}
