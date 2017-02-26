package Number;

import java.math.BigDecimal;

import Util.DividingByZeroException;


public class Number {

	public double realPart;
	public double imaginaryPart;
	
	public Number (double rp, double ip) {
		this.realPart = rp;
		this.imaginaryPart = ip;
	}

	public Number (NumberBigDecimal a) {
		this.realPart = a.Rp.doubleValue();
		this.imaginaryPart = a.Ip.doubleValue();
	}
	
	public static Number mult (Number a, Number b) {
		return new Number(NumberBigDecimal.mult(a,b));
	}

	public static Number sum (Number a, Number b) {
		return new Number (NumberBigDecimal.sum(a,b));
	}

	public static Number diff (Number a, Number b) {
		return new Number (NumberBigDecimal.diff(a,b));
	}

	public static Number divide (Number a, Number b) {
		if (b.imaginaryPart == 0 && b.realPart == 0)
			throw new DividingByZeroException();
		return new Number (NumberBigDecimal.divide(a,b));
	}

	public static Number pow (Number a, Number b)
	{
		Number c = new Number(a.realPart,a.imaginaryPart);
		if ((Math.signum(b.imaginaryPart) != 0)  || (Math.signum(a.imaginaryPart) != 0  && b.realPart %1 != 0))
			throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		else if (Math.signum(a.imaginaryPart) != 0 )
			while (b.realPart > 1)
			{
				a = Number.mult(a,c);
				b.realPart = b.realPart -1;
			}
		else a = new Number ( Math.pow(a.realPart,b.realPart), 0);
		return a;
	}

	public static Number factorial (Number a) {
		if ((Math.signum(a.imaginaryPart) != 0) || (a.realPart % 1 != 0) || (a.realPart < 0))
			throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		else if (a.realPart == 0) return new Number(1,0);
		else
		{
			Number n = new Number (1,0);
			Number b = new Number (1,0);
			while (n.realPart <= a.realPart)
			{
				b = Number.mult(b,n);
				n = Number.sum(n, new Number(1,0));
			}
			return b;
		}
	}

	public static Number cos (Number a) {
		if (Math.signum(a.imaginaryPart) != 0)
			throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		double answer = (new BigDecimal(StrictMath.cos(a.realPart))).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
		return new Number(answer,0);
	}

	public static Number cosD (Number a) {
		a.realPart = Math.toRadians(a.realPart);
		return Number.cos(a);
	}

	public static Number sin (Number a) {
		if (Math.signum(a.imaginaryPart) != 0)
			throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		double answer = (new BigDecimal(StrictMath.sin(a.realPart))).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
		return new Number (answer,0);
	}

	public static Number sinD (Number a) {
		a.realPart = Math.toRadians(a.realPart);
		return Number.sin(a);
	}

	public static Number tgn (Number a) {
		if (Math.abs(a.realPart /2 - Math.PI) < 0.00001)
			throw new DividingByZeroException();
		return Number.divide(Number.sin(a), Number.cos(a) );
	}

	public static Number tgnD (Number a) {
		Number b = new Number(a.realPart,a.imaginaryPart);
		return Number.divide(Number.sinD(a), Number.cosD(b));
	}

	public static Number ctg (Number a) {
		if (Number.tgnD(a).realPart == 0)
			throw new DividingByZeroException();
		return  Number.divide(new Number(1,0), Number.tgn(a));
	}

	public static Number ctgD (Number a) {
		if (Number.tgnD(a).realPart == 0)
			throw new DividingByZeroException();
		return  Number.divide(new Number(1,0), Number.tgnD(a));
	}

	private String doubleToString (double d) {
		String answ = (String.valueOf(d).endsWith(".0")) ? Integer.toString((int) d) : String.valueOf(d);
		return answ;
	}

	@Override
    public String toString() {
		String number;
		if (Math.signum(this.realPart)== 0 && Math.signum(this.imaginaryPart) == 0)
			number = "0";
		else if 	(Math.signum(this.realPart)== 0)
			number =  doubleToString(this.imaginaryPart) + "i";
		else if (Math.signum(this.imaginaryPart) == 0 )
			number = doubleToString(this.realPart);
		else
			number = doubleToString(this.realPart) +" + "+ doubleToString(this.imaginaryPart) + "i";
		 return number;
	}

	@Override
	public int hashCode() {
		return ((int) this.realPart + (int) this.imaginaryPart);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		Number  number = (Number) obj;
		return this.realPart == number.realPart && this.imaginaryPart == number.imaginaryPart;
	}
}
