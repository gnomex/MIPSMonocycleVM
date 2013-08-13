package br.unioeste.mips.components.registers;

import java.util.ArrayList;

import static br.unioeste.mips.util.Util.ZERO;


/**
 * Registers base, 32 regs - 32 bits
 * 
 * @Default regs value: ZERO
 * 	 	
 * – $zero (0) : Guarda a constante 0
		– $at (1): Reservado para o montador
		– $v0, $v1 (2, 3): Usado na avaliação de expressões e p/ guardar o resultado da avaliação de uma função
		– $a0, $a1, $a2, $a3 (4, 5, 6, 7) Usado como argumento
		– $t0, $t1, $t2, $t3, $t4, $t5, $t6, $t7 (8, 9, 10, 11, 12, 13,14, 15): Armazena valores temporários (seus valores
		não precisam ser preservados nas chamadas a	procedimento)
		– $s0, $s1, $s2, $s3, $s4, $s5, $s6, $s7 (16, 17,18, 19, 20, 21, 22, 23): Armazena valores
		temporários (seus valores devem ser	preservados nas chamadas a procedimento)
		– $t8, $t9 (24, 25): Armazena valores temporários (seus valores não precisam ser preservados nas chamadas a procedimento)
		– $k0, $k1 (26, 27): Reservado para o Kernel do Sistema Operacional
		– $gp (28): Ponteiro para área global
		– $sp (29): Apontador de pilha
		– $fp (30): Apontador de quadro
		– $ra (31): Endereço de retorno(usado nas chamadas a procedimento
		
 * */

public class Registers {

	private ArrayList<Register> dataregisters;
	
	private Boolean regWrite	=	new Boolean(Boolean.FALSE);	//Default
	
	private Integer RS	=	ZERO;	//Read Register 1
	private Integer RD	=	ZERO;	//WriteRegister
	private Integer RT	=	ZERO;	//Read Register 2
	
	//private Logger logger = Logger.getLogger(Registers.class);
	
	
	public Registers()	{
		dataregisters	=	new ArrayList<Register>(32);
		this.__initRegister();
		
		//logger.setLevel(Level.INFO);
		//logger.info("Initializing Regs base");
		
	}
	
	
	public void setRS(Integer rS) {
		System.out.println("Registers.setRS");
		RS = rS;
	}

	public void setRD(Integer rD) {
		System.out.println("Registers.setRD");
		RD = rD;
	}

	public void setRT(Integer rT) {
		System.out.println("Registers.setRT");
		RT = rT;
	}

	public void setWriteData(Integer value)	{
		
		System.out.println("Registers.setWriteData, Value: " + value);
		
		Register reg = dataregisters.get(this.RD);
		reg.setValue(value);

		//Write back on list
		dataregisters.add(this.RD, reg);
		
	}

	public Integer getALUOp1(){
		return dataregisters.get(this.RS).getValue();
	}
	
	public Integer getALUOp2(){
		return dataregisters.get(this.RT).getValue();
	}
	

	private void __initRegister()	{
		
		try{
			
			for(int i=0; i<32; i++)	{
				Register reg	=	new Register();
				reg.setName("$[ " + i + " ]");
				reg.setValue(ZERO);	//Default value
				reg.setWritePermission(Boolean.FALSE);
				
				dataregisters.add(reg);		
			}
			
			System.out.println("All register are initialized");
			//logger.info("Regs initialized!");
			
		}catch (Exception e) {
			//logger.error("Error: " + e.getMessage());	//Logger the error	
		}	
	}


	public void setRegWrite(Boolean regWrite) {
		this.regWrite = regWrite;
	}
	
	public void makeSnapshot()	{
		
		System.out.println(" ### Registers Snapshot ###");
		for(Register reg : dataregisters)	{
			reg.makeSnapshot();
		}

		System.out.println(" - Current\n  RS: " + RS + "\n  RT: " + RT + "\n  RD: " + RD + "\n  RegWrite: " + regWrite);
		System.out.println("\n### End of registers snapshot");
		
	}
	
}
