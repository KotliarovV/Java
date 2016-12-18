package Readers;
import java.util.HashMap;

import Token.Token;

public class WordReader implements Reader
{
	private HashMap<String,String> lexems;

	// TODO Задача 1: Добавить параметр ignoreCase — чувствительность к регистру
	public WordReader(HashMap<String,String> lexems)
	{
		super();
		this.lexems = lexems;
	}

	public String getKeyByValue (HashMap<String,String> lexems, String value)
	{
		for (String key : lexems.keySet()) {
		    if (lexems.get(key) == value)
		    	return key;
		 
		}
		return null;
	}
	
	public Token tryReadToken(String input) 
	{
		int i = 0;
		String type = "";
		String word = "";
		
		for (String keyword : this.lexems.values()) {
			if (input.startsWith(keyword) && keyword.length() > i)
			{
				word = keyword;
				type = this.getKeyByValue(lexems, keyword);
				i = keyword.length();
			}
			

		}
		if (i > 0)
			return new Token(type, word);
		return null;
	}
}
