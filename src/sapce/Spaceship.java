package sapce;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Spaceship extends GameObject {
	
	public int health;
	BufferedImage[] sprites = new BufferedImage[2];
	
	public Spaceship(String Name, String SpritePath, Vector2 Position, int Health) {
		super(Name,SpritePath+"_0.png",Position);
		try {
			sprites[0] = ImageIO.read(getClass().getResource("/resources/"+SpritePath+"_0.png"));
			sprites[1] = ImageIO.read(getClass().getResource("/resources/"+SpritePath+"_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		health = Health;
	}
	
	@Override
	public void Update() {
		super.Update();
	}
	
	@Override
	public void Start() {
	}
	
	public void Hit(int damage)
	{
		
	}
	
	@Override
	public void Die()
	{
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		Main.currentScene.Instantiate(new Particle("Particle","particle.png",position,(float)Math.PI*2*Main.RandomBetween(0,1),Main.RandomBetween(0.3f,0.5f)));
		
		Destroy();
	}

}
