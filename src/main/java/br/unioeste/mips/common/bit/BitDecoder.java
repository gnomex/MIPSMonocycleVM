package br.unioeste.mips.common.bit;

import static br.unioeste.mips.util.Util.BITMASK;
import static br.unioeste.mips.util.Util.ZERO;

/**
 *Classe responsavel por transformar a instruçao de String para byte 
 * Utiliza operação com bits para realizar a covnersão
 * 
 * Index are 1 to 32
 * 
 * */

public class BitDecoder {

	
	/**
	 * Logic to turnon a specific bit
	 * */
	private static Integer setbit(int whichBit, int rawCode)	{
		
		int set= BITMASK <<(whichBit - 1);
		rawCode = (rawCode | set );
		
		return new Integer(rawCode);
	}
	/**
	 * Translate string to binary number
	 * */
	public static int toBinari(String rawInstruction)	{
		
		int raw = ZERO;
		int decounter = rawInstruction.length();
		
		for(int i=0; i< rawInstruction.length(); i++){
			
			if(rawInstruction.charAt(i) == '1'){
				raw = setbit( decounter , raw);
			}
			decounter--;
		}
		return raw;
	}
	/**
	 * Index is right to left
	 * 
	 * */
	public Integer getRangeBits(Integer instruction, int rawBeginIndex, int rawEndIndex){
		//Index range
		int range	=	(rawEndIndex - rawBeginIndex) + 1;
		
		//shift range size
		int shiftRange	=	rawBeginIndex - 1;
		
		//Mask to get range
		int mask	=	getMaskOfRangebits(range);
		
		//Change mask to range compatible
		mask	=	mask <<(shiftRange);
		int result	=	ZERO;
	
		//Apply mask to get bits
		result	=	(instruction & mask);
		
		//
		result	=	result >>>(shiftRange);	//The operator >>> is because increase 0 on left
		
		return new Integer(result);
	}
	
	/*
	 * Turn on the range first bits
	 * */
	private int getMaskOfRangebits(int range)	{
		
		int result	=	ZERO;
		
		for (int i = 1; i <= range; i++) {
			result	=	setbit(i, result);
		}
		return result;
	}
}
