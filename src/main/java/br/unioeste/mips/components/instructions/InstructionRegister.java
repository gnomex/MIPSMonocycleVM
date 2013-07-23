package br.unioeste.mips.components.instructions;

import br.unioeste.mips.components.registers.Register;

public class InstructionRegister {

	private Register r3126;	//rs
	private Register r2521;	//rt
	private Register r2016;	//rd
	private Register r150;	//Shamt, funct, imm
	
	public Register getR3126() {
		return r3126;
	}
	public void setR3126(Register r3126) {
		this.r3126 = r3126;
	}
	public Register getR2521() {
		return r2521;
	}
	public void setR2521(Register r2521) {
		this.r2521 = r2521;
	}
	public Register getR2016() {
		return r2016;
	}
	public void setR2016(Register r2016) {
		this.r2016 = r2016;
	}
	public Register getR150() {
		return r150;
	}
	public void setR150(Register r150) {
		this.r150 = r150;
	}
	
	
	
}
