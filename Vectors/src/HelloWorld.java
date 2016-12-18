




public class HelloWorld {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		
	
		System.out.println("Hello World!");
		
		Vector2d vector = new Vector2d(1.0,1.0);
		Vector2d vectorS =  new Vector2d(1.0,1.0);
		System.out.println(vector.add(vectorS));
		VectorND v1 = new VectorND (1.0,1.0,1.0);
		VectorND v2 = new VectorND (2.0,2.0,2.0);
		System.out.println(v2.scalar(v1));
		VectorND v3 = new VectorND (3.0,3.0,3.0);
		
		System.out.println(v2.scalar(v3));
		
		
	}

}
