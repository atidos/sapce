package sapce;

public class AlienCruiser extends Enemy {

	public AlienCruiser(String Name, String SpritePath, Vector2 Position, int Health, boolean Barrier) {
		super(Name, SpritePath, Position, Health, Barrier);
	}
	

	@Override
	public void Update()
	{
		super.Update();
		
		position.y = origin.y +  100 * (float) Math.sin(clock / 1000f);
		position.x = origin.x +  50 * (float) Math.sin(clock / 500f) + 1000f/(clock/100);
		
		if(sprite == sprites[1] && cooldown <= 0f)
		{
			sprite = sprites[0];
		}
		
		
		if(fireCoolDown < 0)
		{
			Bullet newBullet = new Bullet("Bullet", "bullet_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(180 + Math.floor(Math.random()*(1+1+1)-1)),0.3f,Player.class);
			Main.currentScene.Instantiate(newBullet);
			fireCoolDown = fireRate;
		}

		cooldown -= Main.deltaTime;
		fireCoolDown -= Main.deltaTime;
	}

	@Override
	public void Die() 
	{
		Main.score += 5;
		super.Die();
	}
}
