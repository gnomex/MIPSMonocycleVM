package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

	/**
	 * State 0
	 * 	Instrucion Fetch
	 * */

public class InstructionFetchState0 implements Command{

	private Datapath dataPath;
	
	public InstructionFetchState0(Datapath dataPathParent)	{
		this.dataPath = dataPathParent;
	}
	
	public void performs() {
		dataPath.setSelectMEMTOREG(new Integer(1));
		dataPath.setSelectALUSRCA(new Integer(0));
		dataPath.setSelectIORD(new Integer(0));
		dataPath.setIRWRITE(Boolean.TRUE);
		dataPath.setSelectALUSRCB(new Integer(1));
		dataPath.setPCWRITE(new Integer(1));
		dataPath.setALUOP(new Integer(0));
	}

	
	
}
