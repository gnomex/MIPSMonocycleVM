package br.unioeste.mips.components.memory;

import static br.unioeste.mips.util.Util.ZERO;

public class TemporaryMemory {

	private Integer rawValue	=	ZERO;

	public Integer getRawValue() {
		return rawValue;
	}

	public void setTemporaryValue(Integer rawValue) {
		this.rawValue = rawValue;
	}
	
}
