package sapce;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameObject implements GameClock {
	
	String name;
	BufferedImage sprite;
	Vector2 position;
	
	Vector2 pivot;
	float rotation = 0;
	
	float opacity = 1;
	
	float clock = 0;
	
	Vector2 scale;
	
	boolean started = false;
	
	public GameObject(String Name, String SpritePath, Vector2 Position) {
		
		name = Name;
		try {
			sprite = ImageIO.read(getClass().getResource("/resources/" +SpritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pivot = new Vector2(0,0);
		scale = new Vector2(1,1);
		position = Position;
	
	}


	public Vector2 GetPosition() {
		return position;
	}
	
	public Vector2 GetPivot() {
		return pivot;
	}
	
	public BufferedImage GetSprite() {
		return sprite;
	}
	
	public String GetName() {
		return name;
	}
	
	public float GetRotation() {
		return rotation;
	}
	
	public float GetOpacity() {
		return opacity;
	}
	
	public Vector2 GetScale() {
		return scale;
	}
	
	
	public void Destroy() {
		Main.currentScene.ObjectArray.remove(this);
	}
	
	@Override
	public void Start() {
		
	}
	
	@Override
	public void Update() {
		if(!started)
		{
			Start();
			started = true;
		}
		clock += Main.deltaTime;
	}
	
	@Override
	public void End() {
		
	}
	
	public GameObject GetCollision(Class<?> cls) {
		for(int i=0; i< Main.currentScene.ObjectArray.size(); i++)
		{
			GameObject go = Main.currentScene.ObjectArray.get(i);
			if(cls.isAssignableFrom(go.getClass()) &&
		       Math.sqrt((position.y-go.GetPosition().y)*(position.y-go.GetPosition().y)
						+(position.x-go.GetPosition().x)*(position.x-go.GetPosition().x)) <= go.GetSprite().getHeight()/2)
			{
				GameObject target = (GameObject)go;
				return target;
			}
		}
		return null;
	}
	
	public void Die()
	{
		Destroy();
	}
}
