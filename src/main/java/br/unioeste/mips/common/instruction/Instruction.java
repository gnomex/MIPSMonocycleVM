package br.unioeste.mips.common.instruction;

/*
 * Classe representa uma instrução da arquitetura MIPS
 * 
 * */

public class Instruction	{
	
	private Integer opcode;
	
	private String typeName;

	public Integer getOpcode() {
		return opcode;
	}

	public void setOpcode(Integer opcode) {
		this.opcode = opcode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
