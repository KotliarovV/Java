package Readers;

import Token.Token;

public class StringReader implements Reader{
	
	public Token tryReadToken(String input) 
	{
		if (input.charAt(0) != '\"')
			return null;
		int i = 1;
		int len = input.length();
		while (i < len && input.charAt(i) != '\"')
			i++;
		
		return new Token("string",  input.substring(0, i+1));
	}}
