package br.unioeste.mips.common.instruction;

import static br.unioeste.mips.util.Global.OPCODE_JTYPE;

public class InstructionJ extends Instruction{

	public InstructionJ()	{
		this.setType(OPCODE_JTYPE);
	}
}
