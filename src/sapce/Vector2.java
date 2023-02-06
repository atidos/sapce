package sapce;


public class Vector2 {
	
	public float x;
	public float y;
	
	public Vector2(float posx, float posy) {
		x = posx;
		y = posy;
	}
	
	public Vector2(Vector2 vector) {
		x = vector.x;
		y = vector.y;
	}

}
