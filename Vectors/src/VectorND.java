public final class VectorND extends VectorBase implements Vector {
	VectorND (double...args) {
		Coordinats = args;
	}

	protected VectorND returnType( double[] coordinats) {
		VectorND vector = new VectorND();
		vector.Coordinats = coordinats;
			return vector;		
	}
}
	
	

