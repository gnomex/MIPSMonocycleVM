package br.unioeste.mips.common.instruction;

import static br.unioeste.mips.util.Global.OPCODE_ITYPE;

public class InstructionI extends Instruction{

	public InstructionI()	{
		this.setType(OPCODE_ITYPE);
	}
}
