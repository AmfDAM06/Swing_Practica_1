package vista;

import java.awt.Color; // <-- Importar Color
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEjercicio2 extends JPanel implements ActionListener {

	private JLabel lblTexto;
	private JComboBox<String> comboFuentes;
	private Font fuenteOriginal;

	public PanelEjercicio2() {

		// Borde con color
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.YELLOW.darker()), // Color
																												// del
																												// borde
				"Ejercicio2")); // Título

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		String[] nombresFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		comboFuentes = new JComboBox<>(nombresFuentes);
		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
		fuenteOriginal = lblTexto.getFont();
		comboFuentes.addActionListener(this);

		this.add(comboFuentes);
		this.add(lblTexto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombreFuenteSeleccionada = (String) comboFuentes.getSelectedItem();
		Font nuevaFuente = new Font(nombreFuenteSeleccionada, fuenteOriginal.getStyle(), fuenteOriginal.getSize());
		lblTexto.setFont(nuevaFuente);
	}
} // <-- YA NO HAY LLAVE EXTRA