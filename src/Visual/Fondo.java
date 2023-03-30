package Visual;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {

	public Fondo() {

	}
	
	@Override
	public void paint(Graphics g) {
		ImageIcon imagen=new ImageIcon(getClass().getResource("/Img/fondo.jpg"));
		
		g.drawImage(imagen.getImage(), 0, 0,getWidth(),getHeight(),this);
		
		setOpaque(false);
		
		super.paint(g);
	}

}
