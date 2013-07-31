package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class MemoryAcessStoreState5  implements Command{

	private Datapath dataPath;

	public MemoryAcessStoreState5(Datapath datapath)	{
		this.dataPath = datapath;
	}
	
	public void performs() {
	}

}
