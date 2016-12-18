import static org.junit.Assert.*;


public class Test {

	
	
	@org.junit.Test
	public void test() {
		//assertEquals(4,5);
		
		VectorND v1 = new VectorND (1.0,1.0,1.0,1.0);
		VectorND v2 = new VectorND (2.0,2.0,2.0,2.0);
		VectorND v3 = new VectorND (3.0,3.0,3.0,3.0);
		
		assertEquals(v3, new VectorND (3.0,3.0,3.0,3.0));
		assertEquals(v1.add(v2), new VectorND (3.0,3.0,3.0,3.0));
		assertEquals(Math.abs(v2.scalar(v1)-8.0)<0.000001, true);
		assertEquals(v3.sub(v1), new VectorND (2.0,2.0,2.0,2.0));
		
		
		Vector2d v4 = new Vector2d (1.0,1.0);
		Vector2d v5 = new Vector2d (2.0,2.0);
		Vector2d v6 = new Vector2d (3.0,3.0);
		
		assertEquals(v6, new Vector2d (3.0,3.0));
		assertEquals(v4.add(v5), new Vector2d (3.0,3.0));
		assertEquals(Math.abs(v5.scalar(v4)-4.0)<0.000001, true);
		assertEquals(v6.sub(v4), new Vector2d (2.0,2.0));
		
		Vector3d v7 = new Vector3d (1.0,1.0,1.0);
		Vector3d v8 = new Vector3d (2.0,2.0,2.0);
		Vector3d v9 = new Vector3d (3.0,3.0,3.0);
		
		assertEquals(v9, new Vector3d (3.0,3.0,3.0));
		assertEquals(v7.add(v8), new Vector3d (3.0,3.0,3.0));
		assertEquals(Math.abs(v8.scalar(v7)-6.0)<0.000001, true);
		assertEquals(v9.sub(v7), new Vector3d (2.0,2.0,2.0));
		
		
		
	}
}