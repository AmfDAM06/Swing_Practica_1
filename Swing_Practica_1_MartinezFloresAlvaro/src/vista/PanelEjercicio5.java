package vista;

import java.awt.Color; // <-- Importar Color
import java.awt.Image; // <-- Importar Image para escalar

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelEjercicio5 extends JPanel implements ChangeListener {

	private JSpinner spinnerImagenes;
	private JPanel panelDeImagenes;
	private JLabel lblImg1;
	private JLabel lblImg2;
	private JLabel lblImg3;
	private JLabel lblImg4;

	// Tamaño para escalar las imágenes
	private static final int IMG_ANCHO = 100;
	private static final int IMG_ALTO = 100;

	public PanelEjercicio5() {
		// Borde con color
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN), // Color del borde
				"Ejercicio5")); // Título

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// --- 1. Crear el panel de controles (Label + Spinner) ---
		JPanel panelControles = new JPanel();
		JLabel lblPregunta = new JLabel("¿Cuántas imágenes quieres mostrar?");
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 4, 1);
		spinnerImagenes = new JSpinner(spinnerModel);
		spinnerImagenes.addChangeListener(this);
		panelControles.add(lblPregunta);
		panelControles.add(spinnerImagenes);

		// --- 2. Cargar y ESCALAR Iconos ---
		ImageIcon icon1 = escalarIcono(new ImageIcon(getClass().getResource("/recursos/animal1.png")), IMG_ANCHO,
				IMG_ALTO);
		ImageIcon icon2 = escalarIcono(new ImageIcon(getClass().getResource("/recursos/animal2.png")), IMG_ANCHO,
				IMG_ALTO);
		ImageIcon icon3 = escalarIcono(new ImageIcon(getClass().getResource("/recursos/animal3.png")), IMG_ANCHO,
				IMG_ALTO);
		ImageIcon icon4 = escalarIcono(new ImageIcon(getClass().getResource("/recursos/animal4.png")), IMG_ANCHO,
				IMG_ALTO);

		lblImg1 = new JLabel(icon1);
		lblImg2 = new JLabel(icon2);
		lblImg3 = new JLabel(icon3);
		lblImg4 = new JLabel(icon4);

		// --- 3. Crear el panel que contendrá las imágenes ---
		panelDeImagenes = new JPanel();
		panelDeImagenes.add(lblImg1);
		panelDeImagenes.add(lblImg2);
		panelDeImagenes.add(lblImg3);
		panelDeImagenes.add(lblImg4);

		// --- 4. Añadir los paneles principales a 'this' ---
		this.add(panelControles);
		this.add(panelDeImagenes);

		// --- 5. Estado inicial ---
		actualizarVisibilidadImagenes();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		actualizarVisibilidadImagenes();
	}

	private void actualizarVisibilidadImagenes() {
		int numMostrar = (int) spinnerImagenes.getValue();
		lblImg1.setVisible(numMostrar >= 1);
		lblImg2.setVisible(numMostrar >= 2);
		lblImg3.setVisible(numMostrar >= 3);
		lblImg4.setVisible(numMostrar >= 4);
	}

	/**
	 * Método de utilidad para escalar un ImageIcon a un tamaño específico.
	 */
	private ImageIcon escalarIcono(ImageIcon icon, int ancho, int alto) {
		Image img = icon.getImage();
		Image imgEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new ImageIcon(imgEscalada);
	}

}