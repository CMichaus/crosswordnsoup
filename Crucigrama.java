import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Crucigrama extends JFrame {
    private LoadImage crucigrama;
    private JLabel score, tiempoRestante;
    private JTextArea pregunta, respuesta;
    private JButton comprobarRespuesta, salir;
    private String preguntas[] = {"Pregunta 1", "Pregunta 2", "Pregunta 3", "Pregunta 4"};
    private JComboBox listaPreguntas;

    public Crucigrama() {
	Container cp = this.getContentPane();
	cp.setLayout(new GridBagLayout());
	GridBagConstraints constraints = new GridBagConstraints();

	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	cp.add(new JLabel("Selecciona la Pregunta"), constraints);
	
	
	listaPreguntas = new JComboBox(preguntas);
	listaPreguntas.setSelectedIndex(1);
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	cp.add(listaPreguntas, constraints);

	constraints.gridx = 0;
	constraints.gridy = 2;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	cp.add(new JLabel("Pregunta"), constraints);
	
	constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
	pregunta = new JTextArea("Metodo que...", 5, 30);
	cp.add(pregunta, constraints);
	
	constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
	cp.add(new JLabel("Respuesta: "), constraints);

	constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
	respuesta = new JTextArea("Escribe la respuesta (:", 5, 30);
	cp.add(respuesta, constraints);
	
       	tiempoRestante = new JLabel("Tiempo Restante");
	constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
	cp.add(tiempoRestante, constraints);
	
	crucigrama = new LoadImage("imagenes/crucigrama.jpg");
	constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 4;
	cp.add(crucigrama, constraints);
	
	comprobarRespuesta = new JButton("Comprobar Respuesta");
	constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
	cp.add(comprobarRespuesta, constraints);
	
	score = new JLabel("Score: ");
	constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
	cp.add(score, constraints);

	salir = new JButton("Salir");
	constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
	cp.add(salir, constraints);
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	setTitle("Crucigrama");
	setSize(800, 600);  
	setLocationRelativeTo(null);
	pack();
	setVisible(true);    // show it
	
    }
 
    /** The entry main() method */
    public static void main(String[] args) {
	// Run GUI codes in Event-Dispatching thread for thread-safety
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
		    new Crucigrama();  // Let the constructor do the job
		}
	    });
    }
}
