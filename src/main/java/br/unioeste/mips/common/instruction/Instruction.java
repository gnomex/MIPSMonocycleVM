package br.unioeste.mips.common.instruction;

/*
 * Classe representa uma instrução da arquitetura MIPS
 * 
 * */

import java.util.Map;

public class Instruction {

	/**
	 * Map< type atribute, value >
	 * */
	private Map<String, Byte> inst;

	public Map<String, Byte> getInst() {
		return inst;
	}

	public void setInst(Map<String, Byte> inst) {
		this.inst = inst;
	}
	
	
}
