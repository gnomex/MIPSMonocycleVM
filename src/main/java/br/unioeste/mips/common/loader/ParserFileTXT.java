package br.unioeste.mips.common.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import br.unioeste.mips.common.bit.BitDecoder;
import br.unioeste.mips.common.exception.InstructionException;
import br.unioeste.mips.common.instruction.Instruction;
import br.unioeste.mips.common.instruction.InstructionDecoder;

import static br.unioeste.mips.util.Util.FILEREADER;
import static br.unioeste.mips.util.Util.INSTRUCTIONSIZE;


public class ParserFileTXT implements ParserFactory {

	private BufferedReader filereader;
	private ArrayList<Instruction> instructions;
	
	private Logger logger = Logger.getLogger(ParserFileTXT.class);



	public void loadFile() throws FileNotFoundException	{

		logger.setLevel(Level.INFO);
		logger.info("Initializing txt parser");

		filereader	=	new BufferedReader(new FileReader(FILEREADER + ".txt"));

		try{

			String bufferReader;

			while((	bufferReader	=	filereader.readLine()	)	!=	null)	{
				try{

					bufferReader	=	formater(bufferReader);
					int current	=	BitDecoder.toBinari(bufferReader);
					//InstructionDecoder.decode(int);

				}catch (Exception e) {
					logger.error("Error: " + e.getMessage());	//Logger the error	
					continue;
				}
			}

		}catch (Exception e) {
			// TODO: handle exception
		}
	}


	private String formater(String bufferReader)	throws InstructionException	{

		String formated	=	bufferReader.trim();	//Remove white spaces
		
		if	(formated.length()	==	INSTRUCTIONSIZE){

			return formated;

		}else	{
			
			throw new InstructionException("Instruction don't have 32 bits, check de foo file!!!", logger);
		}

	}


	public List<Instruction> parse() {
		// TODO Auto-generated method stub
		return null;
	}

}
