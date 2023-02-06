package sapce;

public class AlienSlasher extends Enemy {

	public AlienSlasher(String Name, String SpritePath, Vector2 Position, int Health, boolean Barrier) {
		super(Name, SpritePath, Position, Health, Barrier);
		// TODO Auto-generated constructor stub
	}
	
	float recoverTime = 0;
	
	@Override
	public void Update()
	{
		super.Update();
		
		Player col = (Player)GetCollision(Player.class);
		
		if(col != null && clock > recoverTime)
		{
			col.Hit(10);
			recoverTime = clock + 1000f;
		}
		
		if(sprite == sprites[1] && cooldown <= 0f)
		{
			sprite = sprites[0];
		}
		
		position.x = origin.x +  200 * (float) Math.sin(clock / 700f) + 1000f/(clock/100);
		position.y = origin.y +  200 * (float) Math.sin(clock / 700f + Math.PI/2);
		
		rotation = clock/700f * 360 % 360;
		
		cooldown -= Main.deltaTime;
	}
	
	@Override
	public void Die() 
	{
		Main.score += 5;
		super.Die();
	}
}
