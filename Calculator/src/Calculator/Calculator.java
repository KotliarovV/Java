package Calculator;
import java.util.Arrays;

import Readers.FunctReader;
import Element.Element;
import Lexer.LexerForCalc;
import Token.Token;
import Util.DividingByZeroException;
import Util.NotEndedExpressionException;

public class Calculator {

	public String answ;
	
	public Calculator (String string) {
		try {
			String expression = checkingExpression(string);
			LexerForCalc out = new LexerForCalc(expression);
			out.tokensMaker();
			this.answ = OPN.getAnswer(OPN.opn(out.t)).toString();
		}
		catch (NotEndedExpressionException e)
		{
			this.answ = "";
		}
		catch (DividingByZeroException z)
		{
			this.answ = "Dividing by zero";
		}
		catch (Throwable t)
		{
			this.answ = "Wrong input!!!";
		}
	}

	private Character[] notEndSymbols = {'+','-','(','*','/','^'};
	private String checkingExpression (String exp) {
		String nExpr = "";
		if (exp.equals(""))
			return "";
		for (int i = 0; i < exp.length() -1 ; i++) {
			if (exp.charAt(i) == ')' && exp.charAt(i+1) == '(')
				nExpr = nExpr + Character.toString(exp.charAt(i)) + "*";
			else if (Character.isDigit(exp.charAt(i)) && exp.charAt(i+1) == '(')
				nExpr = nExpr + Character.toString(exp.charAt(i)) + "*";
			else if (i==0 && exp.charAt(i) == '-')
				nExpr = nExpr +"0" + Character.toString(exp.charAt(i));
			else if( (exp.charAt(i) == '(') && exp.charAt(i+1) == '-')
				nExpr = nExpr + Character.toString(exp.charAt(i)) + "0";
			else if (Character.isDigit(exp.charAt(i)) && FunctReader.containsInFirstLetters( exp.charAt(i+1)))
				nExpr = nExpr + Character.toString(exp.charAt(i)) + "*";
			else nExpr = nExpr + Character.toString(exp.charAt(i));
		}
		nExpr = nExpr + Character.toString(exp.charAt(exp.length() -1));
		if (Arrays.asList(notEndSymbols).contains(nExpr.charAt(nExpr.length()-1)))
			throw new NotEndedExpressionException();
		return nExpr;
	}
}
