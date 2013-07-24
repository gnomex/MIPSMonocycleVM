package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class WriteBackState4  implements Command{

	private Datapath dataPath;

	public WriteBackState4(Datapath datapath)	{
		this.dataPath = datapath;
	}
	
	public void performs() {
		dataPath.setSelectREGDST(new Integer(0));
		dataPath.setREGWRITE(Boolean.TRUE);
		dataPath.setSelectMEMTOREG(new Integer(0));
	}

}
