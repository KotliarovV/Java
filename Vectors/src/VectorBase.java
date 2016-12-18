
public abstract class VectorBase implements Vector {

	double[] Coordinats;
	
	abstract VectorBase returnType(double[] Coordinats);
	
	public VectorBase add (VectorBase vector) 
	{
		if (this.Coordinats.length != vector.Coordinats.length) throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		
		int len = this.Coordinats.length;
		double[] Coordinats = new double [len];
		for (int i = 0; i <len; i++)
				Coordinats[i]=this.Coordinats[i]+vector.Coordinats[i];
		return returnType(Coordinats);
	}
	
	public VectorBase sub (VectorBase vector)
	{
		if (this.Coordinats.length != vector.Coordinats.length) throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
	
		int len = Math.max(this.Coordinats.length, vector.Coordinats.length);
		double[] Coordinats = new double [len];
		for (int i = 0; i <len; i++)
				Coordinats[i]=this.Coordinats[i]-vector.Coordinats[i];
		return returnType(Coordinats);
	}

	
	public double scalar (VectorBase vector)
	{
		
		if (this.Coordinats.length != vector.Coordinats.length) throw new IllegalArgumentException("Lengths of coordinat arrays aren`t equal!");
		
		double scMult = 0.0;
		int len = this.Coordinats.length;
		for (int i = 0; i <len; i++)
			scMult = scMult + this.Coordinats[i]*vector.Coordinats[i];
		return scMult;
	}
	
	@Override
    public String toString() {
     String vector = "{";
     for (int i = 0; i< this.Coordinats.length; i++)
     {
    	 if (i< this.Coordinats.length - 1)
    	 vector = vector+ this.Coordinats[i] + ", ";
    	 
    	 else vector = vector + this.Coordinats[i] + "}";
    	 
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
 		VectorBase vector = (VectorBase) obj;
 		if (vector.Coordinats.length != this.Coordinats.length)
 			return false;
 		for (int i = 0; i< this.Coordinats.length; i++)
 			if (this.Coordinats[i] != vector.Coordinats[i] ) 
 				return false;
 		return true;			
     }

	


}
