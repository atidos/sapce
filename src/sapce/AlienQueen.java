package sapce;

import java.util.Random;

public class AlienQueen extends Enemy {

	public AlienQueen(String Name, String SpritePath, Vector2 Position, int Health, boolean Barrier) {
		super(Name, SpritePath, Position, Health, Barrier);
		// TODO Auto-generated constructor stub
		fireRate = 100f;
	}
	
	boolean fire = false;
	float restTime = 2000f;
	float fireTime = 0f;
	
	int fireMode = 0;
	
	@Override
	public void Update()
	{
		super.Update();
		
		position.y = origin.y +  50 * (float) Math.sin(clock / 1000f);
		position.x = origin.x +  10 * (float) Math.sin(clock / 500f) + 1000f/(clock/100);
		
		if(sprite == sprites[1] && cooldown <= 0f)
		{
			sprite = sprites[0];
		}
		
		if(restTime<0 && !fire)
		{
			Random rand = new Random();
			fireMode = rand.nextInt(2 - 0 + 1) + 0;
			fire = true;
			fireTime = 3000f;
		}
		if(fireTime<0 && fire)
		{
			fire = false;
			restTime = 2000f;
		}
		
		if(fireCoolDown < 0 && fire)
		{
			if(fireMode == 0)
			{
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(180),0.3f,Player.class));
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(150),0.3f,Player.class));
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(210),0.3f,Player.class));
			}
			
			if(fireMode == 1)
			{
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(165),0.3f,Player.class));
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(135),0.3f,Player.class));
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(195),0.3f,Player.class));
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(225),0.3f,Player.class));

			}
			
			if(fireMode == 2)
			{
				Main.currentScene.Instantiate(new Bullet("Laser", "lazer_enemy.png", new Vector2(position.x - 40,position.y), (float)Math.toRadians(180 + Math.sin(clock/1000)*90),0.3f,Player.class));
			}


			fireCoolDown = fireRate;
		}
		
		fireTime -= Main.deltaTime;
		restTime -= Main.deltaTime;
		cooldown -= Main.deltaTime;
		fireCoolDown -= Main.deltaTime;
	}
	
	@Override
	public void Die() 
	{
		Main.score += 95;
		super.Die();
	}
}
