package br.unioeste.mips.util;

public final class Util {

	public static final int ZERO	=	0x00000000;
	public static final int BITMASK	=	0x00000001;
	
	public static final int PC_OFFSET	=	1;
	
	public static final int INSTRUCTIONSIZE	=	32;
	public static final int BASE_INVERSOR	=	0;
	
	/*
	 * Directions
	 * */
	public	static final int RIGHT	=	0;
	public static final int LEFT	=	1;
	
	
	public static final String FILEREADER	=	"./input_files/inputfile";
	
	/*
	 * Instructions type
	 * */
	public static final int OPCODE_ITYPE	=	0x00000002;
	public static final int OPCODE_JTYPE	=	0x00000020;
	public static final int OPCODE_RTYPE	=	0x00000000;
	/*
	 * Instructions
	 * */
	public static final int ADD	=	0x00000020; //100000 - 32
	public static final int SUB	=	0x00000022; //100010 - 34
	public static final int AND	=	0x00000024; //100100 - 36
	public static final int OR	=	0x00000025; //100101 - 37
	/*
	public static final int ADDi;
	public static final int ANDi;
	public static final int ORi;
	public static final int LUI;
	public static final int LW;
	public static final int SW;
	public static final int BEQ;
	public static final int BNE;
	public static final int j;
	public static final int jr;
	*/
	
	/*
	 * Loggers
	 * */
	public static final String LOADERLOG	=	"loaderlog.log";
	public static final String REGSBASELOG	=	"regslog.log";
}
