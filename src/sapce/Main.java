package sapce;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import javax.swing.JFrame;

import sapce.Level.Wave;
import sapce.Level.Wave.Entrance;

public class Main {

	public static float deltaTime;
	public static Scene currentScene;
	public static Level currentLevel;
	public static Wave currentWave;
	static float actionTimer = 0f;
	
	static int entranceCount;
	static int entranceKills;
	static boolean waveDone = false;
	
	static int waveCount;
	static int waveIndex;
	
	static Background backgroundObject;
	
	static int paused;
	static float timeScale = 1f;
	
	static MainMenu mainMenu;
	static HelpMenu helpMenu;
	static DeathMenu deathMenu;
	static ShipInfoBox shipInfo;
	
	public static Vector2 camera = new Vector2(0,0);
	
	static float angle;
	static float velocityX;
	static float velocityY;
	
	static GameData gameData = new GameData(false);
	static int highScore = 0;
	static int score = 0;
	
	static boolean multi = false;
	
	static int alivePlayers = 0;
	
	enum GameState
	{
		MENU,
		GAME
	}
	
	static GameState gameState;
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addKeyListener(new Inputs());
		
		
		f.setLayout(null);
		f.setSize(900,600);
		
		
		Scene scene = new Scene();
		scene.setSize(900,600);
		f.add(scene);
		
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//f.setUndecorated(true);
		
		currentScene = scene;
		
		currentLevel = gameData.levels.get(0);
		waveCount = currentLevel.GetCount();
		waveIndex = 0;

		currentWave = currentLevel.GetWave();
		entranceCount = currentWave.GetCount();
		entranceKills = 0;
		
		backgroundObject = new Background("Background", "level_0.png");
		scene.Instantiate(backgroundObject);
		
		mainMenu = new MainMenu();

		scene.add(mainMenu);
		mainMenu.setSize(900,600);
		mainMenu.setLocation(0,100);
		
		helpMenu = new HelpMenu();
		
		scene.add(helpMenu);
		helpMenu.setSize(900,600);
		helpMenu.setLocation(0,100);
		helpMenu.setVisible(false);
		
		shipInfo = new ShipInfoBox();
		shipInfo.setBounds(450,530,900,600);
		scene.add(shipInfo);
		
		ProgressionBox progInfo = new ProgressionBox();
		progInfo.setBounds(5,5,900,600);
		scene.add(progInfo);
		
		deathMenu = new DeathMenu();
		deathMenu.setSize(900,600);
		deathMenu.setLocation(0,200);
		scene.add(deathMenu);
		deathMenu.setVisible(false);
		
		f.setVisible(true);

		MainMenu();
		
		Instant lastFrame = Instant.now();
		
		while(true) {
			
			if (actionTimer < 0f && (!waveDone || entranceKills>=entranceCount) && gameState == GameState.GAME)
			{
				Action();
			}
				
			currentScene.Update();
			currentScene.repaint();
			
			deltaTime = ((float)Duration.between(lastFrame, Instant.now()).toNanos())/(float)1000000 * timeScale;
			lastFrame = Instant.now();
			actionTimer -= deltaTime;
		}
	}
	
	public static void StartLevel(int level, boolean multi)
	{
		alivePlayers = 0;
		shipInfo.clock = 0;
		score = 0;
		currentScene.Clear();
		gameData = new GameData(multi);
		
		currentLevel = gameData.levels.get(level);
		waveCount = currentLevel.GetCount();
		waveIndex = 0;
		
		waveDone = false;
		
		currentWave = currentLevel.GetWave();
		entranceCount = currentWave.GetCount();
		entranceKills = 0;
		
		backgroundObject = new Background("Background", "level_0.png");
		currentScene.Instantiate(backgroundObject);
		gameState = GameState.GAME;
	}
	
	public static void Action()
	{
		try 
		{
			try
			{
				Entrance entrance = currentWave.GetEntrance();
				currentScene.Instantiate(entrance.gameObject);
				actionTimer = entrance.time;
			}
			catch(Exception e)
			{
				waveDone = true;
				if(entranceKills>=entranceCount)
				{
					waveIndex += 1;
					currentWave = currentLevel.GetWave();
					entranceCount = currentWave.GetCount();
					entranceKills = 0;
					waveDone = false;
					backgroundObject.NextWave();
				}
			}
		}
		catch(Exception e)
		{
			if(score>highScore)
			{
				highScore = score;
			}
			MainMenu();
		}
		
	}
	
	public static void MainMenu()
	{
		gameState = GameState.MENU;
		mainMenu.setVisible(true);
	}
	
	public static void Play()
	{
		multi = false;
		StartLevel(0,multi);
	}
	
	public static void MultiPlay()
	{
		multi = true;
		StartLevel(0,multi);
	}
	
	public static void Retry()
	{
		StartLevel(0,multi);
	}
	
	public static void Death()
	{
		if(score>highScore)
		{
			highScore = score;
		}
		gameState = GameState.MENU;
		deathMenu.setVisible(true);
	}
	
	public static void Help()
	{
		helpMenu.setVisible(true);
	}
	
	public static float RandomBetween(float leftLimit, float rightLimit) {
	    return leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
	}
}
