package sapce;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class UIBox extends UIObject {
	
	Font font;
	
	//Icon i=new ImageIcon("image.jpg");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UIBox() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		font = loadFont("/resources/aesymatt.ttf",26f);
	}
	
	public JLabel AddText(String label)
	{
		
		JLabel jlabel = new JLabel(label);
		jlabel.setAlignmentX( Component.CENTER_ALIGNMENT );
		jlabel.setAlignmentY( Component.CENTER_ALIGNMENT );
		this.add(jlabel);
		jlabel.setForeground(Color.WHITE);
		jlabel.setFont(font);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		
		return jlabel;
	}
	
    @Override
    public void Update()
    {
    	super.Update();
    }
	
    
    public static Font loadFont(String path, float size){ 
    	Font myFont;
        try {
            InputStream fileStream = Fonts.class.getResourceAsStream(path);
            myFont = Font.createFont(Font.TRUETYPE_FONT, fileStream);
            return myFont.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
        	myFont = new Font("Verdana", Font.BOLD, 26);
            e.printStackTrace();
        }
        return null;
    }

}
