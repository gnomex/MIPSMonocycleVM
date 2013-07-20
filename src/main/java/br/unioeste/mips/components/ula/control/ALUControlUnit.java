package br.unioeste.mips.components.ula.control;

import br.unioeste.mips.components.ula.ALU;

/**
 * Unidade de controle da ALU
 * Recebe ALUop da unidade de controle
 * Se for tipo R recebe também o funct
 * 
 * Jr flag- identifica instrução formato Jr
 * */	

public class ALUControlUnit {

	private Integer raw6bits;
	private Integer ALUOP;
	
	private ALU ulareference;
	
	public ALUControlUnit(ALU ulareference)	{
		this.ulareference = ulareference;
	}
	
	public void setRaw6bits(Integer rawbit)	{
		this.raw6bits = rawbit;
	}
	
	public void setALUOP(Integer ALUOP)	{
		this.ALUOP = ALUOP;
	}
	
	/*
	 * identifies the mathematical operation
	 * 
	 * */
	public void decode()	{
		switch (ALUOP) {
		case 0:
			//do-something
			break;

		default:
			break;
		}
	}
	
}
