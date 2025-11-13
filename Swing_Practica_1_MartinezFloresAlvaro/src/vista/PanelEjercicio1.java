package vista;

import java.awt.Color;
import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout; 
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEjercicio1 extends JPanel implements ActionListener {

	private JLabel lblTexto;
	private JCheckBox chkNegrita;
	private JCheckBox chkCursiva;
	private Font fuenteOriginal;

	public PanelEjercicio1() {

		this.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.YELLOW.darker()), 
						"Ejercicio1")); 
		
		// 1. Usamos BoxLayout(Y_AXIS) para apilar verticalmente
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// 2. Crear los componentes
		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
		chkNegrita = new JCheckBox("Negrita");
		chkCursiva = new JCheckBox("Cursiva");
		fuenteOriginal = lblTexto.getFont();

		// 3. Añadir Listeners
		chkNegrita.addActionListener(this);
		chkCursiva.addActionListener(this);

		// 4. Panel INTERNO para los checkboxes (alineado a la izquierda)
		JPanel panelControles = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelControles.add(chkNegrita);
		panelControles.add(chkCursiva);
		
		// 5. Alinear los componentes internos a la izquierda
		// (Para que no se centren dentro del BoxLayout)
		panelControles.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblTexto.setAlignmentX(Component.LEFT_ALIGNMENT);

		// 6. Añadir componentes al panel (verticalmente)
		this.add(lblTexto);
		this.add(panelControles);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		actualizarEstiloTexto();
	}

	private void actualizarEstiloTexto() {
		int estilo = Font.PLAIN;
		if (chkNegrita.isSelected()) {
			estilo = estilo + Font.BOLD;
		}
		if (chkCursiva.isSelected()) {
			estilo = estilo + Font.ITALIC;
		}
		lblTexto.setFont(new Font(fuenteOriginal.getName(), estilo, fuenteOriginal.getSize()));
	}
}