package sapce;

public class AlienBarrier extends Enemy {

	public AlienBarrier(String Name, String SpritePath, Vector2 Position, int Health, boolean Barrier) {
		super(Name, SpritePath, Position, Health, Barrier);
	}
	
	@Override
	public void Update()
	{
		super.Update();
		
		if(sprite == sprites[1] && cooldown <= 0f)
		{
			sprite = sprites[0];
		}
		
		position.x = origin.x +  10 * (float) Math.sin(clock / 500f) + 1000f/(clock/100);
		
		cooldown -= Main.deltaTime;
	}
	
}
