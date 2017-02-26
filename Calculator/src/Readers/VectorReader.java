package Readers;

import java.util.ArrayList;
import java.util.Stack;
import Calculator.OPN;
import Lexer.Lexer;
import Number.Number;
import Token.Token;
import Vectors.VectorND;

public class VectorReader implements Reader{

	public Token tryReadToken (String input) {
		if (input.charAt(0) != '(') return null;
		int i =0;
		Stack<Character> stack = new Stack<Character>();
		String string = "(";
		boolean wasComma = false;
		stack.push(input.charAt(0));
		while (!stack.empty()) 
		{
			i++;
			if (input.charAt(i) == ',')
			{
				wasComma = true;
				if (stack.size() != 1) return null;
			}
			string = string+ Character.toString(input.charAt(i));
			if (input.charAt(i) == ')') stack.pop();
			if (input.charAt(i) == '(') stack.push(input.charAt(i));
		}
		if (!wasComma) return null;
		String substr = "";
		ArrayList<Number> numbers = new ArrayList<Number>();
		for (int j=1; j<string.length();j++)
		{
			if (input.charAt(j) != ',' && j!=string.length()-1) 
				substr = substr+ Character.toString(string.charAt(j));
			else 
			{
				Lexer out = new Lexer(substr);
				out.tokensMaker();
				Token[] yy = OPN.opn(out.t);
				Number answ = OPN.getAnswer(yy).number;
				numbers.add(answ);
				substr = "";
			}
		}
		return new Token (new VectorND(numbers.toArray(new Number[numbers.size()])),"v",string );
	}
}

