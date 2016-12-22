package Number;

public class Number {

	public Float realPart;
	public Float imaginaryPart;
	
	public Number (Float rp, Float ip)
	{
		this.realPart = rp;
		this.imaginaryPart = ip;
	}
	
	public static Number mult (Number a, Number b)
	{
		Float answRP = a.realPart*b.realPart + a.imaginaryPart*b.imaginaryPart; 
		Float answIP = a.realPart*b.imaginaryPart + a.imaginaryPart*b.realPart;
		return new Number (answRP, answIP);
	}
	public static Number sum (Number a, Number b)
	{
		Float answRP = a.realPart + b.realPart; 
		Float answIP = b.imaginaryPart + a.imaginaryPart;
		return new Number (answRP, answIP);
	
	}
	
	
	public static Number diff (Number a, Number b)
	{
		Float answRP = a.realPart - b.realPart; 
		Float answIP = a.imaginaryPart - b.imaginaryPart;
		return new Number (answRP, answIP);
	
	}
	
	
	public static Number divide (Number a, Number b)
	{
		Float answRP = ((a.realPart*b.realPart + a.imaginaryPart*b.imaginaryPart)/(b.realPart*b.realPart + b.imaginaryPart*b.imaginaryPart));
		Float answIP = ((b.realPart*a.imaginaryPart - a.realPart*b.imaginaryPart)/(b.realPart*b.realPart + b.imaginaryPart*b.imaginaryPart));
		return new Number (answRP, answIP);
	}
	
	@Override
    public String toString() {
     String number;
     number = this.realPart.toString() +" + "+ this.imaginaryPart.toString() + "i";
     return number;
	}
}
