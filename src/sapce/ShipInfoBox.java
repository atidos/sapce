package sapce;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JLabel;

public class ShipInfoBox extends UIBox {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel label;

	DecimalFormat df = new DecimalFormat("0.00");
	
	public ShipInfoBox() 
	{
		super();
		label = new JLabel("VelocityX = 0 VelocityY = 0  Angle = 0");
		label.setFont(font.deriveFont(16f));
		label.setForeground(new Color(0.3f,1,0.7f,0.2f));
		this.add(label);

    };
        
    @Override
    public void Update()
    {
    	super.Update();
    	label.setText("VelocityX = "+ Main.velocityX + " VelocityY = " + Main.velocityY + " Angle = " + df.format(Main.angle) + " Time = " + df.format(clock/1000f));
    }
}
