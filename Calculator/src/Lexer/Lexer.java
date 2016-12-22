
package Lexer;

import java.util.ArrayList;
import Readers.FloatReader;
import Readers.ImaginaryReader;
import Readers.Reader;
import Readers.SignReader;
import Token.Token;

public class Lexer {
	public String code;
	public FloatReader floatReader;
	public ImaginaryReader imaginaryReader;
	public SignReader signReader;
	public Token[] t;
	
	public ArrayList<Reader> readers;

	public Lexer (String string)
	{
		this.code = string;
		
		this.floatReader = new FloatReader();
		this.imaginaryReader = new ImaginaryReader();
		this.signReader = new SignReader();
		
		ArrayList<Reader> readers  = new ArrayList <Reader>();
		readers.add(this.floatReader); 
		readers.add(this.imaginaryReader);
		readers.add(this.signReader);
		this.readers = readers;
		
	}
				
	public void tokensMaker()
	{
		ArrayList <Token> tokens = new ArrayList<>();
			while (code != "" )
			{
				int l = 0;
				Token token = null;
				for (Reader r: readers)
				{
					//System.out.println(l);
					if (r.tryReadToken(code)!= null)
						{if ( r.tryReadToken(code).getText().length() >= l)
					{		
							l = r.tryReadToken(code).getText().length();
							token = r.tryReadToken(code);	
					}
						}
				}
				//if (token!= null)
				tokens.add(token);
				if (l == code.length())
					break;
				code = code.substring(l,code.length());
			}
		
		
		t = tokens.toArray(new Token[tokens.size()]);
		
	}

}
