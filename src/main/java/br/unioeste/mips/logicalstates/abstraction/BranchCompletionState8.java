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
		// TODO Auto-generated method stub
		
	}

}
