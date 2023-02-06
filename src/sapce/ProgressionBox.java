package sapce;

import java.awt.Color;

import javax.swing.JLabel;

public class ProgressionBox extends UIBox {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel label;
	
	public ProgressionBox() 
	{
		super();
		label = new JLabel("");
		label.setFont(font.deriveFont(16f));
		label.setForeground(new Color(0.3f,1,0.7f,0.7f));
		this.add(label);

    };
        
    @Override
    public void Update()
    {
    	label.setText("Level: "+ (Main.waveIndex + 1) + " Score: " + Main.score);
    }
}
