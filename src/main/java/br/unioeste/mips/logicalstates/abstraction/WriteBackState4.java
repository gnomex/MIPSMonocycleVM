package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class WriteBackState4  implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;

	public WriteBackState4(Datapath datapath, ControlUnit controlUnit)	{
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
	}
	
	public void performs() {
		
		controlUnit.setREGDST(0);
		controlUnit.setREGWRITE(Boolean.TRUE);
		controlUnit.setMEMTOREG(1);
				
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
	}

}
