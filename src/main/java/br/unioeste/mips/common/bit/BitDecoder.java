package br.unioeste.mips.common.bit;

import static br.unioeste.mips.util.Global.BITMASK;
import static br.unioeste.mips.util.Global.ZERO;

/**
 *Classe responsavel por transformar a instruçao de String para byte 
 * Utiliza operação com bits para realizar a covnersão
 * */

public class BitDecoder {

	
	/**
	 * Logic to turn on a specific bit
	 * */
	private Integer setbit_32(int whichBit, int rawCode)	{
		
		int set= BITMASK <<(whichBit - 1);
		rawCode = (rawCode | set );
		
		return new Integer(rawCode);
	}
	/**
	 * Translate string to binary number
	 * */
	public int toBinari(String rawInstruction)	{
		
		int raw = ZERO;
		int decounter = rawInstruction.length();
		
		for(int i=0; i< rawInstruction.length(); i++){
			
			if(rawInstruction.charAt(i) == '1'){
				raw = setbit_32( decounter , raw);
			}
			decounter--;
		}
		return raw;
	}
	
}
