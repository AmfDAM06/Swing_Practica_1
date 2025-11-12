package vista;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PanelMenuLateral extends JPanel {

	private JToggleButton btnEjer1;
	private JToggleButton btnEjer2;
	private JToggleButton btnEjer3;
	private JToggleButton btnEjer4;
	private JToggleButton btnEjer5;

	public PanelMenuLateral() {
		this.setLayout(new GridLayout(0, 1, 5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		btnEjer1 = new JToggleButton("Ejercicio1");
		btnEjer2 = new JToggleButton("Ejercicio2");
		btnEjer3 = new JToggleButton("Ejercicio3");
		btnEjer4 = new JToggleButton("Ejercicio4");
		btnEjer5 = new JToggleButton("Ejercicio5");

		btnEjer1.setSelected(true);
		btnEjer2.setSelected(true);
		btnEjer3.setSelected(true);
		btnEjer4.setSelected(true);
		btnEjer5.setSelected(true);

		this.add(btnEjer1);
		this.add(btnEjer2);
		this.add(btnEjer3);
		this.add(btnEjer4);
		this.add(btnEjer5);
	}

	public JToggleButton getBtnEjer1() {
		return btnEjer1;
	}

	public JToggleButton getBtnEjer2() {
		return btnEjer2;
	}

	public JToggleButton getBtnEjer3() {
		return btnEjer3;
	}

	public JToggleButton getBtnEjer4() {
		return btnEjer4;
	}

	public JToggleButton getBtnEjer5() {
		return btnEjer5;
	}
}