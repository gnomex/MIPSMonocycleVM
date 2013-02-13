package br.unioeste.mips.common.shift;

import static br.unioeste.mips.util.Global.ZERO;
import static br.unioeste.mips.util.Global.LEFT;
import static br.unioeste.mips.util.Global.RIGHT;

public class Shifter {

	public static Integer shift(Integer rawPort, Integer offset, Integer direction)	{
		
		Integer result	=	new Integer(ZERO);
		
		switch (direction) {
		case LEFT:
			
			result	=	(rawPort << offset);
			
			break;
		case RIGHT:
			
			result	=	(rawPort >> offset);
			
			break;
		}
		
		return result;
	}
	
}
