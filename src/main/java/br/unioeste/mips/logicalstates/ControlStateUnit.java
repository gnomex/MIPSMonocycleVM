package br.unioeste.mips.logicalstates;

import java.awt.EventQueue;
import java.util.ArrayList;

import br.unioeste.mips.common.vm.VMInterface;
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
import br.unioeste.mips.logicalstates.abstraction.WriteBackState4;
import static br.unioeste.mips.util.Util.*;

/**
 * The Machine States logic
 * 	identify states and make changes on VM
 * */

public class ControlStateUnit implements VMInterface{

	private Datapath mipsDatapath;	//MIPS Multicycle datapath

	private ControlUnit controlUnit;

	public ControlStateUnit() {
		mipsDatapath = new Datapath();
		controlUnit = new ControlUnit();
	}

	public void startVM()	{

		System.out.println("Initalizing VM States ----------------------------------------------------\n\n");

		while (mipsDatapath.haveMoreInstructions())	{
			this.whoIsNext();
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		mipsDatapath.makeSnapshot();

	}

	private void whoIsNext()	{

		ArrayList<Command> commands = new ArrayList<Command>();

		/**
		 * Default States
		 * */
		commands.add(new InstructionFetchState0(mipsDatapath, controlUnit));
		commands.add(new InstructionDecodeState1(mipsDatapath, controlUnit));

		switch (controlUnit.getOPCODE()) {
		case OPCODE_RTYPE:
			commands.add(new ExecutionState6(mipsDatapath, controlUnit));
			commands.add(new RTypeCompletionState7(mipsDatapath, controlUnit));
			break;

		case LW:
			commands.add(new MemoryAddressState2(mipsDatapath, controlUnit));
			commands.add(new MemoryAcessLoadState3(mipsDatapath, controlUnit));
			commands.add(new WriteBackState4(mipsDatapath, controlUnit));
			break;

		case SW:
			commands.add(new MemoryAddressState2(mipsDatapath, controlUnit));
			commands.add(new MemoryAcessStoreState5(mipsDatapath, controlUnit));
			break;

		case LDI:
			commands.add(new MemoryLDIState12(mipsDatapath, controlUnit));
			break;
			//			}

		case OPCODE_JTYPE:	
			commands.add(new JumpCompletionState9(mipsDatapath, controlUnit));
			break;

		case BEQ:
			commands.add(new BranchCompletionState8(mipsDatapath, controlUnit));
			break;

		default:
			try {
				throw new Exception("-- Error, no have a state to execute!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		/**
		 * The most important line
		 * 	=> Execute!
		 * */
		this.execute(commands);

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
				} catch (Exception e) {
					System.out.println("Problems :(\n\n\n###########################");
					e.printStackTrace();
				}
			}
		});
	}

	public void makeSnapshot() {
		// TODO Auto-generated method stub

	}

}
