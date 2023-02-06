package sapce;
import java.util.ArrayList;

public class Level
{
	public class Wave
	{
		public class Entrance
		{
			public GameObject gameObject;
			public float time;
			
			public Entrance(GameObject object, float Time)
			{
				gameObject = object;
				time = Time;
			}
		}
		
		int index = 0;
		int count = 0;
		
		ArrayList<Entrance> entrances = new ArrayList<Entrance>();
		
		public void Add(Entrance entrance)
		{
			entrances.add(entrance);
			if(entrance.gameObject instanceof Enemy)
			{
				count++;
			}
		}
		
		public int GetCount()
		{
			return count;
		}
		
		public Entrance GetEntrance() throws IndexOutOfBoundsException
		{
			index++;
			return entrances.get(index-1);
		}
		
		public void Reset()
		{
			index = 0;
		}
	}
	
	int index = 0;
	int count = 0;
	
	ArrayList<Wave> waves = new ArrayList<Wave>();
	
	public void Add(Wave wave)
	{
		waves.add(wave);
		count++;
	}
	
	public Wave GetWave() throws IndexOutOfBoundsException
	{
		index++;
		return waves.get(index-1);
	}
	public int GetCount()
	{
		return count;
	}

	 
	public void Reset()
	{
		index = 0;
		for(Wave wave : waves)
		{
			wave.Reset();
		}
	}
	
}