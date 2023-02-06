package sapce;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DeathMenu extends UIBox {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel scoreText;
	public DeathMenu() {
		super();
		this.AddText("You are dead.");
		scoreText = this.AddText("Score: "+ Main.score);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton retryButton = new JButton("Retry");
		retryButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		retryButton.setAlignmentY( Component.CENTER_ALIGNMENT );
		retryButton.setBackground(new Color(1,1,1,0));
		retryButton.setFocusable(false);
		retryButton.setFont(font);
		add(retryButton);
		
		retryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Retry();
        	    setVisible(false);
            }
        });
		
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton menuButton = new JButton("Main Menu");
		menuButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		menuButton.setAlignmentY( Component.CENTER_ALIGNMENT );
		menuButton.setBackground(new Color(1,1,1,0));
		menuButton.setFocusable(false);
		menuButton.setFont(font);
		add(menuButton);
		
		menuButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.MainMenu();
                setVisible(false);
            }
        });
	}
	
	@Override
	public void Update()
	{
		super.Update();
		scoreText.setText("Score: " + Main.score);
	}

}
