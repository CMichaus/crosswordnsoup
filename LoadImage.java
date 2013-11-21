import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImage extends Component {
          
    BufferedImage img;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
	paintBiseccion(g);
	paintFalsaPosicion(g);
	paintMontante(g);
	paintJacobi(g);
	paintGaussJordan(g);
	paintSecante(g);
	paintNewtonRaphson(g);
	paintHaciaAdelante(g);
	paintGrafico(g);
	paintPuntoFijo(g);
    }


    public void paintBiseccion(Graphics g) {
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("B", 445, 35);
	g.drawString("I", 450, 69);
	g.drawString("S", 448, 105);
	g.drawString("E", 447, 142);
	g.drawString("C", 447, 177);
	g.drawString("C", 447, 213);
	g.drawString("I", 450, 247);
	g.drawString("O", 447, 285);
	g.drawString("N", 445, 320);
    }
    
    public void paintGaussJordan(Graphics g) {
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("G", 339, 106);
	g.drawString("A", 375, 105);
	g.drawString("U", 409, 105);
	g.drawString("S", 448, 105);
	g.drawString("S", 481, 105);
	g.drawString("J", 521, 105);
	g.drawString("O", 552, 105);
	g.drawString("R", 587, 105);
	g.drawString("D", 622, 105);
	g.drawString("A", 657, 105);
	g.drawString("N", 690, 105);	
    }
    
    public void paintMontante(Graphics g) {
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("M", 550, 70);
	g.drawString("O", 552, 105);
	g.drawString("N", 550, 141);
	g.drawString("T", 550, 178);
	g.drawString("A", 550, 214);
	g.drawString("N", 550, 247);
	g.drawString("T", 550, 285);
	g.drawString("E", 552, 320);	
    }

    public void paintPuntoFijo(Graphics g) {
	g.drawString("P", 88, 285);
	g.drawString("U", 128, 285);
	g.drawString("N", 160, 285);
	g.drawString("T", 196, 285);
	g.drawString("O", 232, 285);
	g.drawString("F", 265, 285);
	g.drawString("I", 300, 285);
	g.drawString("J", 339, 285);
	g.drawString("O", 375, 285);
    }

    public void paintSecante(Graphics g) { 
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("S", 520, 320);	
	g.drawString("E", 552, 320);	
	g.drawString("C", 587, 320);
	g.drawString("A", 622, 320);
	g.drawString("N", 657, 320);
	g.drawString("T", 695, 320);
	g.drawString("E", 730, 320);
    }

    public void paintHaciaAdelante(Graphics g) {
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("H", 18, 498);
	g.drawString("A", 52, 498);
	g.drawString("C", 88, 498);
	g.drawString("I", 128, 498);
	g.drawString("A", 160, 498);
	g.drawString("A", 196, 498);
	g.drawString("D", 232, 498);
	g.drawString("E", 265, 498);
	g.drawString("L", 300, 498);
	g.drawString("A", 339, 498);
	g.drawString("N", 375, 498);
	g.drawString("T", 410, 498);
	g.drawString("E", 446, 498);
    }

    public void paintNewtonRaphson(Graphics g) {
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("N", 18, 178);
	g.drawString("E", 18, 214);
	g.drawString("W", 18, 247);
	g.drawString("T", 18, 285);
	g.drawString("O", 18, 320);	
	g.drawString("N", 18, 353);
	g.drawString("R", 18, 390);
	g.drawString("A", 18, 428);
	g.drawString("P", 19, 462);
	g.drawString("H", 18, 498);
	g.drawString("S", 19, 533);
	g.drawString("O", 18, 571);
	g.drawString("N", 18, 604);
    }
    
    public void paintJacobi(Graphics g) {
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("J", 660, 70);
	g.drawString("A", 657, 105);
	g.drawString("C", 656, 141);
	g.drawString("O", 656, 178);
	g.drawString("B", 656, 214);
	g.drawString("I", 659, 247);

    }
    
    public void paintGrafico(Graphics g) { 
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("G", 232, 428);
	g.drawString("R", 265, 428);
	g.drawString("A", 300, 428);
	g.drawString("F", 339, 428);
	g.drawString("I", 377, 428);
	g.drawString("C", 410, 428);
	g.drawString("O", 446, 428);
    }

    public void paintFalsaPosicion(Graphics g) {
	g.setFont(new Font("Serif", Font.BOLD, 20));
	g.drawString("F", 375, 70);
	g.drawString("A", 375, 105);
	g.drawString("L", 375, 141);
	g.drawString("S", 375, 178);
	g.drawString("A", 375, 214);
	g.drawString("P", 375, 247);
	g.drawString("O", 375, 285);
	g.drawString("S", 375, 320);
	g.drawString("I", 377, 353);
	g.drawString("C", 375, 390);
	g.drawString("I", 377, 428);
	g.drawString("O", 375, 462);
	g.drawString("N", 375, 498);
    }
    


    public LoadImage(String nombre) {
       try {
           img = ImageIO.read(new File(nombre));
       } catch (IOException e) {
       }
       
    }

    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }

}
