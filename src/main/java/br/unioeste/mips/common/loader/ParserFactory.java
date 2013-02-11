package br.unioeste.mips.common.loader;

import java.util.List;

import br.unioeste.mips.common.instruction.Instruction;

public interface ParserFactory {

	public List<Instruction> parse();

}