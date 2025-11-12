package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup; // <-- IMPORTANTE: para agrupar los radios
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton; // <-- JRadioButton

/**
 * Panel para el Ejercicio 3: Contiene un JLabel y 4 JRadioButtons (Pequeño,
 * Mediano, Grande, Muy Grande) que cambian el tamaño de la fuente del JLabel.
 */
public class PanelEjercicio3 extends JPanel implements ActionListener {

	private JLabel lblTexto;
	private JRadioButton radioPequenio;
	private JRadioButton radioMediano;
	private JRadioButton radioGrande;
	private JRadioButton radioMuyGrande;

	private ButtonGroup grupoRadios; // El agrupador

	private Font fuenteOriginal;

	// Tamaños de fuente que usaremos
	private static final int TAM_PEQUENIO = 10;
	private static final int TAM_MEDIANO = 14; // Tamaño por defecto
	private static final int TAM_GRANDE = 18;
	private static final int TAM_MUY_GRANDE = 24;

	public PanelEjercicio3() {

		this.setBorder(BorderFactory.createTitledBorder("Ejercicio3"));

		// 1. Crear los componentes
		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
		fuenteOriginal = lblTexto.getFont(); // Guardamos la fuente original

		radioPequenio = new JRadioButton("Pequeño");
		radioMediano = new JRadioButton("Mediano");
		radioGrande = new JRadioButton("Grande");
		radioMuyGrande = new JRadioButton("Muy Grande");

		// 2. Crear el ButtonGroup y añadir los botones [cite: 2746]
		grupoRadios = new ButtonGroup();
		grupoRadios.add(radioPequenio);
		grupoRadios.add(radioMediano);
		grupoRadios.add(radioGrande);
		grupoRadios.add(radioMuyGrande);

		// 3. Establecer uno por defecto (como en la captura )
		radioMediano.setSelected(true);
		// Actualizamos el tamaño inicial
		actualizarTamanioFuente();

		// 4. Añadir los Listeners
		radioPequenio.addActionListener(this);
		radioMediano.addActionListener(this);
		radioGrande.addActionListener(this);
		radioMuyGrande.addActionListener(this);

		// 5. Añadir componentes al panel (FlowLayout por defecto)
		this.add(lblTexto);
		this.add(radioPequenio);
		this.add(radioMediano);
		this.add(radioGrande);
		this.add(radioMuyGrande);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Si se pulsa cualquier radio, llamamos a nuestro método
		actualizarTamanioFuente();
	}

	/**
	 * Método que comprueba qué radio está seleccionado y aplica el tamaño de fuente
	 * correspondiente al JLabel.
	 */
	private void actualizarTamanioFuente() {

		int nuevoTamanio = TAM_MEDIANO; // Por defecto

		if (radioPequenio.isSelected()) {
			nuevoTamanio = TAM_PEQUENIO;
		} else if (radioMediano.isSelected()) {
			nuevoTamanio = TAM_MEDIANO;
		} else if (radioGrande.isSelected()) {
			nuevoTamanio = TAM_GRANDE;
		} else if (radioMuyGrande.isSelected()) {
			nuevoTamanio = TAM_MUY_GRANDE;
		}

		// Aplicamos la nueva fuente, conservando el nombre y estilo originales
		lblTexto.setFont(new Font(fuenteOriginal.getName(), fuenteOriginal.getStyle(), nuevoTamanio));
	}
}