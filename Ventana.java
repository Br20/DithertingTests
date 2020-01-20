package Clases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;

public class Ventana {

	private JFrame frame;
	private PanelconFondo original, dithering1, dithering2;
	private BufferedImage origin,dither1,dither2;
	private final int [][] matOrdenada = {{8,3,4},{6,1,2},{7,5,9}};
	private final int [][] matDispersa = {{1,7,4},{5,8,3},{6,2,9}};
	private final int  num = 28;
	private JPanel fondo;




	public Ventana() {
		initialize();
	}


	@SuppressWarnings("static-access")
	private void initialize() {
		
		//inicializacion ventana
		frame = new JFrame();
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		
		//inicializacion paneles de imagenes
		original = new PanelconFondo("../Imagenes/lena.jpg");
		original.setBounds(458, 0, 458, 588);
		original.setBackground(Color.DARK_GRAY);
		original.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		origin = original.getImage();
		frame.getContentPane().setLayout(null);
		


		dither1 = new BufferedImage(origin.getWidth(),origin.getHeight(),origin.getType());
		dithering1 = new PanelconFondo();
		dithering1.setBounds(0, 0, origin.getWidth(),origin.getHeight());
		dithering1.setBackground(Color.GRAY);
		dithering1.setImage(dither1);
		dithering1.setVisible(true);
		dithering1.setLayout(null);
		
		dither2 = new BufferedImage(origin.getWidth(),origin.getHeight(),origin.getType());
		dithering2 = new PanelconFondo();
		dithering2.setBounds(0, 0, origin.getWidth(), origin.getHeight());
		dithering2.setBackground(Color.GRAY);
		dithering2.setImage(dither2);
		dithering2.setVisible(true);
		dithering2.setLayout(null);
		dithering2.repaint();
		
		//this.ditheringDispYOrd(matOrdenada,dither1);
		//this.ditheringDispYOrd(matDispersa,dither2);
		//this.ditheringError(dither1);
		//this.ditheringAzar(dither2);
		this.ditheringPromedio(dither2);
		
		fondo = new JPanel();
		fondo.setLocation(0, 0);
		fondo.setBackground(Color.GRAY);
		fondo.setVisible(true);
		fondo.setSize(new Dimension(1500, 700));
		fondo.setLayout(null);
		//fondo.add(dithering1);
		fondo.add(original);
		fondo.add(dithering2);
		frame.getContentPane().add(fondo);


	}
	
	public void ditheringDispYOrd(int [][] mat, BufferedImage im) {
		Color col;
		int ancho = origin.getWidth();
		int alto = origin.getHeight();
		int div = 0;
		int rgb;
		for (int j = 0; j <= ancho - 1; j = j + 3) {
			for(int i = 0; i <= alto - 1; i = i + 3) {
				
					//OVV
					//VVV
					//VVV
					rgb = origin.getRGB(j, i);
					col = new Color(rgb);
					div = col.getBlue() / num;
					if (div < mat[0][0]) {
						im.setRGB(j, i, new Color(0,0,0).getRed());
					} else im.setRGB(j, i, new Color(255,255,255).getRGB());
					
					//VVV
					//OVV
					//VVV
					if(i + 1 <= alto - 1) {
						rgb = origin.getRGB(j, i+1);
						col = new Color(rgb);
						div = col.getBlue() / num;
						if (div < mat[1][0]) {
							im.setRGB(j, i+1, new Color(0,0,0).getRed());
						} else im.setRGB(j, i+1, new Color(255,255,255).getRGB());
					}
					//VOV
					//VVV
					//VVV
					if (j + 1 <= ancho - 1) {
						rgb = origin.getRGB(j+1, i);
						col = new Color(rgb);
						div = col.getBlue() / num;
						if (div < mat[0][1]) {
							im.setRGB(j+1, i, new Color(0,0,0).getRed());
						} else im.setRGB(j+1, i, new Color(255,255,255).getRGB());
					}
					//VVV
					//VOV
					//VVV
					if ((j + 1 <= ancho - 1) && (i + 1 <= alto -1) ) {
						rgb = origin.getRGB(j+1, i+1);
						col = new Color(rgb);
						div = col.getBlue() / num;
						if (div < mat[1][1]) {
							im.setRGB(j+1, i+1, new Color(0,0,0).getRed());
						} else im.setRGB(j+1, i+1, new Color(255,255,255).getRGB());
					}
					//VVV
					//VVV
					//OVV
					if(i + 2 <= alto - 1) {
						rgb = origin.getRGB(j, i+2);
						col = new Color(rgb);
						div = col.getRed() / num;
						if (div < mat[2][0]) {
							im.setRGB(j, i+2, new Color(0,0,0).getRed());
						} else im.setRGB(j, i+2, new Color(255,255,255).getRGB());
					}
					//VVO
					//VVV
					//VVV
					if (j + 2 <= ancho - 1) {
						rgb = origin.getRGB(j+2, i);
						col = new Color(rgb);
						div = col.getRed() / num;
						if (div < mat[0][2]) {
							im.setRGB(j+2, i, new Color(0,0,0).getRed());
						} else im.setRGB(j+2, i, new Color(255,255,255).getRGB());
					}
					//VVV
					//VVV
					//VVO
					if ((j + 2 <= ancho - 1) && (i + 2 <= alto -1) ) {
						rgb = origin.getRGB(j+2, i+2);
						col = new Color(rgb);
						div = col.getRed() / num;
						if (div < mat[2][2]) {
							im.setRGB(j+2, i+2, new Color(0,0,0).getRed());
						} else im.setRGB(j+2, i+2, new Color(255,255,255).getRGB());
					}
					//VVV
					//VVO
					//VVV
					if ((j + 2 <= ancho - 1) && (i + 1 <= alto -1) ) {
						rgb = origin.getRGB(j+2, i+1);
						col = new Color(rgb);
						div = col.getRed() / num;
						if (div < mat[1][2]) {
							im.setRGB(j+2, i+1, new Color(0,0,0).getRed());
						} else im.setRGB(j+2, i+1, new Color(255,255,255).getRGB());
					}
					//VVV
					//VVV
					//VOV
					if ((j + 1 <= ancho - 1) && (i + 2 <= alto -1) ) {
						rgb = origin.getRGB(j+1, i+2);
						col = new Color(rgb);
						div = col.getRed() / num;
						if (div < mat[2][1]) {
							im.setRGB(j+1, i+2, new Color(0,0,0).getRed());
						} else im.setRGB(j+1, i+2, new Color(255,255,255).getRGB());
					}
			}
		}
	}

	
	public void ditheringError(BufferedImage im) {
		int alto = origin.getHeight();
		int ancho = origin.getWidth();
		int valor, rgb;
		int error = 0;
		Color col;
		for (int j = 0; j <= ancho - 1; j++) {
			for(int i = 0; i <= alto - 1; i++) {
				rgb = origin.getRGB(j, i);
				col = new Color(rgb);
				valor = col.getRed();
				valor = valor + error;
				if (valor >= 127.5 ) { //nearest to white
					error = valor - 255;
					im.setRGB(j, i, new Color(255,255,255).getRGB());
				}else {//nearest to black
					error = valor;
					im.setRGB(j, i, new Color(0,0,0).getRGB());
				}
			}
		}	
		
	}
	
	
	public void ditheringAzar(BufferedImage im ) {
		int alto = origin.getHeight();
		int ancho = origin.getWidth();
		int valor, rgb;
		Color col;
		int random;
		for (int j = 0; j <= ancho - 1; j++) {
			for(int i = 0; i <= alto - 1; i++) {
				rgb = origin.getRGB(j, i);
				col = new Color(rgb);
				valor = col.getRed();
				random = (int) Math.floor(Math.random()*255);
				if (random > valor) {
					im.setRGB(j, i, new Color(0,0,0).getRGB());
				}else 
					im.setRGB(j, i, new Color(255,255,255).getRGB());
			}
		}
	}
	
	
	public void ditheringPromedio(BufferedImage im) {
		int umbral;
		int alto = origin.getHeight();
		int ancho = origin.getWidth();
		int valor, rgb;
		Color col;
		int suma = 0;
		int pixels = alto * ancho;
		for (int j = 0; j <= ancho - 1; j++) {
			for(int i = 0; i <= alto - 1; i++) {
				rgb = origin.getRGB(j, i);
				col = new Color(rgb);
				valor = col.getRed();
				suma = suma + valor;
			}
		}
		umbral = suma / pixels;
		for (int j = 0; j <= ancho - 1; j++) {
			for(int i = 0; i <= alto - 1; i++) {
				rgb = origin.getRGB(j, i);
				col = new Color(rgb);
				valor = col.getRed();

				if (umbral < valor) {
					im.setRGB(j, i, new Color(255,255,255).getRGB());
				}else 
					im.setRGB(j, i, new Color(0,0,0).getRGB());
			}
		}
	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
}
