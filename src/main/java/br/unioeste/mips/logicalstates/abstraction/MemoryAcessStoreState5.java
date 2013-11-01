package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class MemoryAcessStoreState5  implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;

	public MemoryAcessStoreState5(Datapath datapath, ControlUnit controlUnit)	{
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
	}
	
	public void performs() {
		
		controlUnit.setMEMWRITE(Boolean.TRUE);
		controlUnit.setIORD(1);
				
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
	}

}
