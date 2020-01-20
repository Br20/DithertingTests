package Clases;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PanelconFondo extends JPanel{

	private static final long serialVersionUID = 1L;
	private BufferedImage im;
	private String asd;
	
	public PanelconFondo() {
		im = null;
	}
	
	public PanelconFondo(String ruta) {
		try{
			this.im = ImageIO.read(getClass().getResource(ruta));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void setImage(BufferedImage imagen) {
		this.im = imagen;
	}


	public void setImage (String ruta){
		try {
			this.im = ImageIO.read(getClass().getResource(ruta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
	
	public int getWidthImage() {
		return this.im.getWidth();
	}
	
	public int getHeightImage() {
		return this.im.getHeight();
	}
	
	public BufferedImage getImage() {
		return this.im;
	}
	
	public void paint(Graphics g) {
		if (im!=null){
			g.drawImage(im, 0, 0, getWidth(), getHeight(),this);
        	setOpaque(false);
        }
        else {
        	setOpaque(true);
        }
		super.paint(g);
		repaint();
	}
}
