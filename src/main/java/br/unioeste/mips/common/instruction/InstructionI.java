package br.unioeste.mips.common.instruction;

import static br.unioeste.mips.util.Global.OPCODE_ITYPE;

public class InstructionI extends Instruction{

	private Integer rs;	//5 bits
	private Integer rt;	//5 bits
	private Integer immediate;	//16 bits
	
	public InstructionI()	{
		this.setOpcode(OPCODE_ITYPE);
	}

	public Integer getRs() {
		return rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public Integer getRt() {
		return rt;
	}

	public void setRt(Integer rt) {
		this.rt = rt;
	}

	public Integer getImmediate() {
		return immediate;
	}

	public void setImmediate(Integer immediate) {
		this.immediate = immediate;
	}
	
	
}
