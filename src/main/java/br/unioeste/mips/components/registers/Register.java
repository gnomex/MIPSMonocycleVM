package br.unioeste.mips.components.registers;

import static br.unioeste.mips.util.Global.ZERO;

public class Register {

	private String name;
	private String alias;
	
	private Integer value	=	ZERO;
	
	private Boolean writePermission;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Boolean getWritePermission() {
		return writePermission;
	}

	public void setWritePermission(Boolean writePermission) {
		this.writePermission = writePermission;
	}

	
	
	
}
