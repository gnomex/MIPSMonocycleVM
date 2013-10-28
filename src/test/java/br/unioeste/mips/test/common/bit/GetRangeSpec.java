package br.unioeste.mips.test.common.bit;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unioeste.mips.common.bit.BitDecoder;

public class GetRangeSpec {

	
	@Test
	public void getRangeBits1() {
		Integer expected	=	new Integer(0x0000000F);
		
		BitDecoder bitDecoder	=	new BitDecoder();
		Integer instruction	=	new Integer(0xF0000000);
		
		assertEquals(expected, bitDecoder.getRangeBits(instruction, 28, 31));
	}
	@Test
	public void getRangeBits2() {
		Integer expected	=	new Integer(0x00000001);
		
		BitDecoder bitDecoder	=	new BitDecoder();
		Integer instruction	=	new Integer(0xF0000000);
		
		assertEquals(expected, bitDecoder.getRangeBits(instruction, 31, 31));
	}
	@Test
	public void getRangeBits3() {
		Integer expected	=	new Integer(0x00000009);
		
		BitDecoder bitDecoder	=	new BitDecoder();
		Integer instruction	=	new Integer(0x40000090);
		
		assertEquals(expected, bitDecoder.getRangeBits(instruction,4, 7));
	}
	@Test
	public void getRangeBits4() {
		Integer expected	=	new Integer(0x00000001);
		
		BitDecoder bitDecoder	=	new BitDecoder();
		Integer instruction	=	new Integer(0x08000000);
		
		assertEquals(expected, bitDecoder.getRangeBits(instruction, 27, 27));
	}
	@Test
	public void getRangeBits5() {
		Integer expected	=	new Integer(0x000000FF);
		
		BitDecoder bitDecoder	=	new BitDecoder();
		Integer instruction	=	new Integer(0x0FF00000);
		
		assertEquals(expected, bitDecoder.getRangeBits(instruction, 20, 37));
	}
}
