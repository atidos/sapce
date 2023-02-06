package sapce;


public class Player2 extends Player {
	
	public Player2(String Name, String SpritePath, Vector2 Position, int Health){
		super(Name, SpritePath, Position, Health);
	}
	
	@Override
	public void Update() {
		
		super.Update();
		
		position.y = origin.y +  10 * (float) Math.sin(clock / 1000f);
		position.x = origin.x +  10 * (float) Math.sin(clock / 500f);
		
		float speed = 0.4f;
		
		if(powerup == Powerup.FAST)
		{
			speed = 1f;
		}
		else if(powerup == Powerup.SLOW)
		{
			speed = 0.3f;
		}
		
		if(Inputs.UP2 && position.y>0)
		{
			origin.y -= speed * Main.deltaTime;
			sprite = animationSprites[0];
			if(rotation>-30)
			{
				rotation -= Main.deltaTime / 1000 * 70;
			}

			Main.velocityY = 1;
		}
		if(Inputs.DOWN2  && position.y<550)
		{
			origin.y += speed * Main.deltaTime;
			sprite = animationSprites[1];
			if(rotation<30)
			{
				rotation += Main.deltaTime / 1000 * 70;
			}
			
			Main.velocityY = -1;
		}
		
		if(!(Inputs.UP2 ^ Inputs.DOWN2))
		{
			sprite = sprites[0];
			
			if(!(rotation<1 && rotation>-1))
			{
				rotation -= Math.signum(rotation) *  Main.deltaTime / 1000 * 70;
			}

			Main.velocityY = 0;
		}
		

		Main.velocityX = 0;
		
		if(Inputs.LEFT2 && position.x>0)
		{
			origin.x -= speed * Main.deltaTime;

			Main.velocityY = -1;
		}
		if(Inputs.RIGHT2 && position.x<450)
		{
			origin.x += speed * Main.deltaTime;

			Main.velocityY = 1;
		}
		
		if(Inputs.FIRE2 && fireCoolDown < 0)
		{
			//fireSound.stop();
			//fireSound.setMicrosecondPosition(0);
			//fireSound.start();
			Main.backgroundObject.Shake(0.1f);
			if(powerup == Powerup.MULTIPLE)
			{
				Main.currentScene.Instantiate(new Bullet("Bullet", "bullet_player2.png", new Vector2(position.x + 40,position.y), (float)Math.toRadians(rotation + 4),1,Enemy.class));
				Main.currentScene.Instantiate(new Bullet("Bullet", "bullet_player2.png", new Vector2(position.x + 40,position.y), (float)Math.toRadians(rotation - 4),1,Enemy.class));
				Main.currentScene.Instantiate(new Bullet("Bullet", "bullet_player2.png", new Vector2(position.x + 40,position.y), (float)Math.toRadians(rotation),1,Enemy.class));
			}
			else
			{
				Main.currentScene.Instantiate(new Bullet("Bullet", "bullet_player2.png", new Vector2(position.x + 40,position.y), (float)Math.toRadians(rotation + Math.floor(Math.random()*(1+1+1)-1)),1,Enemy.class));
			}
			
			fireCoolDown = fireRate;
		}
		
		if(sprite == sprites[0] && !(cooldown <= 0f))
		{
			sprite = sprites[1];
		}
		
		if(powerup != Powerup.NONE && powerupTime <= 0f)
		{
			powerup = Powerup.NONE;
		}
		
		if(powerup != Powerup.NONE && slowTime <= 0f)
		{
			Main.timeScale = 1f;
		}
		
		
		healthBar.position = new Vector2(position.x + healthBar.GetSprite().getWidth() * (100 - health)/200f, position.y-32);
		
		
		Main.angle = rotation;
		
		fireCoolDown -= Main.deltaTime;
		cooldown -= Main.deltaTime;
		powerupTime -= Main.deltaTime;
		slowTime -= Main.deltaTime;
	}
}
