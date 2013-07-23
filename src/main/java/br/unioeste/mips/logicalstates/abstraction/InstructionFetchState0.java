package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class InstructionFetchState0 implements Command{

	private Datapath dataPath;
	
	public InstructionFetchState0(Datapath dataPathParent)	{
		this.dataPath = dataPathParent;
	}
	
	public void performs() {
		/*
		 * 
		 *In this step, the instruction in memory pointed to by the Program Counter (PC) is loaded  from 
          memory.  The instruction is read and stored  in  the  Instruction  Register  (IR)  and  the  PC  is 
          incremented by four. In this step the processor does not know what the instruction  is  or  does. 
                The operation of incrementing the PC by 4 requires setting the ALUSrcA signal to  0  (to  send 
                the PC to the ALU), and ALUOp to 00 (to set the ALU to perform addition).   The  operation 
                of sending the PC to the memory requires asserting the control signals MemRead and  IRWrite, 
                and setting IorD to 0 to select the PC as the source of the  address.  Finally,  the  operation  of 
                storing  the  incremented   instruction  address into  the  PC  requires  asserting  PCWrite.  The 
                increment of the PC and the instruction memory access can occur in parallel.  The new value of 
                the PC is not visible until the next clock cycle.
		 * 
		 * */
	}

	
	
}
