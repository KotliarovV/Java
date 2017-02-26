package Token;
import Number.Number;
import Vectors.VectorND;

public class Token 
{
	public  Number value;
	public  String type;
	public String text;
	public VectorND vector;
	
	public Token ( Number value, String type, String text) {
		this.value = value;
		this.text = text;
		this.type = type;
	 }

	public Token ( VectorND value, String type, String text) {
		this.vector = value;
		this.text = text;
		this.type = type;
	 }

	public Token(String type, String text) {
		this.text = text;
		this.type = type;
	}

	public Object getValue() {return value;}

	public String getType() 
	{
		return type;
	}

	public String getText() 
	{
		return text;
	}

	@Override
	public String toString() {
		return type + "[" + text + "]"+ value.toString();
	}

	@Override
	public int hashCode () {return  this.value.hashCode() + this.type.hashCode()+this.text.hashCode() + this.vector.hashCode();}

	@Override
	public boolean equals(Object obj) {
		Token other = (Token) obj;
		return type.equals(other.type) && value.equals(other.value)
				&& text.equals(other.text);
	}
}