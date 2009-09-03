package br.atech.dojo.toandfro;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ToAndFromTest {

	private ToAndFromParser toandfromParser;

	@Before
	public void setUp() {
		toandfromParser = new ToAndFromParser();

	}

	@Test
	public void deveRetornarTextoDecriptado() throws Exception {
		assertEquals("theresnoplacelikehomeonasnowynightx", toandfromParser
				.parse("toioynnkpheleaigshareconhtomesnlewx", 5));
		assertEquals("thisistheeasyoneab", toandfromParser.parse(
				"ttyohhieneesiaabss", 3));
	}

	@Test
	public void separacaoDeLinhas() throws Exception {

		List<String> lines = toandfromParser
				.splitLines("ttyohhieneesiaabss", 3);

		assertEquals(6, lines.size());
		assertEquals("tty",lines.get(0));
		assertEquals("ohh",lines.get(1));
	}
	
	@Test
	public void decodeMessage() throws Exception {
		List<String> lines = Arrays.asList("abc","def");
		String messageDecoded = toandfromParser.decodeMessage(lines,3 );
		assertEquals("afbecd", messageDecoded);
		
		lines = Arrays.asList("abcxyz","defghi");
		assertEquals("aibhcgxfyezd", toandfromParser.decodeMessage(lines,6 ));
		
		
	}

}
