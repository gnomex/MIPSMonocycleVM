package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;
import br.unioeste.mips.logicalstates.ControlStateUnit;

	/**
	 * State 0
	 * 	Instrucion Fetch
	 * */

public class InstructionFetchState0 implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;
	
	public InstructionFetchState0(Datapath dataPathParent, ControlUnit currentUnit)	{
		this.dataPath = dataPathParent;
		this.controlUnit = currentUnit;
	}
	
	public void performs() {
		controlUnit.setMEMTOREG(new Integer(1));
		controlUnit.setALUSRCA(new Integer(0));
		controlUnit.setIORD(new Integer(0));
		controlUnit.setIRWRITE(Boolean.TRUE);
		controlUnit.setALUSRCB(new Integer(1));
		controlUnit.setPCWRITE(new Integer(1));
		controlUnit.setALUOP(new Integer(0));
		
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
	}

	
	
}
