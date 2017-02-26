package Lexer;

import Readers.VectorReader;

public class LexerForCalc extends Lexer {

	private VectorReader vectorReader = new VectorReader();
	
	public LexerForCalc(String string) {
		super(string);
		this.readers.add(this.vectorReader);
	}
}
