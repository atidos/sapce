package sapce;

import sapce.Player.Powerup;

public class PowerupObject extends GameObject {
	
	Powerup powerup;
	
	public PowerupObject(String Name, String SpritePath, Vector2 Position, Powerup power) {
		super(Name, SpritePath, Position);
		
		powerup = power;
	}
	
	
	float clock = 0;
	
	public void Update(){
		
		opacity = 0.75f + (float)Math.sin(clock/200)/4f;
		
		Player col = (Player)GetCollision(Player.class);
		
		position.x += -Main.deltaTime * 0.3f;
		
		if(position.x<-10)
		{
			Destroy();
		}
		
		if(col != null)
		{
			col.SetPowerup(powerup);
			Destroy();
		}
		
		clock += Main.deltaTime;
	}

}
