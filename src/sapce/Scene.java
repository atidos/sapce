package sapce;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Scene extends JPanel implements GameClock{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    AffineTransform af = new AffineTransform();
	
	public ArrayList<GameObject> ObjectArray = new ArrayList<GameObject>(); 
	
    public Scene() {
        initBoard();
        af.setToIdentity();
        //BorderLayout bor = new BorderLayout();
        //this.setLayout(bor);
        this.setLayout(null);
    }

    private void initBoard() {
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        
        
        for(int i = 0; i < ObjectArray.size(); i++) {

			GameObject go = ObjectArray.get(i);
			BufferedImage img = go.GetSprite();
			
			/*
			for(int x = 0; x<width; x++)
			{
				for(int y = 0; y<height; y++)
				{
					Color color = new Color(img.getRGB(x, y), true);
					
					color = new Color(color.getRed()*newColor.getRed()/255,
									  color.getGreen()*newColor.getGreen()/255,
									  color.getBlue()*newColor.getBlue()/255,
									  color.getAlpha()*newColor.getAlpha()/255);
					
					img.setRGB(x, y, color.getRGB());
				}
			}
			*/
			
			AffineTransform trans = new AffineTransform();
			trans.rotate( Math.toRadians(go.GetRotation()),(go.GetPosition().x + go.GetPivot().x), (go.GetPosition().y + go.GetPivot().y));
			trans.translate((int)(go.GetPosition().x - img.getWidth()/2) - Main.camera.x, (int)(go.GetPosition().y - img.getHeight()/2) - Main.camera.y);
			trans.scale(go.GetScale().x,go.GetScale().y);
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,go.GetOpacity());
			g2d.setComposite(ac);
					
			g2d.drawImage(go.GetSprite(), trans, this);
			
	    }
    }
    
    public void Instantiate(GameObject newObject) {
    	ObjectArray.add(newObject);
    }
    
    
	@Override
	public void Start() {
		for(int i = 0; i < ObjectArray.size(); i++) {
        	GameObject go = ObjectArray.get(i);
        	go.Start();
	    }
	}
    
    @Override
    public void Update() {
        for(int i = 0; i < ObjectArray.size(); i++) {
        	GameObject go = ObjectArray.get(i);
        	go.Update();
	    }
        
        Component comps[] = this.getComponents();
        for(Component i : comps)
        {
        	if(i instanceof UIObject)
        	{
        		UIObject obj = (UIObject)i;
            	obj.Update();
        	}
        }
    }
	@Override
	public void End() {
		
	}
	
	public void Clear()
	{
		ObjectArray.clear();
	}
}