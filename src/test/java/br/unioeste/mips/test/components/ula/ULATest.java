/**
 * 
 */
package br.unioeste.mips.test.components.ula;

import junit.framework.TestCase;

import org.junit.Test;

import br.unioeste.mips.components.ula.ULA;
import static br.unioeste.mips.util.Util.ADD;
import static br.unioeste.mips.util.Util.OR;
import static br.unioeste.mips.util.Util.SUB;
import static br.unioeste.mips.util.Util.AND;

public class ULATest extends TestCase{

	/**
	 * Test method for {@link br.unioeste.mips.components.ula.ULA#execute(java.lang.Integer)}.
	 */
	@Test
	public void testExecuteADD() {
		
		Integer expected	=	new Integer(64);
		
		ULA ulaCircuit	=	new ULA();
		ulaCircuit.setRawInput1(new Integer(32));
		ulaCircuit.setRawInput2(new Integer(32));
		ulaCircuit.execute(ADD);
		
		assertEquals(expected, ulaCircuit.getResult());
		
	}
	@Test
	public void testExecuteOR() {
		Integer expected	=	new Integer(0xFFFFFFFF);
		
		ULA ulaCircuit	=	new ULA();
		ulaCircuit.setRawInput1(new Integer(0xF0F0F0F0));
		ulaCircuit.setRawInput2(new Integer(0X0F0F0F0F));
		ulaCircuit.execute(OR);
		
		assertEquals(expected, ulaCircuit.getResult());
		
	}
	@Test
	public void testExecuteSUB() {
		Integer expected	=	new Integer(64);
		
		ULA ulaCircuit	=	new ULA();
		ulaCircuit.setRawInput1(new Integer(32));
		ulaCircuit.setRawInput2(new Integer(-32));
		ulaCircuit.execute(SUB);
		
		assertEquals(expected, ulaCircuit.getResult());
		
	}
	@Test
	public void testExecuteAND() {
		Integer expected	=	new Integer(0);
		
		ULA ulaCircuit	=	new ULA();
		ulaCircuit.setRawInput1(new Integer(0xFFFFFFFF));
		ulaCircuit.setRawInput2(new Integer(0x00000000));
		ulaCircuit.execute(AND);
		
		assertEquals(expected, ulaCircuit.getResult());
		
	}
	
	@Test
	public void testExecuteZeroFlag()	{
		Boolean expected	=	new Boolean(Boolean.TRUE);
		
		ULA ulaCircuit	=	new ULA();
		ulaCircuit.setRawInput1(new Integer(1));
		ulaCircuit.setRawInput2(new Integer(1));
		ulaCircuit.execute(SUB);
		
		assertEquals(expected, ulaCircuit.isActiveZeroFlag());
	}

}
