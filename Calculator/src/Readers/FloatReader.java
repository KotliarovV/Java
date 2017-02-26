package Readers;
import Token.Token;
import Number.Number;

public class FloatReader implements Reader{

	public Token tryReadToken (String input) {
		if (!Character.isDigit(input.charAt(0))) return null;
		int i = 0;
		int len = input.length();
		while (i < len && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.'))
			i++;
		return new Token(new Number (Double.parseDouble(input.substring(0, i)),0.0), "n", input.substring(0, i));
	}
}
