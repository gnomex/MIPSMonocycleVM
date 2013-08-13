package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class MemoryAddressState2  implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;

	public MemoryAddressState2(Datapath datapath, ControlUnit controlUnit)	{
		this.dataPath = datapath;
		this.controlUnit = controlUnit;
	}
	
	public void performs() {
		//dataPath.setSelectALUSRCA(new Integer(1));
		//dataPath.setSelectALUSRCB(new Integer(2));
		dataPath.setALUOP(new Integer(0));
		
	}

}
