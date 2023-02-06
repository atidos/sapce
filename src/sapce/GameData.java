package sapce;
import java.util.ArrayList;
import sapce.Level.Wave;
import sapce.Player.Powerup;

public class GameData {
	
	public ArrayList<Level> levels = new ArrayList<Level>();
	
	public GameData(boolean multi) {
		
		int diff = 1;
		
		levels.clear();
		
		Level level = new Level();
		
		Wave newWave = level.new Wave();
		
		newWave.Add(newWave.new Entrance(new Player1("Player", "player", new Vector2(50,50), 100),0f));
		if(multi)
		{
			newWave.Add(newWave.new Entrance(new Player2("Player2", "player2", new Vector2(50,500), 100),0f));
			diff = 2;
		}

		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(600,200), 70*diff, false),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(700,300), 70*diff, false),1000f));
		
		level.Add(newWave);
		
		newWave = level.new Wave();
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(600,100), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(600,150), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(600,200), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(600,400), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(600,450), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(600,500), 70*diff, false),500f));
		
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(600,200), 70*diff, false),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(700,300), 70*diff, false),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(800,400), 70*diff, false),1000f));
		
		level.Add(newWave);
		
		newWave = level.new Wave();
		newWave.Add(newWave.new Entrance(new AlienSlasher("AlienSlasher", "alien_slasher", new Vector2(300,200), 50*diff, true),1000f));
		newWave.Add(newWave.new Entrance(new AlienSlasher("AlienSlasher", "alien_slasher", new Vector2(300,300), 50*diff, true),1000f));
		newWave.Add(newWave.new Entrance(new AlienSlasher("AlienSlasher", "alien_slasher", new Vector2(300,400), 50*diff, true),1000f));
		
		level.Add(newWave);
		
		newWave = level.new Wave();
		newWave.Add(newWave.new Entrance(new AlienSiren("AlienSiren", "alien_siren", new Vector2(600,200), 150*diff, true),1000f));
		newWave.Add(newWave.new Entrance(new AlienSiren("AlienSiren", "alien_siren", new Vector2(800,400), 150*diff, true),1000f));
		
		level.Add(newWave);
		
		newWave = level.new Wave();
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(450,275), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(450,325), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienSiren("AlienSiren", "alien_siren", new Vector2(600,300), 150*diff, true),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,200), 70*diff, false),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(700,300), 70*diff, false),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,400), 70*diff, false),1000f));
		
		level.Add(newWave);
		
		newWave = level.new Wave();
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(450,175), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(450,225), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(450,375), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienBarrier("AlienBarrier", "alien_barrier", new Vector2(450,425), 70*diff, false),500f));
		newWave.Add(newWave.new Entrance(new AlienSiren("AlienSiren", "alien_siren", new Vector2(600,200), 150*diff, true),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(700,400), 70*diff, false),1000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,500), 70*diff, false),1000f));
		newWave.Add(newWave.new Entrance(new AlienSlasher("AlienSlasher", "alien_slasher", new Vector2(300,200), 50*diff, true),500f));
		newWave.Add(newWave.new Entrance(new AlienSlasher("AlienSlasher", "alien_slasher", new Vector2(300,400), 50*diff, true),500f));
		
		level.Add(newWave);
		
		newWave = level.new Wave();
		newWave.Add(newWave.new Entrance(new PowerupObject("Powerup", "powerup_heal.png", new Vector2(1000,300), Powerup.HEAL),3000f));
		newWave.Add(newWave.new Entrance(new AlienQueen("AlienQueen", "alien_queen", new Vector2(600,300), 2000*diff, true),3000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,200), 70*diff, false),5000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,400), 70*diff, false),5000f));
		newWave.Add(newWave.new Entrance(new PowerupObject("Powerup", "powerup_heal.png", new Vector2(1000,200), Powerup.HEAL),3000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,200), 70*diff, false),5000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,400), 70*diff, false),5000f));
		newWave.Add(newWave.new Entrance(new PowerupObject("Powerup", "powerup_heal.png", new Vector2(1000,400), Powerup.HEAL),3000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,200), 70*diff, false),5000f));
		newWave.Add(newWave.new Entrance(new AlienCruiser("AlienCruiser", "alien_cruiser", new Vector2(500,400), 70*diff, false),5000f));
		
		level.Add(newWave);
		levels.add(level);
	}

	
}
