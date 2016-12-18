package Readers;

import Token.Token;

public class WhitespaceReader implements Reader
{
	/**
	 * Читает с начала строки максимальное количество пробельных символов.
	 * 
	 * @return Возвращает прочитанный префикс строки.
	 */
	public Token tryReadToken(String input) 
	{
		int i = 0;
		int len = input.length();
		while (i < len && Character.isWhitespace(input.charAt(i)))
			i++;
		if (i==0)
			return null;
		return new Token("ws", input.substring(0, i));
	}
}
