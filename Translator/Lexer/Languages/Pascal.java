package Languages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Token.Token;
import struckture.CommentStruckture;
import struckture.DeclarationStructure;
import struckture.IfWhileStruckture;
import struckture.SimpleStruckture;
import struckture.Struckture;

public class Pascal extends Language{
	
	

	public Pascal()
	{
	lexems =   new HashMap<String, String>();
	lexems.put("declaration","var"); 
	lexems.put("float type", "Real"); 
	lexems.put("int type", "Integer"); 
	lexems.put("str type", "String"); 
	lexems.put("of type", ":"); 
	lexems.put("acquire", ":="); 
	lexems.put("close", "end"); 
	lexems.put("open", "begin"); 
	lexems.put("condition", "if"); 
	lexems.put("cycle while", "while"); 
	lexems.put("else chain", "else"); 
	lexems.put("function left", "("); 
	lexems.put("function right", ")"); 
	lexems.put("end of condition", "then");
	lexems.put("end of condition while", "do");
	lexems.put("lower", "<"); 
	lexems.put("greater", ">"); 
	lexems.put("sum", "+");
	lexems.put("comma", ",");
	lexems.put("sub", "-"); 
	lexems.put("div", "div"); 
	lexems.put("mod", "mod"); 
	lexems.put("mul", "*"); 
	lexems.put("mul", "*"); 
	lexems.put("semicolon", ";"); 
	//lexems.put("string mark ", "\\\""); 
	lexems.put("goa", ">=");
	lexems.put("equals", "=");
	lexems.put("loa", "<="); 
	commentSymbol = "//";
	}

	public ArrayList<Struckture> parseArray (Token[] tokens)
	{
		ArrayList <Struckture> strucktures = new ArrayList<>();
		for (int i = 0; i< tokens.length; i++)
		{
			
			if (Arrays.binarySearch(structuresIfWhile, tokens[i].getType()) >=0)
			{
				Token keyWord = tokens[i];
				ArrayList <Token> condition = new ArrayList<>();
				ArrayList <Token> body = new ArrayList<>();
				i++;
				while (tokens[i].getType() != "end of condition" && tokens[i].getType() !=  "end of condition while")
				{
					if  (tokens[i].getType() != "ws")
					{
						condition.add(tokens[i]);
						i++;
					}
					else
						i++;				
				}
				i++;
				
				while (tokens[i].getType() != "close")
				{
					if (tokens[i].getType() != "open" && tokens[i].getType() != "ws")
					{
						body.add(tokens[i]);
						i++;
					}
					else
						i++;				
				}
				
				Struckture newS = new IfWhileStruckture(keyWord, condition.toArray(new Token[condition.size()]),body.toArray(new Token[body.size()]) );
				strucktures.add(newS);
			}
			
			else if ( tokens[i].getType() == "declaration")
			{
				
				ArrayList <Token> variables = new ArrayList<>();
				
				
				i++;
				while (tokens[i].getType() != "open")
				{
					if (tokens[i].getType() == "identifier")
					{
						variables.add(tokens[i]);
						i++;
					}
					else if (Arrays.binarySearch(declarations, tokens[i].getType()) >=0)
					{
						strucktures.add(new DeclarationStructure (tokens[i],variables.toArray(new Token[variables.size()])));
						variables = new ArrayList<>();
						i++;
					}
					else
						i++;
				}
			}
			
			else if (tokens[i].getType() == "identifier")
			{
				ArrayList <Token> body = new ArrayList<>();
				while (tokens[i].getType() != "semicolon")
				{
					body.add(tokens[i]);
					i++;
				}
				strucktures.add(new SimpleStruckture (body.toArray(new Token[body.size()])));
			}
			else if (tokens[i].getType() == "comment")
			{
				strucktures.add(new CommentStruckture (tokens[i].getText()));
			}
			
			
		}
		return strucktures;
	}

	
	
	public String concat (ArrayList<Struckture> strings)
	{
		String answer;
		answer = "var "; 
		
		for ( int i =0; i <strings.size(); i++)
		{
			if (strings.get(i) instanceof DeclarationStructure)
			{
				DeclarationStructure dec = (DeclarationStructure) strings.get(i);
				
				for (int j = 0; j< dec.variables.length; j++)
				{
					if (j!=dec.variables.length-1)
					answer = answer+ dec.variables[j].getText()+", ";
					else
						answer = answer+ dec.variables[j].getText()+": ";
				}
				answer = answer + lexems.get(dec.type.getType())+"; \n ";
			}

			
		}
		answer = answer+ "begin  \n";
		for ( int i =0; i <strings.size(); i++)
		{
			if (strings.get(i) instanceof IfWhileStruckture)
			{
				IfWhileStruckture dec = (IfWhileStruckture) strings.get(i);
				answer = answer + lexems.get(dec.type.getType())+" ";
				for (int j =0; j<dec.condition.length ; j++)
				{
					 if (lexems.containsKey(dec.condition[j].getType()))
						 answer = answer + lexems.get(dec.condition[j].getType())+" ";
					 else
						 answer = answer + dec.condition[j].getText()+" ";
				}
				if (dec.type.getType() == "condition")
					answer = answer + "then \n  begin";
				else
					answer = answer + "do \n  begin";
				for (int j =0; j<dec.body.length ; j++)
				{
					 if (lexems.containsKey(dec.body[j].getType()))
						 answer = answer + lexems.get(dec.body[j].getType())+" ";
					 else
						 answer = answer + dec.body[j].getText()+" ";
				}
				answer = answer + "end; \n";
				
			}
			else  if (strings.get(i) instanceof CommentStruckture)
			{
				CommentStruckture dec = (CommentStruckture) strings.get(i);
				answer = answer +  dec.string+"\n";
					
			}

			
			else if (strings.get(i) instanceof SimpleStruckture)
			{
				SimpleStruckture dec = (SimpleStruckture) strings.get(i);
				for (int j =0; j<dec.body.length ; j++)
				{
					 if (lexems.containsKey(dec.body[j].getType()))
						 answer = answer + lexems.get(dec.body[j].getType())+" ";
					 else
						 answer = answer + dec.body[j].getText()+" ";
				}
				answer = answer + "\n";
			}
		}
		return answer + "end.";
	}
}
