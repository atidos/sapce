package sapce;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainMenu extends UIBox {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel scoreText;
	public MainMenu() {
		super();
		JLabel title = this.AddText(". Void Predators .");
		title.setFont(font.deriveFont(Font.PLAIN, 35f));
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		scoreText = this.AddText("High Score: " + Main.highScore);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton playButton = new JButton("Play");
		playButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		playButton.setAlignmentY( Component.CENTER_ALIGNMENT );
		playButton.setBackground(new Color(1,1,1,0));
		playButton.setFocusable(false);
		playButton.setFont(font);
		add(playButton);
		
		playButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	Main.Play();
        		setVisible(false);
            }
        });
		
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton multiButton = new JButton("Multiplayer");
		multiButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		multiButton.setAlignmentY( Component.CENTER_ALIGNMENT );
		multiButton.setBackground(new Color(1,1,1,0));
		multiButton.setFocusable(false);
		multiButton.setFont(font);
		add(multiButton);
		
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		multiButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.MultiPlay();
                setVisible(false);
            }
        });
		
		JButton helpButton = new JButton("Controls");
		helpButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		helpButton.setAlignmentY( Component.CENTER_ALIGNMENT );
		helpButton.setBackground(new Color(1,1,1,0));
		helpButton.setFocusable(false);
		helpButton.setFont(font);
		add(helpButton);
		
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		helpButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Help();
                setVisible(false);
            }
        });
		
		JButton quitButton = new JButton("Quit");
		quitButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		quitButton.setAlignmentY( Component.CENTER_ALIGNMENT );
		quitButton.setBackground(new Color(1,1,1,0));
		quitButton.setFocusable(false);
		quitButton.setFont(font);
		add(quitButton);
		
		quitButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}
	
	@Override
	public void Update()
	{
		super.Update();
		scoreText.setText("Highscore: " + Main.highScore);
		Component comps[] = this.getComponents();
	       for(int i = 0; i<comps.length; i++)
	       {
	        	comps[i].setForeground( new Color(1, 1, 1, 0.70f + (float)Math.sin(clock/500+i/2)/4f));
	       }
	}

}
