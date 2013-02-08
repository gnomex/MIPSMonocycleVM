package br.unioeste.mips.components.registers;

import org.apache.log4j.Logger;

public class Register {

	private String name;
	private String alias;
	
	private Integer value=0x00000000;//32 bits	#Dafault value is 0
	
	private Boolean writePermission;
	
	private Integer opAlu1;		//
	private Integer opAlu2;		//
	private Integer regResult;		//
	
	private Logger logger;
	
}
