package vista;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel; // Para definir el rango 0-4
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener; // Es ChangeListener, no Action

/**
 * Panel para el Ejercicio 5: Contiene un JSpinner (0-4) que controla la
 * visibilidad de 4 imágenes (JLabels con ImageIcon).
 */
public class PanelEjercicio5 extends JPanel implements ChangeListener {

	private JSpinner spinnerImagenes;

	// Un panel extra para contener las imágenes
	private JPanel panelDeImagenes;

	// Las 4 etiquetas para las imágenes
	private JLabel lblImg1;
	private JLabel lblImg2;
	private JLabel lblImg3;
	private JLabel lblImg4;

	public PanelEjercicio5() {
		this.setBorder(BorderFactory.createTitledBorder("Ejercicio5"));

		// Usamos BoxLayout(Y_AXIS) para apilar los controles
		// encima del panel de imágenes
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// --- 1. Crear el panel de controles (Label + Spinner) ---
		JPanel panelControles = new JPanel(); // Usa FlowLayout por defecto

		JLabel lblPregunta = new JLabel("¿Cuántas imágenes quieres mostrar?");

		// Creamos el Modelo para el Spinner: (valorInicial, min, max, incremento)
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 4, 1);

		spinnerImagenes = new JSpinner(spinnerModel);

		// Añadimos el listener al spinner
		spinnerImagenes.addChangeListener(this);

		panelControles.add(lblPregunta);
		panelControles.add(spinnerImagenes);

		// --- 2. Cargar Iconos y crear JLabels para las imágenes ---
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/recursos/animal1.png"));
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/recursos/animal2.png"));
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/recursos/animal3.png"));
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/recursos/animal4.png"));

		lblImg1 = new JLabel(icon1);
		lblImg2 = new JLabel(icon2);
		lblImg3 = new JLabel(icon3);
		lblImg4 = new JLabel(icon4);

		// --- 3. Crear el panel que contendrá las imágenes ---
		panelDeImagenes = new JPanel(); // Usa FlowLayout por defecto
		panelDeImagenes.add(lblImg1);
		panelDeImagenes.add(lblImg2);
		panelDeImagenes.add(lblImg3);
		panelDeImagenes.add(lblImg4);

		// --- 4. Añadir los paneles principales a 'this' ---
		this.add(panelControles);
		this.add(panelDeImagenes);

		// --- 5. Estado inicial ---
		// Llamamos al método al inicio para que muestre 0 imágenes
		actualizarVisibilidadImagenes();
	}

	// 6. IMPLEMENTAR EL MÉTODO DE ChangeListener
	@Override
	public void stateChanged(ChangeEvent e) {
		// Cada vez que el spinner cambia, llamamos al método
		actualizarVisibilidadImagenes();
	}

	/**
	 * Método que lee el valor del spinner (0-4) y ajusta la visibilidad de las
	 * etiquetas de imagen.
	 */
	private void actualizarVisibilidadImagenes() {

		// Obtenemos el valor actual del spinner
		int numMostrar = (int) spinnerImagenes.getValue();

		// Ajustamos la visibilidad de cada imagen [cite: 531]
		// (Si numMostrar es 2: 1 y 2 son true, 3 y 4 son false)
		lblImg1.setVisible(numMostrar >= 1);
		lblImg2.setVisible(numMostrar >= 2);
		lblImg3.setVisible(numMostrar >= 3);
		lblImg4.setVisible(numMostrar >= 4);
	}
}