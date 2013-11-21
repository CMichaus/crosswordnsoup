import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Crucigrama extends JFrame {
    private LoadImage crucigrama;
    private JLabel lblpregunta, lblIntenta, score, tiempoRestante;
    private JTextArea pregunta, respuesta;
    private JButton comprobarRespuesta, salir;
    private String numero_preguntas[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String preguntas[] = {"Es un algoritmo de búsqueda de raíces que trabaja dividiendo el intervalo a la mitad \ny seleccionando el subintervalo que tiene la raíz.", 
				  "El procedimiento empieza con una estimación o conjetura inicial \nde x, que es mejorada por iteración hasta alcanzar la convergencia. \nPara que converja, la derivada (dg/dx) debe ser menor que 1 \nen magnitud (al menos para los valores x que se encuentran \ndurante las iteraciones). La convergencia será establecida \nmediante el requisito de que el cambio en x de una iteración a \nla siguiente no sea mayor en magnitud que \nalguna pequeña cantidad ε.", 
				  "Es una variación del método de Newton-Raphson donde en vez de calcular la derivada \nde la función en el punto de estudio, teniendo en mente la definición de derivada, se \naproxima la pendiente a la recta que une la función evaluada en el punto de estudio \ny en el punto de la iteración anterior.", 
				  "Como en el método de bisección, se parte de un intervalo inicial [a0,b0] con f(a0) \ny f(b0) de signos opuestos, lo que garantiza que en su interior hay al menos una \nraíz. El algoritmo va obteniendo sucesivamente en cada paso un intervalo más \npequeño [ak, bk] que sigue incluyendo una raíz de la función f.", 
				  "Es un método abierto, en el sentido de que su convergencia global no está \ngarantizada. La única manera de alcanzar la convergencia es seleccionar \nun valor inicial lo suficientemente cercano a la raíz buscada.", 
				  "El polinomio de interpolación de Newton de forma _____ ________ se puede determinar \nasumiendo la siguiente forma: \nPn(x) = c0 + c1 (x − x0 ) + c2 (x − x0 )(x − x1 ) + · · · + cn (x − x0 ) · · · (x − xn−1 ) \ndonde los coeficientes ck , k = 0, . . . , n se determinan al cumplir con las \nrestricciones Pn (xi ) = yi , i = 0, . . . , n.", 
				  "Es un método iterativo, usado para resolver sistemas de ecuaciones lineales \ndel tipo Ax=b. El algoritmo toma su nombre del matemático alemán Carl \nGustav Jakob Jacobi. Consiste en usar fórmulas como iteración de punto fijo.", 
				  "El método consiste en ir -pivoteando- en la diagonal principal. Se comienza en \nel extremo superior izquierdo, el renglón donde esta el pivote va a ser el \nrenglón base de todo el sistema y la columna donde esta el pivote va a ser \nla columna base. Con respecto a ese renglón y esa columna, donde está el \npivote, se forman determinantes de dos por dos, y siempre se trabaja con \nnúmeros enteros, si apareciera alguna fracción hay un error.", 
				  "Un sistema de ecuaciones se resuelve por este método cuando se obtienen sus \nsoluciones mediante la reducción del sistema dado a otro equivalente en el que \ncada ecuación tiene una incógnita menos que la anterior. Este método transforma \nla matriz de coeficientes en una matriz triangular superior. Después, este método \ncontinúa el proceso de transformación hasta obtener una matriz diagonal.", 
				  "Este método para resolver este tipo de sistemas consiste, por tanto, en representar \nen unos ejes cartesianos, o sistema de coordenadas, ambas rectas y comprobar si \nse cortan y, si es así, dónde."};    

    private JComboBox listaPreguntas;

    public Crucigrama() {
	Container cp = this.getContentPane();
	cp.setLayout(new GridBagLayout());
	GridBagConstraints constraints = new GridBagConstraints();

	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.WEST;
	lblpregunta = new JLabel("Selecciona la Pregunta");
	lblpregunta.setFont(new Font("Serif", Font.PLAIN, 25));
	cp.add(lblpregunta, constraints);
	
	
	listaPreguntas = new JComboBox(numero_preguntas);
	listaPreguntas.setSelectedIndex(0);

	listaPreguntas.addActionListener(new ActionListener() {
		@Override
		    public void actionPerformed(ActionEvent e) {
		    JComboBox cb = (JComboBox)e.getSource();
		    int pregunta = cb.getSelectedIndex();
		    updateQuestion(pregunta);
		}
	    });
	constraints.gridx = 1;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.WEST;
	cp.add(listaPreguntas, constraints);

	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridwidth = 2;
	constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.WEST;
	cp.add(new JLabel("Pregunta"), constraints);
	
	constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.fill = GridBagConstraints.NONE;
	pregunta = new JTextArea(preguntas[0], 5, 30);
	pregunta.setEditable(false);
	cp.add(pregunta, constraints);
	
	constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.SOUTHWEST;
	constraints.weighty = 1.0;
	cp.add(new JLabel("Respuesta: "), constraints);

	constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.NORTH;
	constraints.fill = GridBagConstraints.NONE;
	respuesta = new JTextArea(5, 30);
	constraints.weightx = 0.0;
	cp.add(respuesta, constraints);
	
	constraints.weightx = 0.0;
	comprobarRespuesta = new JButton("Comprobar Respuesta");
	comprobarRespuesta.addActionListener(new ActionListener() {
		@Override
		    public void actionPerformed(ActionEvent e) {
		    
		}
	    });
	
	constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.fill = GridBagConstraints.NONE;
	cp.add(comprobarRespuesta, constraints);
	
	tiempoRestante = new JLabel("Tiempo Restante");
	constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	cp.add(tiempoRestante, constraints);
	
	score = new JLabel("Score: ");
	constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.fill = GridBagConstraints.NONE;
	cp.add(score, constraints);

	crucigrama = new LoadImage("imagenes/primero.png");
	constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 4;
        constraints.gridheight = 5;
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	cp.add(crucigrama, constraints);
	
	salir = new JButton("Salir");
	salir.addActionListener(new ActionListener() {
		@Override
		    public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	    });
	constraints.gridx = 5;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.fill = GridBagConstraints.NONE;
	cp.add(salir, constraints);
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	setTitle("Crucigrama");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	setSize(screenSize);  
	setLocationRelativeTo(null);
	setVisible(true);    // show it
	
    }
 
    
    protected void updateQuestion(int preg) {
        pregunta.setText(preguntas[preg]);
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
