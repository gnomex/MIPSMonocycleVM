package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class ExecutionState6  implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;

	public ExecutionState6(Datapath datapath, ControlUnit controlUnit)	{
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
	}
	
	public void performs() {
		
	}

}
