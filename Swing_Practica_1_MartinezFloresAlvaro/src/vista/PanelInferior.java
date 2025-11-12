package vista;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInferior extends JPanel {

	private JButton btnEjerciciosActivos;

	public PanelInferior() {
		btnEjerciciosActivos = new JButton("Ejercicios Activos");
		this.add(btnEjerciciosActivos);
	}

	public JButton getBtnEjerciciosActivos() {
		return btnEjerciciosActivos;
	}
}