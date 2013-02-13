package br.unioeste.mips.components.ula;

import static br.unioeste.mips.util.Global.*;

public class ULA {

	private Integer rawInput1	=	ZERO;
	private Integer rawInput2	=	ZERO;
	private Integer result	=	ZERO;

	private Boolean zeroFlag= new Boolean(false);	//Default

	public void execute(Integer ulaOperation){


		switch (ulaOperation) {

		case ADD:
			result = rawInput1 + rawInput2;
			break;

		case SUB:
			result = rawInput1 - rawInput2;
			zeroFlag	=	Boolean.TRUE;
			break;

		case AND:
			this.result = rawInput1 & rawInput2;
			break;

		case OR:
			result = rawInput1 | rawInput2;
			break;
		}		

	}



}
