package sapce;
public class Particle extends Bullet {

	public Particle(String Name, String SpritePath, Vector2 Position, float Angle, float Speed) {
		super(Name, SpritePath, Position,Angle,Speed,null);
		float s = Main.RandomBetween(0.5f,1.5f);
		scale.x = s;
		scale.y = s;
	}
	
	
	public void Update()
	{
		super.Update();
		if(speed > 0f)
		{
			speed -= Main.deltaTime / 2000;
		}
		
		scale.x -= Main.deltaTime / 500;
		scale.y -= Main.deltaTime / 500;
		if(scale.x < 0.1f)
		{
			Destroy();
		}
	}

}
