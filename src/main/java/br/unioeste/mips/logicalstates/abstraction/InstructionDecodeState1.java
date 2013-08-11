package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class InstructionDecodeState1 implements Command{

	private Datapath dataPath;
	
	private ControlUnit controlUnit;
	
	public InstructionDecodeState1(Datapath dataPathParent, ControlUnit controlUnit)	{
		this.dataPath = dataPathParent;
		this.controlUnit = controlUnit;
	}
	
	
	public void performs() {

	}

}
