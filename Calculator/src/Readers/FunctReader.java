package Readers;
import java.util.Stack;
import Lexer.Lexer;
import Calculator.OPN;
import Token.Token;
import Number.Number;
import Element.Element;
/**
 * Created by Vitaly on 25.01.2017.
 */

public class FunctReader implements Reader{

    private static char[] firstLettersFunctions = {'c','s','t'};

    public static boolean containsInFirstLetters (char a)
    {
        for (int i = 0; i < firstLettersFunctions.length ; i++) {
            if (a == firstLettersFunctions[i])
                return true;
        }
        return false;
    }

    public Token tryReadToken (String input)

    {
        if (!input.startsWith("cos(")  &&  !input.startsWith("sin(")
                && !input.startsWith("cosD(")  &&  !input.startsWith("sinD(")
                && !input.startsWith("tgn(") && !input.startsWith("tgnD(")
                && !input.startsWith("ctg(")  && !input.startsWith("ctgD(") ) return null;

        int i = 0;
        if (input.startsWith("cos(")  ||  input.startsWith("sin(") || input.startsWith("tgn(") || input.startsWith("ctg(")) i = 3;
        if (input.startsWith("cosD(")  ||  input.startsWith("sinD(") || input.startsWith("tgnD(") || input.startsWith("ctgD(")) i = 4;
        Stack<Character> stack = new Stack<Character>();

        boolean wasComma = false;
        stack.push('(');
        String string = "(";

        while (!stack.empty())
        {
            i++;

            string = string+ Character.toString(input.charAt(i));
            if (input.charAt(i) == ')')
            {
                stack.pop();
            }
            if (input.charAt(i) == '(')
            {
                stack.push(input.charAt(i));
            }
        }
        Lexer out = new Lexer(string);
        out.tokensMaker();
        Token[] yy = OPN.opn(out.t);
        Number answ = OPN.getAnswer(yy).number;
        if (input.startsWith("cos("))
            return  new Token (Number.cos(answ),"n", input.substring(0,i+1));
        if (input.startsWith("cosD("))
            return  new Token (Number.cosD(answ),"n",  input.substring(0,i+1));
        if (input.startsWith("sinD("))
            return  new Token (Number.sinD(answ),"n", input.substring(0,i+1));
        if (input.startsWith("sin("))
            return  new Token (Number.sin(answ),"n",  input.substring(0,i+1));
        if (input.startsWith("tgn("))
            return new Token (Number.tgn(answ), "n",   input.substring(0,i+1));
        if (input.startsWith("tgnD("))
            return new Token (Number.tgnD(answ), "n",   input.substring(0,i+1));
        if (input.startsWith("ctg("))
            return new Token (Number.ctg(answ), "n",   input.substring(0,i+1));
        if (input.startsWith("ctgD("))
            return new Token (Number.ctgD(answ), "n",   input.substring(0,i+1));

       return null;

    }
}
