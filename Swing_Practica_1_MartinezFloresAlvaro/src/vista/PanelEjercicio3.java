package vista;

import java.awt.Color;
import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout; 
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelEjercicio3 extends JPanel implements ActionListener {

	private JLabel lblTexto;
	private JRadioButton radioPequenio;
	private JRadioButton radioMediano;
	private JRadioButton radioGrande;
	private JRadioButton radioMuyGrande;
	private ButtonGroup grupoRadios;
	private Font fuenteOriginal;

	private static final int TAM_PEQUENIO = 10;
	private static final int TAM_MEDIANO = 14;
	private static final int TAM_GRANDE = 18;
	private static final int TAM_MUY_GRANDE = 24;

	public PanelEjercicio3() {

		this.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.BLUE), 
						"Ejercicio3"));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
		fuenteOriginal = lblTexto.getFont();
		lblTexto.setAlignmentX(Component.LEFT_ALIGNMENT); 

		radioPequenio = new JRadioButton("Pequeño");
		radioMediano = new JRadioButton("Mediano");
		radioGrande = new JRadioButton("Grande");
		radioMuyGrande = new JRadioButton("Muy Grande");

		JPanel panelRadios = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelRadios.add(radioPequenio);
		panelRadios.add(radioMediano);
		panelRadios.add(radioGrande);
		panelRadios.add(radioMuyGrande);
		panelRadios.setAlignmentX(Component.LEFT_ALIGNMENT); 

		grupoRadios = new ButtonGroup();
		grupoRadios.add(radioPequenio);
		grupoRadios.add(radioMediano);
		grupoRadios.add(radioGrande);
		grupoRadios.add(radioMuyGrande);

		radioMediano.setSelected(true);
		actualizarTamanioFuente();

		radioPequenio.addActionListener(this);
		radioMediano.addActionListener(this);
		radioGrande.addActionListener(this);
		radioMuyGrande.addActionListener(this);

		this.add(lblTexto);
		this.add(panelRadios);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		actualizarTamanioFuente();
	}

	private void actualizarTamanioFuente() {
		int nuevoTamanio = TAM_MEDIANO;
		if (radioPequenio.isSelected()) {
			nuevoTamanio = TAM_PEQUENIO;
		} else if (radioMediano.isSelected()) {
			nuevoTamanio = TAM_MEDIANO;
		} else if (radioGrande.isSelected()) {
			nuevoTamanio = TAM_GRANDE;
		} else if (radioMuyGrande.isSelected()) {
			nuevoTamanio = TAM_MUY_GRANDE;
		}
		lblTexto.setFont(new Font(fuenteOriginal.getName(), fuenteOriginal.getStyle(), nuevoTamanio));
	}
}