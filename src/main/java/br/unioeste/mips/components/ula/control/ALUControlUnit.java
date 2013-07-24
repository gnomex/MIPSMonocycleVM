package br.unioeste.mips.components.ula.control;

//import br.unioeste.mips.components.ula.ALU;
import static br.unioeste.mips.util.Util.ADD;

/**
 * Unidade de controle da ALU
 * Recebe ALUop da unidade de controle
 * Se for tipo R recebe também o funct
 * 
 * Jr flag- identifica instrução formato Jr
 * */	

public class ALUControlUnit {

	private Integer raw6bits;
	private Integer ALUOP;	//
	
	/*private ALU ulareference;
	
	public ALUControlUnit(ALU ulareference)	{
		this.ulareference = ulareference;
	}*/
	
	public void setRaw6bits(Integer rawbit)	{
		this.raw6bits = rawbit;
	}
		
	public Integer getALUOPERATION()	{
		return this.ALUOP;
	}
	
	/*
	 * identifies the mathematical operation
	 * 
	 * */
	public void decode()	{
		switch (raw6bits) {
		case ADD:
			ALUOP = ADD;
			
			break;

			/*
			 * all anothers operations
			 * */
		default:
			break;
		}
	}
	
}
