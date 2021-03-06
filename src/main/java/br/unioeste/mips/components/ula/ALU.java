package br.unioeste.mips.components.ula;

import static br.unioeste.mips.util.Util.*;

//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;

//import br.unioeste.mips.components.registers.Registers;

public class ALU {

	private Integer rawInput1	=	ZERO;
	private Integer rawInput2	=	ZERO;
	private Integer result	=	ZERO;

	private Integer ulaOperation = ADD;	//Default, by randon :P
	
	private Boolean zeroFlag= new Boolean(false);	//Default 

	//private Logger logger = Logger.getLogger(Registers.class);
		
	public void execute(){
		System.out.println("  ~> ALU.execute");
		//logger.debug("ULA receive: " + ulaOperation );
		
		this.zeroFlag = Boolean.FALSE;	//Force false
		
		switch (ulaOperation) {

		case ADD:
			result = rawInput1 + rawInput2;
		//	logger.info("ADD op");
			break;

		case SUB:
			result = rawInput1 - rawInput2;
			verifyZeroFlag(result);
		//	logger.info("SUB op");
			break;

		case AND:
			this.result = rawInput1 & rawInput2;
		//	logger.info("AND op");
			break;

		case OR:
			result = rawInput1 | rawInput2;
		//	logger.info("OR op");
			break;
		}		
		
		System.out.println("  --> Result is: " + result);
		
	}

	private void verifyZeroFlag(Integer result)	{
		
		if(result.equals(new Integer(ZERO))){
			this.zeroFlag	=	Boolean.TRUE;
		}
		
		System.out.println(" -- ALU Zero flag: " + zeroFlag);
	}
	
	public void setRawInput1(Integer rawInput1) {
		System.out.println("=>New Data input 1 on ULA, value: " + rawInput1);
		this.rawInput1 = rawInput1;
	}

	public void setRawInput2(Integer rawInput2) {
		System.out.println("=>New Data input 2 on ULA, value: " + rawInput2);
		this.rawInput2 = rawInput2;
	}

	public Integer getResult() {
		return result;
	}

	public Boolean isActiveZeroFlag() {
		return zeroFlag;
	}

	public void setOperation(Integer aluOperation) {
		this.ulaOperation = aluOperation;
	}
	
}
