package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class MemoryLDIState12 implements Command {

	private Datapath dataPath;
	
	private ControlUnit controlUnit;
	
	public MemoryLDIState12(Datapath datapath, ControlUnit controlunit)	{
		
		this.dataPath = datapath;
		this.controlUnit = controlunit;
		
	}
	
	public void performs() {

		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
	}

	
	
}
