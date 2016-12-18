import Languages.Language;
//import Languages.Pascal;
//import Token.Token;

public class Translator {

	private Lexer in;
	private Language languageIn;
	private Language languageOut;
	public String[] newProgram;
	
	public Translator (Language languageIn,Language languageOut, String program )
	{
		in = new Lexer(program, languageIn);
		in.tokensMaker();
		this.languageIn = languageIn;
		this.languageOut = languageOut;
	}
	
	public String translate ()
	{
		String f = languageOut.concat(languageIn.parseArray(in.t));
		return f;
	}
	
}
