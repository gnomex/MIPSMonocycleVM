package br.unioeste.mips.common.instruction;

import static br.unioeste.mips.util.Util.OPCODE_JTYPE;

public class InstructionJ extends Instruction{

	private Integer targetAddress;
	
	public InstructionJ()	{
		this.setOpcode(OPCODE_JTYPE);
	}

	public Integer getTargetAddress() {
		return targetAddress;
	}

	public void setTargetAddress(Integer targetAddress) {
		this.targetAddress = targetAddress;
	}
	
	
}
