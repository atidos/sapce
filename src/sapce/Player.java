package sapce;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player extends Spaceship {
	
	float fireRate = 100f;
	float fireCoolDown = 0.3f;

	float animationCooldown = 100f;
	float cooldown = 50f;
	
	Vector2 origin;
	
	BufferedImage[] animationSprites = new BufferedImage[2];
	
	GameObject healthBar;
	
	BufferedImage[] healthBarSprites = new BufferedImage[3];
	
	Clip hitSound;
	Clip fireSound;
	Clip powerupSound;
	
	enum Powerup {
	    MULTIPLE,
	    FAST,
	    SLOW,
	    HEAL,
	    NONE
	  }
	
	Powerup powerup = Powerup.NONE;
	
	float powerupTime = 0;
	float slowTime = 0;
	
	public Player(String Name, String SpritePath, Vector2 Position, int Health){
		super(Name, SpritePath, Position, Health);
		try {
			animationSprites[0] = ImageIO.read(getClass().getResource("/resources/"+SpritePath+"_2.png"));
			animationSprites[1] = ImageIO.read(getClass().getResource("/resources/"+SpritePath+"_3.png"));
			
			healthBarSprites[0] = ImageIO.read(getClass().getResource("/resources/health_high.png"));
			healthBarSprites[1] = ImageIO.read(getClass().getResource("/resources/health_medium.png"));
			healthBarSprites[2] = ImageIO.read(getClass().getResource("/resources/health_low.png"));
			
			hitSound = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/sfx_playerhit.wav"));
			hitSound.open(inputStream);
			
			fireSound = AudioSystem.getClip();
			inputStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/sfx_fire.wav"));
			fireSound.open(inputStream);
			
			powerupSound = AudioSystem.getClip();
			inputStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/sfx_powerup.wav"));
			powerupSound.open(inputStream);
			
		} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		origin = new Vector2(Position);
		pivot.x = sprite.getWidth()/2;
		Main.alivePlayers += 1;
	}
	
	@Override
	public void Start() {
		healthBar = new GameObject("Health Bar","health_high.png", new Vector2(position.x, position.y-32));
		healthBar.opacity = 0.5f;
		Main.currentScene.Instantiate(healthBar);
	}
	
	@Override
	public void Update() {
		super.Update();
	}
	
	@Override
	public void End() {
		
	}
	
	@Override
	public void Hit(int damage)
	{
		hitSound.stop();
		hitSound.setMicrosecondPosition(0);
		hitSound.start();
		
		Main.backgroundObject.Shake(0.3f);
		cooldown = animationCooldown;
		
		AddHealth(-damage);
		
		if(health <= 0)
		{
			Die();
		}
	}
	
	public void SetPowerup(Powerup power)
	{
		powerupSound.stop();
		powerupSound.setMicrosecondPosition(0);
		powerupSound.start();
		
		powerup = power;
		powerupTime = 6000f;
		
		if(power == Powerup.HEAL)
		{
			AddHealth(20);
		}
		if(power == Powerup.FAST)
		{
			slowTime = 4000f;
			Main.timeScale = 0.5f;
		}
	}
	
	@Override
	public void Die()
	{
		Main.backgroundObject.Shake(1.5f);
		Main.alivePlayers -= 1;
		if(Main.alivePlayers <= 0)
		{
			Main.Death();
		}
		super.Die();
	}
	
	public void AddHealth(int i)
	{
		health += i;
		healthBar.scale = new Vector2(health/100f,1);
		
		if(health > 50)
		{
			healthBar.sprite = healthBarSprites[0];
		}
		else if(health > 25)
		{
			healthBar.sprite = healthBarSprites[1];
		}
		else
		{
			healthBar.sprite = healthBarSprites[2];
		}
	}
}
