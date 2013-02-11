package br.unioeste.mips.common.loader;

public class ExmpleParser {

	/**
	 * This example return a instance of ParserFile
	 * 
	 * 
	 */
	public ParserFactory getParser(String type) throws Exception	{
		
		Class claszz = Class.forName("ParserFile" + type);
		return (ParserFactory)	claszz.newInstance();

	}
	
}