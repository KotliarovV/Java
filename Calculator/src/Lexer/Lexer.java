
package Lexer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import Readers.ConstReader;
import Readers.FloatReader;
import Readers.FunctReader;
import Readers.ImaginaryReader;
import Readers.Reader;
import Readers.SignReader;
import Token.Token;

public class Lexer {

	private String code;
	private FloatReader floatReader =  new FloatReader();;
	private ImaginaryReader imaginaryReader = new ImaginaryReader();
	private SignReader signReader = new SignReader();
	private FunctReader functReader = new FunctReader();
	private ConstReader constReader = new ConstReader();
	public Token[] t;
	protected ArrayList<Reader> readers = new ArrayList<>();

	public Lexer (String string) {
		this.code = string;
		Reader[] readers = {this.floatReader, this.imaginaryReader, this.signReader, this.functReader, this.constReader};
		this.readers.addAll(Arrays.asList(readers));

	}
				
	public void tokensMaker() {
		ArrayList <Token> tokens = new ArrayList<>();
		while (!code.equals (""))
		{
			int l = 0;
			int i = 0;
			Token token = null;
			for (Reader r : readers)
			{
				if (r.tryReadToken(code)!= null)
				{
					if ( r.tryReadToken(code).getText().length() >= l)
					{
						l = r.tryReadToken(code).getText().length();
						token = r.tryReadToken(code);
						i = 0;
					}
				}
				else i++;
				if (i == readers.size())
					throw new IllegalArgumentException("value is wrong");
			}
			tokens.add(token);
			if (l == code.length()) break;
			code = code.substring(l,code.length());
		}
		t = tokens.toArray(new Token[tokens.size()]);
	}
}
