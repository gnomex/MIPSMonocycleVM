package br.unioeste.mips.components.memory;

import java.util.ArrayList;

import br.unioeste.mips.common.exception.MemoryPermissionDenied;
import br.unioeste.mips.common.instruction.Instruction;
import br.unioeste.mips.common.loader.ParserFileTXT;

public class DataMemory {

	private Boolean MEMWRITE = Boolean.FALSE;
	private Boolean MEMREAD = Boolean.FALSE;

	private ArrayList<Integer> datamemory;
	private ArrayList<Instruction> instructions;

	private Integer addressIndex;

	public void setAdrress(Integer adrressIndex)	{
		this.addressIndex = adrressIndex;
	}

	public DataMemory()	{
		datamemory = new ArrayList<Integer>();
		//instructions = new ArrayList<Instruction>();
		
		ParserFileTXT parser = new ParserFileTXT();
		try {
			instructions = (ArrayList<Instruction>) parser.loadFile();
			System.out.println("--#Loaded " + instructions.size() + " Instructions from file");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can't load Instructions - Damn");
		}
		
		System.out.println("Memory initialized\n--Instruction range protection: Done\n--Data segment: Done");
	}
	
	
	public Instruction getInstruction()	throws Exception{

		try {

			if	(MEMWRITE)	{
				return instructions.get(this.addressIndex);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMREAD is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException();
		}	
	}

	public Integer getData()	throws Exception{

		try {

			if	(MEMWRITE)	{
				return datamemory.get(this.addressIndex);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMREAD is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException();
		}	
	}

	public void push(Instruction element)	throws Exception{

		try {

			if	(MEMREAD)	{
				instructions.add(this.addressIndex, element);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMWRITE is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException(this.addressIndex);
		}

	}
	public void push(Integer element)	throws Exception{
		try {
			if	(MEMREAD)	{
				datamemory.add(this.addressIndex, element);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMWRITE is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException(this.addressIndex);
		}
	}

	public void setMEMWRITE(Boolean mEMWRITE) {
		MEMWRITE = mEMWRITE;
	}

	public void setMEMREAD(Boolean mEMREAD) {
		MEMREAD = mEMREAD;
	}

	
	
}
