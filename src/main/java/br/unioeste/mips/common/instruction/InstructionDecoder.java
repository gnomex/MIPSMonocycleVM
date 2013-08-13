package br.unioeste.mips.common.instruction;

import static br.unioeste.mips.util.Util.OPCODE_ITYPE;
import static br.unioeste.mips.util.Util.OPCODE_JTYPE;
import static br.unioeste.mips.util.Util.OPCODE_RTYPE;

import br.unioeste.mips.common.bit.BitDecoder;

public class InstructionDecoder {

	/**
	 * Return a object instruction compatible
	 * 
	 * */
	public Instruction decode(Integer raw)	{
		/**
		 * TODO:
		 * */
		//Decode the High 6 bits [31-25] to opcode
		//Get Instruction and convert anothers bits, by instruction type

		BitDecoder decoder = new BitDecoder();

		Integer opcode = decoder.getRangeBits(raw, 25, 31);
		
		Instruction inst = new Instruction();
		inst.setOpcode(opcode);
		inst.setRawinstruction(decoder.getRangeBits(raw, 0, 31));
		
		return inst;
		
		/*
		try {
			
			switch (opcode) {
			case OPCODE_RTYPE:
				InstructionR instr = new InstructionR();
				instr.setOpcode(opcode);
				instr.setTypeName("R-Type");
				instr.setRs(decoder.getRangeBits(raw, 20, 25));
				instr.setRt(decoder.getRangeBits(raw, 15, 20));
				instr.setRd(decoder.getRangeBits(raw, 10, 15));
				instr.setShamt(decoder.getRangeBits(raw, 5, 10));
				instr.setFunct(decoder.getRangeBits(raw, 0, 5));
			
				return instr;
				
			case OPCODE_ITYPE:
				InstructionI instI = new InstructionI();
				instI.setOpcode(opcode);
				instI.setTypeName("I-Type");
				instI.setRs(decoder.getRangeBits(raw, 20, 25));
				instI.setRt(decoder.getRangeBits(raw, 15, 20));
				instI.setImmediate(decoder.getRangeBits(raw, 0, 15));
				
				return instI;
				
			case OPCODE_JTYPE:
				InstructionJ instJ = new InstructionJ();
				instJ.setOpcode(opcode);
				instJ.setTypeName("J-Type");
				instJ.setTargetAddress(decoder.getRangeBits(raw, 0, 25));
				
				return instJ;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;*/
	}

}
