public final class Vector2d extends VectorBase implements Vector  {
	Vector2d (double a, double b) {
		this.Coordinats = new double [2];
		this.Coordinats[0] = a;
		this.Coordinats[1] = b;
	}
	protected Vector2d returnType( double[] coordinats)
	{
			return new Vector2d(coordinats[0],coordinats[1]);		
	}
}
          