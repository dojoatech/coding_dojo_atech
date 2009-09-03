package br.atech.dojo.toandfro;

import java.util.ArrayList;
import java.util.List;

public class ToAndFromParser {

	public String parse(String message, int columns) {
		
		List<String> lines = splitLines(message, columns);

		String messageParse = decodeMessage(lines,columns);
		return messageParse;

	}

	protected String decodeMessage(List<String> lines,int columns) {
		List<String> linesDecoded = decodeLines(lines);
		return buildMessage(columns, linesDecoded);
	}

	private String buildMessage(int columns, List<String> linesDecoded) {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<columns;i++){
			for (String string : linesDecoded) {
				sb.append(string.charAt(i));
			}
		}
		return sb.toString();
	}

	private List<String> decodeLines(List<String> lines) {
		List<String> linesDecoded = new ArrayList<String>();
		boolean reverse = false;
		for (String string : lines) {
			if (reverse) {
				linesDecoded.add(reverse(string));
			} else {
				linesDecoded.add(string);
			}
			reverse = !reverse;
		}
		return linesDecoded;
	}

	private String reverse(String line) {
		StringBuilder sb = new StringBuilder();
		for (int i = line.length() - 1; i >= 0; i--) {
			sb.append(line.charAt(i));
		}

		return sb.toString();

	}

	protected List<String> splitLines(String message, int columns) {
		List<String> lines = new ArrayList<String>();

		for (int i = 0; i < message.length(); i = i + columns) {
			lines.add(message.substring(i, i + columns));
		}

		return lines;
	}

}
