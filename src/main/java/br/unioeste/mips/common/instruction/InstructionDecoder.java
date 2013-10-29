package br.unioeste.mips.common.instruction;

import br.unioeste.mips.common.bit.BitDecoder;

public class InstructionDecoder {

	/**
	 * Return a object instruction compatible
	 * */
	public Instruction decode(Integer raw)	{
		BitDecoder decoder = new BitDecoder();

		Integer opcode = decoder.getRangeBits(raw, 25, 31); //Some cheat, hehe
		
		Instruction inst = new Instruction();
		inst.setOpcode(opcode);
		inst.setRawinstruction(decoder.getRangeBits(raw, 0, 31)); //The real raw code
		
		return inst;
	}

}
