package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class JumpCompletionState9  implements Command{

	private Datapath dataPath;

	private ControlUnit controlUnit;
	
	public JumpCompletionState9(Datapath datapath, ControlUnit controlUnit)	{
		
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
		
	}
	
	public void performs() {
		
		controlUnit.setPCWRITE(1);
		controlUnit.setPCSOURCE(2);
				
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
	}

}
