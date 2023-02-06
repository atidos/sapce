package sapce;

import javax.swing.JLayeredPane;

public class UIObject extends JLayeredPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	float clock = 0;
	public void Update() {
		clock += Main.deltaTime;
	}
}
