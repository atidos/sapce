package sapce;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sapce.Player.Powerup;

public class Enemy extends Spaceship {

	float fireRate = 1000f;
	float fireCoolDown = 1000f;
	
	float animationCooldown = 50f;
	float cooldown = 50f;
	
	int barrierHealth = 20;
	Vector2 origin;
	
	Clip hitSound;
	
	public Enemy(String Name, String SpritePath, Vector2 Position, int Health, boolean Barrier) {
		super(Name, SpritePath, Position, Health);
		origin = new Vector2(Position);
		try {
			hitSound = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/sfx_enemyhit.wav"));
			hitSound.open(inputStream);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void Update()
	{
		super.Update();
	}
	
	@Override
	public void Hit(int damage)
	{
		hitSound.stop();
		hitSound.setMicrosecondPosition(0);
		hitSound.start();
		
		cooldown = animationCooldown;
		health -= damage;
		sprite = sprites[1];
		
		
		
		if(health <= 0)
		{
			Die();
		}
	}
	
	@Override
	public void Die()
	{
		if (Main.RandomBetween(0f,10f) < 3.5f) 
		{
			float rand = Main.RandomBetween(0f,4f);
			if (rand < 1f)
			{
				Main.currentScene.Instantiate(new PowerupObject("Powerup", "powerup_fast.png", position, Powerup.FAST));
			}
			else if (rand < 2f)
			{
				Main.currentScene.Instantiate(new PowerupObject("Powerup", "powerup_slow.png", position, Powerup.SLOW));
			}
			else if (rand < 3.3f)
			{
				Main.currentScene.Instantiate(new PowerupObject("Powerup", "powerup_heal.png", position, Powerup.HEAL));
			}
			else
			{
				Main.currentScene.Instantiate(new PowerupObject("Powerup", "powerup_multiple.png", position, Powerup.MULTIPLE));
			}
		}
		
		Main.score += 5;
		Main.backgroundObject.Shake(0.3f);
		Main.entranceKills++;

		super.Die();
	}
}
