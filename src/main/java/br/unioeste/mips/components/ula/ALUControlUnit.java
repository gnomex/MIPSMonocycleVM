package br.unioeste.mips.components.ula;

import static br.unioeste.mips.util.Util.*;

/**
 * Unidade de controle da ALU
 * Recebe ALUop da unidade de controle
 * Se for tipo R recebe também o funct
 * 
 * Jr flag- identifica instrução formato Jr
 * */	

public class ALUControlUnit {

	private Integer raw6bits;
	private Integer ALUOPFLAG;
	private Integer ALUOP;

	public void setRaw6bits(Integer rawbit)	{
		this.raw6bits = rawbit;
	}

	public Integer getALUOPERATION()	{
		return this.ALUOP;
	}

	public void setALUOPFALG(Integer ALUOPFLAG)	{
		this.ALUOPFLAG = ALUOPFLAG;
	}
	
	/*
	 * identifies the mathematical operation
	 * 
	 * */
	public void decode()	{
		switch (ALUOPFLAG) {
		case ADD:
			ALUOP = ADD;

			break;
		case SUB:
			ALUOP = SUB;

			break;
		case OR:
			ALUOP = OR;

			break;
		case AND:
			ALUOP = AND;

			break;
		default:
			break;
		}
	}

}
