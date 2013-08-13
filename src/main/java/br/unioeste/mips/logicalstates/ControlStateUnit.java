package br.unioeste.mips.logicalstates;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.mips.components.ControlUnit;
import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.abstraction.BranchCompletionState8;
import br.unioeste.mips.logicalstates.abstraction.ExecutionState6;
import br.unioeste.mips.logicalstates.abstraction.InstructionDecodeState1;
import br.unioeste.mips.logicalstates.abstraction.InstructionFetchState0;
import br.unioeste.mips.logicalstates.abstraction.JumpCompletionState9;
import br.unioeste.mips.logicalstates.abstraction.MemoryAcessLoadState3;
import br.unioeste.mips.logicalstates.abstraction.MemoryAcessStoreState5;
import br.unioeste.mips.logicalstates.abstraction.MemoryAddressState2;
import br.unioeste.mips.logicalstates.abstraction.MemoryLDIState12;
import br.unioeste.mips.logicalstates.abstraction.RTypeCompletionState7;
import static br.unioeste.mips.util.Util.*;

/**
 * The Machine States logic
 * 	identify states and make changes on VM
 * */

public class ControlStateUnit {

	private Datapath mipsDatapath;	//MIPS Multicycle datapath

	private ControlUnit controlUnit;

	public ControlStateUnit() {
		mipsDatapath = new Datapath();
		controlUnit = new ControlUnit();
	}

	public void startVM()	{
		
		/**
		 * 
		 * */
		/*
		while (mipsDatapath.getMemorySnapshot().haveInstructions()) {
			this.whoIsNext();
		}*/
		this.whoIsNext();
		
	}
	
	private void whoIsNext()	{

		ArrayList<Command> commands = new ArrayList<Command>();

		/**
		 * Default States
		 * */
		commands.add(new InstructionFetchState0(mipsDatapath, controlUnit));
		commands.add(new InstructionDecodeState1(mipsDatapath, controlUnit));

		//POG - Execute only 2 first states
		this.execute(commands);
/*
		switch (controlUnit.getOPCODE()) {
		case OPCODE_RTYPE:
			commands.add(new ExecutionState6(mipsDatapath, controlUnit));
			commands.add(new RTypeCompletionState7(mipsDatapath, controlUnit));
			this.execute(commands);
			break;

		case OPCODE_ITYPE:

			commands.add(new MemoryAddressState2(mipsDatapath, controlUnit));

			switch (key) {
			case LW:
				commands.add(new MemoryAcessLoadState3(mipsDatapath, controlUnit));

			case SW:
				commands.add(new MemoryAcessStoreState5(mipsDatapath, controlUnit));

			case LDI;
				commands.add(new MemoryLDIState12(mipsDatapath, controlUnit));
			}

			this.execute(commands);

			break;

		case OPCODE_JTYPE:
			commands.add(new JumpCompletionState9(mipsDatapath, controlUnit));


			this.execute(commands);

			break;

		case BEQ:

			commands.add(new BranchCompletionState8(mipsDatapath, controlUnit));
			
			break;

		default:
			throw new Exception("-- Error, no have a state to execute!!!");
			break;
		}
*/
	}

	private void execute(ArrayList<Command> commands)	{
		try{
			for	(Command cm : commands)	{
				cm.performs();

			}

			commands.clear();

		}catch (Exception e)	{
			e.printStackTrace();
		}
	}
	
	/*	Invoker
	 * ========================================================================
	 * */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ControlStateUnit stateVm = new ControlStateUnit();

					stateVm.startVM();
					
					System.out.println("Work!");

				} catch (Exception e) {
					System.out.println("Problems :(\n\n\n###########################");
					e.printStackTrace();
				}
			}
		});
	}

}
