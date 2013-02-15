package br.unioeste.mips.test.common.mux;

import org.junit.Test;

import br.unioeste.mips.common.mux.Mux;

import junit.framework.*;


public class MuxTest extends TestCase{
	
	@Test
	public final void testPort0(){
		
		Integer expected	=	new Integer(9);
		
		Mux mux	=	new Mux();
		mux.setCurrentDataPortA(new Integer(9));
		mux.setCurrentDataPortB(new Integer(7));
		//Select as default 0
		
		assertEquals(expected, mux.getData());
	}
	
	@Test
	public final void testPort1()	{
		
		Integer expected	=	new Integer(7);
		
		Mux mux	=	new Mux();
		mux.setCurrentDataPortA(new Integer(9));
		mux.setCurrentDataPortB(new Integer(7));
		mux.setSelect(new Integer(1));	//Change select
		
		assertEquals(expected, mux.getData());
	}

}
