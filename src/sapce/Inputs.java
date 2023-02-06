package sapce;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Inputs implements KeyListener{
	
	public static boolean UP;
	public static boolean DOWN;
	public static boolean LEFT;
	public static boolean RIGHT;
	public static boolean FIRE;
	
	public static boolean UP2;
	public static boolean DOWN2;
	public static boolean LEFT2;
	public static boolean RIGHT2;
	public static boolean FIRE2;
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
            UP = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            DOWN = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	LEFT = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	RIGHT = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            FIRE = true;
        }
		if (e.getKeyCode() == KeyEvent.VK_W) {
            UP2 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DOWN2 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
        	LEFT2 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
        	RIGHT2 = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            FIRE2 = true;
        }
        
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
            UP = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            DOWN = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	LEFT = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	RIGHT = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            FIRE = false;
        }
		if (e.getKeyCode() == KeyEvent.VK_W) {
            UP2 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DOWN2 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
        	LEFT2 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
        	RIGHT2 = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            FIRE2 = false;
        }
		
	}

}
