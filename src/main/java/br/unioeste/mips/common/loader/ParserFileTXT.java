package br.unioeste.mips.common.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import br.unioeste.mips.common.bit.BitDecoder;
import br.unioeste.mips.common.exception.InstructionException;
import br.unioeste.mips.common.instruction.Instruction;
import br.unioeste.mips.common.instruction.InstructionDecoder;
import static br.unioeste.mips.util.Util.FILEREADER;
import static br.unioeste.mips.util.Util.INSTRUCTIONSIZE;


public class ParserFileTXT {

	private BufferedReader filereader;
	private ArrayList<Instruction> instructions;
	
	private InstructionDecoder instDecoder;
	//private Logger logger = Logger.getLogger(ParserFileTXT.class);

	public ParserFileTXT()	{
		instDecoder = new InstructionDecoder();
		instructions = new ArrayList<Instruction>();
	}

	public List<Instruction> loadFile() throws Exception	{


		filereader	=	new BufferedReader(new FileReader(FILEREADER + ".txt"));

		try{

			String bufferReader;

			while((	bufferReader	=	filereader.readLine()	)	!=	null)	{
				try{

					bufferReader	=	formater(bufferReader);
					int current	=	BitDecoder.toBinari(bufferReader);
					
					instructions.add(instDecoder.decode(new Integer(current)));

				}catch (Exception e) {
					//logger.error("Error: " + e.getMessage());	//Logger the error	
					continue;
				}
			}
			
			return instructions;

		}catch (Exception e) {
			throw new Exception("Fail to try load file text");
		}
	}


	private String formater(String bufferReader)	throws InstructionException	{

		String formated	=	bufferReader.trim();	//Remove white spaces
		
		if	(formated.length()	==	INSTRUCTIONSIZE){

			return formated;

		}else	{
			
			throw new InstructionException("Instruction don't have 32 bits, check de foo file!!!");
		}

	}

}
