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

		System.out.println(" -- Get a instruction, at index: " + addressIndex);

		if	(MEMREAD)	{
			return instructions.get(this.addressIndex);
		} else	{
			throw new MemoryPermissionDenied("Flag MEMREAD is not active!");
		}

	}

	public Integer getData()	throws Exception{
		
		System.out.println(" -- Get a data, at index: " + addressIndex);

		if	(MEMREAD)	{
			return datamemory.get(this.addressIndex);
		} else	{
			throw new MemoryPermissionDenied("Flag MEMREAD is not active!");
		}

	}

	public void push(Instruction element)	throws Exception{

		if	(MEMWRITE)	{
			instructions.add(this.addressIndex, element);
		} else	{
			throw new MemoryPermissionDenied("Flag MEMWRITE is not active!");
		}
	}
	public void push(Integer element)	throws Exception{
		if	(MEMWRITE)	{
			datamemory.add(this.addressIndex, element);
		} else	{
			throw new MemoryPermissionDenied("Flag MEMWRITE is not active!");
		}

	}

	public void setMEMWRITE(Boolean mEMWRITE) {
		MEMWRITE = mEMWRITE;
	}

	public void setMEMREAD(Boolean mEMREAD) {
		MEMREAD = mEMREAD;
	}

	public Boolean haveInstructions()	{
		/**
		 * @WARNING: Not tested Yet!!! Maybe work.
		 * */
		if (addressIndex <= instructions.size())	return Boolean.TRUE;
		return Boolean.FALSE;
	}


}
