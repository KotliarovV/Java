package Readers;

import Token.Token;

public class IdentifierReader implements Reader
{
	public Token tryReadToken(String input) 
	{
		// TODO Задача 1: доделать по аналогии с WhitespaceReader
		if (!Character.isJavaIdentifierStart(input.charAt(0)))
		      return null;
		int i = 0;
		int len = input.length();
		
		while (i < len && Character.isJavaIdentifierStart(input.charAt(i)))
			i++;
		return new Token("identifier", input.substring(0, i));
		
	}
}
