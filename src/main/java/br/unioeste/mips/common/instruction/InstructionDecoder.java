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
		
		try {
			
			switch (opcode) {
			case OPCODE_RTYPE:
				InstructionR instr = new InstructionR();
				instr.setOpcode(opcode);
				instr.setTypeName("R-Type");

				
			case OPCODE_ITYPE:
				InstructionI instI = new InstructionI();
				instI.setOpcode(opcode);
				instI.setTypeName("I-Type");
				
			case OPCODE_JTYPE:
				InstructionJ instJ = new InstructionJ();
				instJ.setOpcode(opcode);
				instJ.setTypeName("J-Type");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
