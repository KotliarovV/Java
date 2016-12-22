package Calculator;

import Element.Element;
import Lexer.LexerForCalc;
import Token.Token;

public class Calculator {

	public Element answ;
	public Token[] tokens;
	
	public Calculator (String string)
	{
	    LexerForCalc out = new LexerForCalc(string);
		out.tokensMaker();
		this.tokens = OPN.opn(out.t);		
		this.answ = OPN.getAnswerF(tokens);
	}
}
