package Readers;

import Token.Token;

public class CommentReader implements Reader {
	public String commentSymbol;
	public CommentReader(String commentSymbol)
	{
		this.commentSymbol = commentSymbol;
	}

	public Token tryReadToken(String input) 
	{
		
		if (input.startsWith(this.commentSymbol))
			return new Token("comment", input);
		return null;
		
	}
}
