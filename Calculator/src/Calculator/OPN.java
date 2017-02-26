package Calculator;

import Number.Number;
import Token.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import Element.Element;

public class OPN {

    public static Token[] opn (Token[] t) {
        Stack <Token> stack = new Stack<Token>();
        HashMap<String, Integer> priority = new HashMap<String, Integer>();
        ArrayList <Token> opn = new ArrayList<Token>();
		priority.put("(", 3);
		priority.put(")", 3);
		priority.put("!",-1);
		priority.put("^",0);
		priority.put("*", 1);
		priority.put("/", 1);
        priority.put("+", 2);
        priority.put("-", 2);

        for ( int i = 0; i < t.length; i++)
        {
            if (t[i].type.equals("n") || t[i].type.equals("v")) opn.add(t[i]);
            else if (t[i].text.equals("(") ) stack.push(t[i]);
            else if (t[i].text.equals(")"))
            {
                while ((!stack.empty()) && !stack.peek().text.equals( "("))
                    opn.add( stack.pop());
                stack.pop();
            }
            else
            {
                int currentPriority = priority.get(t[i].text);
                while( (!stack.empty()) && (priority.get(stack.peek().text) <= currentPriority))
                    opn.add( stack.pop());
                stack.push(t[i]);
            }
        }
        while (!stack.isEmpty()){
            opn.add(stack.pop());
        }
        return opn.toArray(new Token[opn.size()]);
    }

    public static Element getAnswer (Token[] opn) {
		Element answer;
		Stack <Element> stack = new Stack<Element>();
		for (int i = 0; i< opn.length; i++)
		{
            if (opn[i].type.equals("n")) stack.push(new Element(opn[i].value));
			else if  (opn[i].type.equals("v")) stack.push(new Element (opn[i].vector));
			else if (opn[i].type.equals("sign") && opn[i].text.equals("!"))
			{
				Element a = stack.pop();
				stack.push(Element.factorial(a));
			}
			else if (opn[i].type.equals("sign"))
			{
				Element num2 = stack.pop();
				Element num1 = stack.pop();
				if (opn[i].text.equals("+")) stack.push(Element.add(num1, num2));
				if (opn[i].text.equals("-")) stack.push(Element.diff(num1, num2));
				if (opn[i].text.equals("*")) stack.push(Element.mult(num1, num2));
				if (opn[i].text.equals("/")) stack.push(Element.divide(num1, num2));
				if (opn[i].text.equals("^")) stack.push(Element.pow(num1, num2));
			}
		}
		answer = stack.peek();
		return answer;
	}
}
