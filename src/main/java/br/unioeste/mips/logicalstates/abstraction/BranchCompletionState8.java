package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class BranchCompletionState8  implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;

	public BranchCompletionState8(Datapath datapath, ControlUnit controlUnit)	{
		
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
		
	}
	
	public void performs() {

		controlUnit.setALUSRCA(1);
		controlUnit.setALUSRCB(0);
		controlUnit.setALUOP(1);
		controlUnit.setPCWRITECOND(1);
		controlUnit.setPCSOURCE(1);
		
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
	}

}
