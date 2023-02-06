package sapce;

public class Background extends GameObject {
	
	Vector2[] positions;
	
	public Background(String Name, String SpritePath, Vector2 Position) {
		super(Name, SpritePath, Position);
	}
	
	public Background(String Name, String SpritePath) {
		super(Name, SpritePath, new Vector2(0,0));
		
		position = new Vector2(sprite.getWidth()/2,320);
		
		positions = new Vector2[Main.waveCount];
		
		positions[0] = new Vector2(sprite.getWidth()/2,320);
		
		positions[Main.waveCount-1] = new Vector2(-sprite.getWidth()/2+900,320);
		
		for(int i = 1; i<Main.waveCount-1; i++)
		{
			positions[i] = new Vector2(sprite.getWidth()/2-(sprite.getWidth()-900)*i/(Main.waveCount-1),320);
		}
	}
	
	float slideClock = 0;
	int index = 0;
	float shake = 0;
	
	@Override
	public void Update()
	{
		super.Update();
		
		if(index > 0 && slideClock < 2000)
		{
			float distance =  - positions[index].x + positions[index-1].x;
			position.x = positions[index-1].x - (0.5f + (float)Math.sin((slideClock/2000)*Math.PI-Math.PI/2)/ 2) * distance;
		}
		else
		{
			//position.x = positions[index].x - (0.5f + (float)Math.sin((slideClock/2000)*Math.PI-Math.PI/2)/ 2) * 20;
		}
		
		if(shake > 0)
		{
			Main.camera.y =  10 * shake * (float) Math.sin(clock / 250f * shake);
			Main.camera.x =  10 * shake * (float) Math.sin(clock / 200f * shake);
			shake -= Main.deltaTime / 1000f;
		}
		
		slideClock += Main.deltaTime;
	}
	
	public void Shake(float Shake)
	{
		if(shake<Shake)
		{
			shake = Shake;
		}
	}
	
	public void NextWave()
	{
		index++;
		slideClock = 0;
	}

}
