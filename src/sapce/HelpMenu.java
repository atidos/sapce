package sapce;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

public class HelpMenu extends UIBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpMenu() {
		super();
		this.AddText(" Player1 Controls");
		this.AddText("Movement: Arrow Keys");
		this.AddText("Fire: Space");
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.AddText(" Player2 Controls");
		this.AddText("Movement: W,A,S,D");
		this.AddText("Fire: Ctrl");
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		JButton menuButton = new JButton("Back To Menu");
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

}
