package br.unioeste.mips.common.adder;

import static br.unioeste.mips.util.Util.ZERO;

public class Adder {

	public static Integer sum(Integer rawPort1, Integer rawPort2)	{
		
		Integer result	=	new Integer(ZERO);
		
		result	=	(rawPort1	+	rawPort2);
		
		return result;
		
	}
	
}
