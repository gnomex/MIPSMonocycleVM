package br.unioeste.mips.components.memory;

import java.util.ArrayList;

import br.unioeste.mips.common.instruction.Instruction;

public class DataMemory {

	private Boolean memWrite;
	private Boolean memRead;
	
	private ArrayList<Integer> datamemory;
	private ArrayList<Instruction> instructions;
	
	private Integer addressWillWrite;
	

	public Instruction getInstruction(Integer adrressIndex)	throws Exception{
		
		try {
			
			return instructions.get(adrressIndex);
			
		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException();
		}	
	}
	
	public Integer getData(Integer adrressIndex)	throws Exception{
		
		try {
			
			return datamemory.get(adrressIndex);
			
		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException();
		}	
	}
	
	public void pushInstruction()	{
		
	}
	
	public void pushData(Integer element, Integer atindex)	{
		
	}
	
}
