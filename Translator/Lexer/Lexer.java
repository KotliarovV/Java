import java.util.ArrayList;

import Languages.Language;
import Readers.CommentReader;
import Readers.FloatReader;
import Readers.IdentifierReader;
import Readers.IntReader;
import Readers.Reader;
import Readers.StringReader;
import Readers.WhitespaceReader;
import Readers.WordReader;
import Token.Token;

public class Lexer {
	public Language language;
	public String[] code;
	public CommentReader comReader;
	public FloatReader floatReader;
	public IntReader intReader;
	public IdentifierReader identReader;
	public StringReader stringReader;
	public WhitespaceReader whitespaceReader;
	public WordReader wordReader;
	public Token[] t;
	
	public Reader[] readers;

	public Lexer (String fileName, Language language)
	{
		this.language = language;
		FileRead fileReader = new FileRead(fileName);
		this.code = fileReader.strings;
		
		this.comReader = new CommentReader(this.language.commentSymbol);
		this.floatReader = new FloatReader();
		this.intReader = new IntReader();
		this.identReader = new IdentifierReader();
		this.stringReader = new StringReader();
		this.whitespaceReader = new WhitespaceReader();
		this.wordReader = new WordReader(this.language.lexems);
		
		
		Reader[] readers  = {this.comReader, this.floatReader, this.intReader, this.identReader,this.stringReader, this.whitespaceReader, this.wordReader};
		this.readers = readers;
		
	}
				
	public void tokensMaker()
	{
		ArrayList <Token> tokens = new ArrayList<>();
		for (int i = 0; i< code.length; i++)
		{
			while (code[i] != "" )
			{
				int l = 0;
				Token token = null;
				for (Reader r: readers)
				{
					if (r.tryReadToken(code[i])!= null && r.tryReadToken(code[i]).getText().length() >= l)
					{		
							l = r.tryReadToken(code[i]).getText().length();
							token = r.tryReadToken(code[i]);	
					}
				}
				tokens.add(token);
				if (l == code[i].length())
					break;
				code[i] = code[i].substring(l,code[i].length());
			}
		}
		
		t = tokens.toArray(new Token[tokens.size()]);
		
	}

}
