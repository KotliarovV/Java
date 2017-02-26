package Readers;

import java.util.Arrays;

import Token.Token;

public class SignReader implements Reader{

	private static Character[] signs = {'+','-','*','/','^','!'};
	private static Character[] brackets = {'(',')'};

	public Token tryReadToken (String input) {
		if (Arrays.asList(signs).contains(input.charAt(0)))
			return new Token("sign", input.substring(0, 1));
		else if (Arrays.asList(brackets).contains(input.charAt(0)))
			return new Token("bracket", input.substring(0, 1));
		else return null;
	}
}
