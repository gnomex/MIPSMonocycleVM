package br.unioeste.mips.common.bit;

import static br.unioeste.mips.util.Util.BITMASK;
import static br.unioeste.mips.util.Util.ZERO;

/**
 *Classe responsavel por transformar a instruçao de String para byte 
 * Utiliza operação com bits para realizar a covnersão
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
	
	public static Integer getRangeBits(Integer instruction, int rawBeginIndex, int rawEndIndex){
		
		
		
		return null;
	}
	
}
