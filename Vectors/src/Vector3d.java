
public final class Vector3d extends VectorBase implements Vector {


	/**
	 * @param args
	 */
	
	Vector3d (Double a, Double b, Double c)
	{
		this.Coordinats = new double[3];
		this.Coordinats[0] = a;
		this.Coordinats[1] = b;
		this.Coordinats[2] = c;
	}
	
	protected Vector3d returnType( double[] coordinats)
	{
			return new Vector3d(coordinats[0],coordinats[1],coordinats[2]);		
	}

	
	
}