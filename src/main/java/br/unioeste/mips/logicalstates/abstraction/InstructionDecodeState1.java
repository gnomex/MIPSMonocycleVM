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
		
		System.out.println("\n\n~> InstructionDecodeState1.performs()\n");
		
		controlUnit.setALUSRCA(new Integer(0));
		controlUnit.setALUSRCB(new Integer(3));
		controlUnit.setALUOP(new Integer(0));
		
		dataPath.setControlUnit(controlUnit);
		dataPath.notifyFlafs();
		
		try {

			dataPath.setRegisters();
			
		} catch (Exception e) {
			System.out.println("\n## => On State 1 - Some Errors:\n");
			e.printStackTrace();
			System.out.println("########## END OF STACK TRACE ON STATE 1 ##########\n");	
		}
		
		System.out.println("########## END OF STATE 1 ##########\n");	
		
		
	}

}
