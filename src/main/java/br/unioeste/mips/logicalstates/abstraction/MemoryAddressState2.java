package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class MemoryAddressState2  implements Command{

	private Datapath dataPath;

	public MemoryAddressState2(Datapath datapath)	{
		this.dataPath = datapath;
	}
	
	public void performs() {
		dataPath.setSelectALUSRCA(new Integer(1));
		dataPath.setSelectALUSRCB(new Integer(2));
		dataPath.setALUOP(new Integer(0));
		
	}

}
