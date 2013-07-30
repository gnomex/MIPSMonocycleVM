package br.unioeste.mips.logicalstates;

import java.util.ArrayList;
import java.util.List;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.abstraction.InstructionDecodeState1;
import br.unioeste.mips.logicalstates.abstraction.InstructionFetchState0;

	/**
	 * The Machine States logic
	 * 	identify states and make changes on VM
	 * */

public class ControlStateUnit {

	private Datapath mipsDatapath;	//MIPS Multicycle datapath
	
	private List<Command> commands = new ArrayList<Command>();
	
	private void whoIsNext()	{
		
	}
	
	/*
	 * Example
	 * */
	private void lol()	{
		commands.add(new InstructionFetchState0(mipsDatapath));
		commands.add(new InstructionDecodeState1(mipsDatapath));		
	}
	
	private void execute()	{
		try{
			for	(Command cm : commands)	{
				cm.performs();
				
			}
		}catch (Exception e)	{
			e.printStackTrace();
		}
	}
}
