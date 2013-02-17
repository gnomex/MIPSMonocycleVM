package br.unioeste.mips.test.common.bit;

import junit.framework.TestCase;

import org.junit.Test;

import br.unioeste.mips.common.bit.BitDecoder;

public class BitDecoderTest extends TestCase{

	@Test
	public void testToBinari() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRangeBits() {
		Integer expected	=	new Integer(0x0000000F);
		
		BitDecoder bitDecoder	=	new BitDecoder();
		Integer instruction	=	new Integer(0xFF000000);
		
		assertEquals(expected, bitDecoder.getRangeBits(instruction, 29, 32));
		
		
	}

}
