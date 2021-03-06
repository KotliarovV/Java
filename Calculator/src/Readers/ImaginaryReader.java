package Readers;
import Number.Number;
import Token.Token;

public class ImaginaryReader implements Reader{

	public Token tryReadToken (String input) {
		if (!Character.isDigit(input.charAt(0))) return null;
		int i = 0;
		int len = input.length();
		while (i < len && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.'))
			i++;
		if (i==len || input.charAt(i) != 'i') return null;
		i++;
		return new Token(new Number ((double)0, Double.parseDouble(input.substring(0, i-1))), "n", input.substring(0, i));
	}
}
