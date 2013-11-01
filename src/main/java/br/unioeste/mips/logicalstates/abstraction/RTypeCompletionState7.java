package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class RTypeCompletionState7  implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;
	
	public RTypeCompletionState7(Datapath datapath, ControlUnit controlUnit)	{
		
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
		
	}

	public void performs() {

		controlUnit.setREGDST(1);
		controlUnit.setREGWRITE(Boolean.TRUE);
		controlUnit.setMEMTOREG(0);
		
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
	}

}
