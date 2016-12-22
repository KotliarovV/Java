package Lexer;

import Readers.VectorReader;

public class LexerForCalc extends Lexer {
	
	
	public VectorReader vectorReader; 
	
	public LexerForCalc(String string) {
		super(string);
		this.vectorReader = new VectorReader();
		this.readers.add(this.vectorReader);
	}

	
}
