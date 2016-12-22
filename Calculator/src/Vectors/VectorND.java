package Vectors;
import Number.Number;

public class VectorND  {

	/**
	 * @param args
	 */
	public Number[] Coordinats;
	
	
	public VectorND (Number[] args)
	{
		Coordinats = new Number[args.length];
		for ( int i =0; i < args.length; i++)
			Coordinats[i] = args[i];
	}
	
	
	public VectorND add (VectorND vector) 
	{
		if (this.Coordinats.length != vector.Coordinats.length) throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		
		int len = this.Coordinats.length;
		Number[] Coordinats = new Number [len];
		for (int i = 0; i <len; i++)
				Coordinats[i]=Number.sum(this.Coordinats[i],vector.Coordinats[i]);
		return returnType(Coordinats);
	}
	
	
	public VectorND mult (Number number) 
	{
		
		int len = this.Coordinats.length;
		Number[] Coordinats = new Number [len];
		for (int i = 0; i <len; i++)
				Coordinats[i]=Number.mult(this.Coordinats[i],number);
		return returnType(Coordinats);
	}
	
	public VectorND divide (Number number) 
	{
		
		int len = this.Coordinats.length;
		Number[] Coordinats = new Number [len];
		for (int i = 0; i <len; i++)
				Coordinats[i]=Number.divide(this.Coordinats[i],number);
		return returnType(Coordinats);
	}
	
	
	
	public VectorND diff (VectorND vector)
	{
		if (this.Coordinats.length != vector.Coordinats.length) throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
	
		int len = Math.max(this.Coordinats.length, vector.Coordinats.length);
		Number[] Coordinats = new Number [len];
		for (int i = 0; i <len; i++)
				Coordinats[i]= Number.diff(this.Coordinats[i], vector.Coordinats[i]);
		return returnType(Coordinats);
	}
	
	
	public Number scalar (VectorND vector)
	{
		
		if (this.Coordinats.length != vector.Coordinats.length) throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		
		Number scMult = new Number ((float)0,(float)0);
		int len = this.Coordinats.length;
		for (int i = 0; i <len; i++)
			scMult = Number.sum(scMult, Number.mult(this.Coordinats[i],vector.Coordinats[i])) ;
		return scMult;
	}
	
	
	
	@Override
    public String toString() {
     String vector = "{";
     for (int i = 0; i< this.Coordinats.length; i++)
     {
    	 if (i< this.Coordinats.length - 1)
    	 vector = vector+ this.Coordinats[i].toString() + ", ";
    	 
    	 else vector = vector + this.Coordinats[i].toString() + "}";
    	 
     }
     return vector;
	}
     
     @Override
 	public int hashCode() {
    	 return this.Coordinats.hashCode();
     	}
     
    @Override
    public boolean equals(Object obj) 
     {
    	 if (this == obj)
 			return true;
 		if (obj == null)
 			return false;
 		if (this.getClass() != obj.getClass())
 			return false;
 		VectorND vector = (VectorND) obj;
 		if (vector.Coordinats.length != this.Coordinats.length)
 			return false;
 		for (int i = 0; i< this.Coordinats.length; i++)
 			if (this.Coordinats[i] != vector.Coordinats[i] ) 
 				return false;
 		return true;			
     }
	
	protected VectorND returnType( Number[] coordinats)
	{
		VectorND vector = new VectorND(new Number[] {});
		vector.Coordinats = coordinats;
			return vector;		
	}

          
    }
	
	

