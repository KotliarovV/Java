package Readers;

import Token.Token;

public class SignReader implements Reader{
	public Token tryReadToken (String input) 

	{ 
	
	if (input.charAt(0) == '+')
		return new Token("sign", input.substring(0, 1));
	else if (input.charAt(0) == '-')
		return new Token("sign", input.substring(0, 1));
	else if (input.charAt(0) == '*')
		return new Token("sign", input.substring(0, 1));
	else if (input.charAt(0) == '/')
		return new Token("sign", input.substring(0, 1));
	else if (input.charAt(0) == '(')
		return new Token("bracket", input.substring(0, 1));
	else if (input.charAt(0) == ')')
		return new Token("bracket",  input.substring(0, 1));
	else return null;
	}
		
	

}
