package br.unioeste.mips.components.ula;

public class ULA {

	private int reg1;
	private int reg2;
	private int result;
	private Boolean zero= new Boolean(false);

	public int aluOperation;

	private String operacao; //Funct em string - Utilizado para apresentar na GUI

	public static final int add = 0x00000020; //100000 - 32
	public static final int sub = 0x00000022; //100010 - 34
	public static final int and = 0x00000024; //100100 - 36
	public static final int or = 0x00000025; //100101 - 37


	public void executeoperation(){


		switch (this.aluOperation) {

		case add:
			this.result = reg1 + reg2;
			this.operacao = "ADD";
			break;

		case sub:
			this.result = this.reg1 - this.reg2;
			this.operacao = "SUB";
			this.setZeroFlag();
			break;

		case and:
			this.result = reg1 & reg2;
			this.operacao = "AND";
			//this.setZeroFlag();
			break;

		case or:
			this.result = reg1 | reg2;
			this.operacao = "OR";
			//this.setZeroFlag();
			break;
		}		

	}


	public void limparULA(){
		this.reg1 = 0x00000000;
		this.reg2 = 0x00000000;
		this.result = 0x00000000;
		this.operacao = "";
		this.zero=false;

	}
	//Seta o aluop, recebe como parametro a operação
	public void setAluoperation(int _funct){
		this.aluOperation = _funct;
	}
	//Retorna flag zero
	public Boolean getZeroFlag(){

		return this.zero;
	}
	//Seta o zero flag
	private void setZeroFlag(){

		if(this.result == 0){//Se resultado da ALU for 0
			this.zero = true;
		}else{
			this.zero = false;
		}

	}


	public void setData1(int _operando1){
		this.reg1=_operando1;
	}
	public void setData2(int _operando2){
		this.reg2=_operando2;
	}


	//Retorna o resultado da operação
	public int getULAResult() {
		return this.result;
	}
	//Retorna a operçao em sring
	public String getoperacao(){
		String op;
		op = "Op: " + this.operacao + "\n";
		return op;
	}
	//Entrada para string
	public String getoperandostostring(){
		String dados;
		dados = "RegData1: " + this.reg1 + "\nRegData2: "+ this.reg2+"\n";
		return dados;
	}


}
