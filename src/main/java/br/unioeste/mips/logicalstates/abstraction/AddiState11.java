package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

	/**
	 * State implements addi instruction
	 * 	I-Type
	 * */

public class AddiState11  implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;
	
	public AddiState11(Datapath datapath, ControlUnit controlUnit)	{
		
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
		
	}

	public void performs() {
		
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
	}

}
