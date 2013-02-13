package br.unioeste.mips.components.circuit;

import static br.unioeste.mips.util.Global.ZERO;

public class AND implements Circuit{

	public Integer make(Integer rawPortA, Integer rawPortB) {
		
		Integer result	=	new Integer(ZERO);
		
		result	=	(rawPortA & rawPortB);
		
		return result;
	}

}
