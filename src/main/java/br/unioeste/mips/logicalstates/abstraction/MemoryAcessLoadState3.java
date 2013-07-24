package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class MemoryAcessLoadState3  implements Command{

	private Datapath dataPath;

	public MemoryAcessLoadState3(Datapath datapath)	{
		this.dataPath = datapath;
	}
	
	public void performs() {
		dataPath.setMEMREAD(Boolean.TRUE);
		dataPath.setSelectIORD(new Integer(1));
	}
	

}
