package br.unioeste.mips.test.components.circuit;

import junit.framework.TestCase;

import org.junit.Test;

import br.unioeste.mips.components.circuit.NOT;

public class NOTTest extends TestCase{

	@Test
	public void testDoNot() {
		Integer expected	=	new Integer(0);
		
		NOT notcircuit	=	new NOT();
		Integer tester	=	new Integer(1);
		
		assertEquals(expected, notcircuit.doNot(tester));
		
	}

}
