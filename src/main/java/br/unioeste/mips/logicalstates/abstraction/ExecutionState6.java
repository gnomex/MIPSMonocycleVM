package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class ExecutionState6  implements Command{

	private Datapath dataPath;

	public ExecutionState6(Datapath datapath)	{
		this.dataPath = datapath;
	}
	
	public void performs() {
		dataPath.setSelectALUSRCA(new Integer(1));
		dataPath.setSelectALUSRCB(new Integer(0));
		dataPath.setALUOP(new Integer(2));
		
	}

}
