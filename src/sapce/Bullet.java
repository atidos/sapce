package sapce;

public class Bullet extends GameObject {
	
	float deathClock = 3000f;
	float speed;
	Class<?> hitType;
	
	public Bullet(String Name, String SpritePath, Vector2 Position, float Angle, float Speed, Class<?> HitType) {
		super(Name, SpritePath, Position);
		rotation = Angle;
		speed = Speed;
		hitType = HitType;
	}
	
	public void Update(){
		
		position = new Vector2(position.x + (float)Math.cos(rotation) * speed *Main.deltaTime, position.y +  (float)Math.sin(rotation) * speed * Main.deltaTime );
		
		if(hitType != null)
		{
			Spaceship col = (Spaceship)GetCollision(hitType);
			if(col != null)
			{
				col.Hit(5);
				Destroy();
			}
		}
		
		
		
		if(deathClock < 0f)
		{
			Destroy();
		}
		
		deathClock -= Main.deltaTime;
	}
	
}
