package br.unioeste.mips.common.instruction;

import static br.unioeste.mips.util.Global.OPCODE_RTYPE;

public class InstructionR extends Instruction{

	private Integer rs;
	private Integer rd;
	private Integer rt;
	private Integer shamt;
	private Integer funct;
	
	public InstructionR()	{
		this.setOpcode(OPCODE_RTYPE);
	}
	
	public Integer getRs() {
		return rs;
	}
	public void setRs(Integer rs) {
		this.rs = rs;
	}
	public Integer getRd() {
		return rd;
	}
	public void setRd(Integer rd) {
		this.rd = rd;
	}
	public Integer getRt() {
		return rt;
	}
	public void setRt(Integer rt) {
		this.rt = rt;
	}
	public Integer getShamt() {
		return shamt;
	}
	public void setShamt(Integer shamt) {
		this.shamt = shamt;
	}
	public Integer getFunct() {
		return funct;
	}
	public void setFunct(Integer funct) {
		this.funct = funct;
	}
	
	
	
}
