package vista;

import java.awt.Font;
import java.awt.GraphicsEnvironment; // Para obtener las fuentes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout; // Usaremos BoxLayout para apilarlos
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel para el Ejercicio 2: Contiene un JComboBox con las fuentes del sistema
 * y un JLabel que cambia de fuente según la selección.
 */
public class PanelEjercicio2 extends JPanel implements ActionListener {

	private JLabel lblTexto;
	private JComboBox<String> comboFuentes;
	private Font fuenteOriginal; // Para mantener el estilo y tamaño

	public PanelEjercicio2() {

		this.setBorder(BorderFactory.createTitledBorder("Ejercicio2"));

		// 1. CAMBIO DE LAYOUT:
		// En la captura, el ComboBox está encima del texto.
		// Usamos BoxLayout(Y_AXIS) para apilar componentes verticalmente[cite: 1521,
		// 1552, 2664].
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 2. Obtener la lista de fuentes del sistema
		// (Visto en el temario 4, jSpinnerVarios.java)
		String[] nombresFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		// 3. Crear los componentes
		comboFuentes = new JComboBox<>(nombresFuentes);
		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");

		// 4. Guardar la fuente original
		fuenteOriginal = lblTexto.getFont();

		// 5. Añadir el Listener al ComboBox
		comboFuentes.addActionListener(this);

		// 6. Añadir los componentes al panel
		this.add(comboFuentes);
		this.add(lblTexto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Este método se llama cuando seleccionamos algo del JComboBox

		// 1. Obtenemos el nombre de la fuente seleccionada
		String nombreFuenteSeleccionada = (String) comboFuentes.getSelectedItem();

		// 2. Creamos una nueva fuente con ese nombre,
		// pero conservando el estilo (PLAIN) y el tamaño originales.
		Font nuevaFuente = new Font(nombreFuenteSeleccionada, fuenteOriginal.getStyle(), // Mantiene el estilo (ej.
																							// PLAIN)
				fuenteOriginal.getSize() // Mantiene el tamaño
		);

		// 3. Aplicamos la nueva fuente al texto
		lblTexto.setFont(nuevaFuente);
	}
}