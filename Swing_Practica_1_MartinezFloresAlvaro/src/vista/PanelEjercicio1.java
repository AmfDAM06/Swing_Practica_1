package vista;

import java.awt.Font; // Lo necesitaremos para la negrita/cursiva
// 1. IMPORTAR LOS LISTENERS
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 2. HACER QUE EL PANEL IMPLEMENTE ACTIONLISTENER
public class PanelEjercicio1 extends JPanel implements ActionListener {

	// Declaramos los componentes como atributos
	private JLabel lblTexto;
	private JCheckBox chkNegrita;
	private JCheckBox chkCursiva;

	// (Guardamos la fuente original para no perderla)
	private Font fuenteOriginal;

	public PanelEjercicio1() {

		this.setBorder(BorderFactory.createTitledBorder("Ejercicio1"));

		// 2. Crear los componentes
		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
		chkNegrita = new JCheckBox("Negrita");
		chkCursiva = new JCheckBox("Cursiva");

		// 3. GUARDAR LA FUENTE ORIGINAL (antes de cambiarla)
		fuenteOriginal = lblTexto.getFont();

		// 4. AÑADIR LOS LISTENERS A LOS CHECKBOXES
		// 'this' (el propio panel) escuchará los eventos.
		chkNegrita.addActionListener(this);
		chkCursiva.addActionListener(this);

		// 5. Añadir los componentes a este panel
		this.add(lblTexto);
		this.add(chkNegrita);
		this.add(chkCursiva);
	}

	// 6. IMPLEMENTAR EL MÉTODO ACTIONPERFORMED
	@Override
	public void actionPerformed(ActionEvent e) {
		// Cada vez que se pulsa un checkbox, llamamos a este método.
		actualizarEstiloTexto();
	}

	/**
	 * Método privado que lee el estado de los checkboxes y aplica el estilo de
	 * fuente correcto al JLabel.
	 */
	private void actualizarEstiloTexto() {
		// Por defecto, el estilo es normal (PLAIN)
		int estilo = Font.PLAIN;

		// Comprobamos el estado de los checkboxes
		// (Esto lo vimos en el temario 4, "isSelected()") [cite: 1937]
		if (chkNegrita.isSelected()) {
			estilo = estilo + Font.BOLD; // Añadimos negrita
		}
		if (chkCursiva.isSelected()) {
			estilo = estilo + Font.ITALIC; // Añadimos cursiva
		}

		// Creamos una nueva fuente basada en la original,
		// pero con el nuevo estilo y el mismo tamaño.
		lblTexto.setFont(new Font(fuenteOriginal.getName(), estilo, fuenteOriginal.getSize()));
	}
}