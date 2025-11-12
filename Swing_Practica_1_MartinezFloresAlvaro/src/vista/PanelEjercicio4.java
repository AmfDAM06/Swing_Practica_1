package vista;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout; // Para apilar
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider; // El componente principal
import javax.swing.SwingConstants; // Para la orientación
// 1. IMPORTAR LOS LISTENERS DE CAMBIO
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Panel para el Ejercicio 4: Contiene un JSlider que controla el tamaño de la
 * fuente de un JLabel.
 */
// 2. IMPLEMENTAR ChangeListener
public class PanelEjercicio4 extends JPanel implements ChangeListener {

	private JLabel lblTexto;
	private JSlider sliderTamanio;
	private Font fuenteOriginal;

	// Valores para el slider
	private static final int FONT_MIN = 0;
	private static final int FONT_MAX = 50; // La captura pone 45, pero 50 es más estándar
	private static final int FONT_INIT = 25; // Valor inicial como en la captura

	public PanelEjercicio4() {

		this.setBorder(BorderFactory.createTitledBorder("Ejercicio4"));

		// 3. Usar BoxLayout para apilar el slider sobre el texto
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 4. Crear los componentes
		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
		fuenteOriginal = lblTexto.getFont();

		// 5. Crear el JSlider (HORIZONTAL, min, max, valor_inicial) [cite: 2708]
		sliderTamanio = new JSlider(SwingConstants.HORIZONTAL, FONT_MIN, FONT_MAX, FONT_INIT);

		// 6. Configurar el JSlider (como en el temario 4 y la práctica) [cite:
		// 2910-2914, 84]
		sliderTamanio.setMajorTickSpacing(10); // Marcas grandes cada 10
		sliderTamanio.setMinorTickSpacing(5); // Marcas pequeñas cada 5
		sliderTamanio.setPaintTicks(true); // Mostrar las marcas
		sliderTamanio.setPaintLabels(true); // Mostrar los números

		// 7. Añadir el Listener
		sliderTamanio.addChangeListener(this);

		// 8. Añadir componentes al panel
		this.add(sliderTamanio);
		this.add(lblTexto);

		// 9. Establecer el tamaño inicial al arrancar
		actualizarTamanioFuente();
	}

	// 10. IMPLEMENTAR EL MÉTODO DE ChangeListener
	@Override
	public void stateChanged(ChangeEvent e) {
		// Cada vez que el slider se mueve, esto se dispara
		actualizarTamanioFuente();
	}

	/**
	 * Método que lee el valor del slider y lo aplica al JLabel.
	 */
	private void actualizarTamanioFuente() {

		// Obtenemos el valor del slider [cite: 3004, 3345]
		int nuevoTamanio = sliderTamanio.getValue();

		// (Evitamos tamaño 0, que da problemas)
		if (nuevoTamanio == 0) {
			nuevoTamanio = 1;
		}

		// Aplicamos la nueva fuente
		lblTexto.setFont(new Font(fuenteOriginal.getName(), fuenteOriginal.getStyle(), nuevoTamanio));
	}
}