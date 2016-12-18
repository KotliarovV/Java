
public final class VectorND extends VectorBase implements Vector {

	/**
	 * @param args
	 */
	
	VectorND (Double...args)
	{
		Coordinats = new double[args.length];
		for ( int i =0; i < args.length; i++)
			Coordinats[i] = args[i];
	}
	
	protected VectorND returnType( double[] coordinats)
	{
		VectorND vector = new VectorND();
		vector.Coordinats = coordinats;
			return vector;		
	}

          
    }
	
	

