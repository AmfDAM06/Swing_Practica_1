package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box; // <-- IMPORTANTE: Para el "Vertical Glue"
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JFrame implements ActionListener {

	private PanelTitulo panelTitulo;
	private PanelMenuLateral panelMenuLateral;
	private JPanel panelCentral;
	private PanelInferior panelInferior;
	private PanelEjercicio1 panelEjercicio1;
	private PanelEjercicio2 panelEjercicio2;
	private PanelEjercicio3 panelEjercicio3;
	private PanelEjercicio4 panelEjercicio4;
	private PanelEjercicio5 panelEjercicio5;

	public Ventana() {
		super("Practica01_Compendio");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// --- 1. Instanciar paneles ---
		panelTitulo = new PanelTitulo();
		panelMenuLateral = new PanelMenuLateral();
		panelInferior = new PanelInferior();
		panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		panelEjercicio1 = new PanelEjercicio1();
		panelEjercicio2 = new PanelEjercicio2();
		panelEjercicio3 = new PanelEjercicio3();
		panelEjercicio4 = new PanelEjercicio4();
		panelEjercicio5 = new PanelEjercicio5();

		// --- 2. Ensamblar la ventana ---

		// ARREGLO BOTONES ESTIRADOS (WEST):
		// Creamos un panel "wrapper" que usa FlowLayout (por defecto)
		// y que no estirará nuestro panel de botones.
		JPanel wrapperBotones = new JPanel();
		wrapperBotones.add(panelMenuLateral);

		this.add(panelTitulo, BorderLayout.NORTH);
		this.add(wrapperBotones, BorderLayout.WEST); // <-- Añadimos el wrapper
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelInferior, BorderLayout.SOUTH);

		// --- 3. AÑADIR LOS LISTENERS ---
		panelMenuLateral.getBtnEjer1().addActionListener(this);
		panelMenuLateral.getBtnEjer2().addActionListener(this);
		panelMenuLateral.getBtnEjer3().addActionListener(this);
		panelMenuLateral.getBtnEjer4().addActionListener(this);
		panelMenuLateral.getBtnEjer5().addActionListener(this);
		panelInferior.getBtnEjerciciosActivos().addActionListener(this);

		// --- 4. Configuración final y visibilidad ---
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		gestionarVisibilidadPaneles(); // Carga inicial
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuenteDelEvento = e.getSource();

		if (fuenteDelEvento == panelInferior.getBtnEjerciciosActivos()) {
			mostrarEjerciciosActivos();
		} else {
			gestionarVisibilidadPaneles();
		}
	}

	private void gestionarVisibilidadPaneles() {
		panelCentral.removeAll();

		if (panelMenuLateral.getBtnEjer1().isSelected()) {
			panelCentral.add(panelEjercicio1);
		}
		if (panelMenuLateral.getBtnEjer2().isSelected()) {
			panelCentral.add(panelEjercicio2);
		}
		if (panelMenuLateral.getBtnEjer3().isSelected()) {
			panelCentral.add(panelEjercicio3);
		}
		if (panelMenuLateral.getBtnEjer4().isSelected()) {
			panelCentral.add(panelEjercicio4);
		}
		if (panelMenuLateral.getBtnEjer5().isSelected()) {
			panelCentral.add(panelEjercicio5);
		}

		// ARREGLO PANELES ESTIRADOS (CENTER):
		// Añadimos "pegamento" vertical. Es un componente invisible
		// que se estira para ocupar todo el espacio sobrante,
		// empujando los paneles de ejercicio hacia arriba.
		panelCentral.add(Box.createVerticalGlue());

		// Comprobamos si solo queda el "pegamento" (o sea, 0 ejercicios)
		if (panelCentral.getComponentCount() == 1) {
			panelCentral.removeAll(); // Lo quitamos
			panelCentral.add(new JLabel("Aquí se mostrarán los ejercicios"));
		}

		panelCentral.revalidate();
		panelCentral.repaint();
	}

	private void mostrarEjerciciosActivos() {
		StringBuilder lista = new StringBuilder();
		lista.append("Ejercicios activos:\n\n");

		int contador = 0;

		if (panelMenuLateral.getBtnEjer1().isSelected()) {
			lista.append("Ejercicio 1\n");
			contador++;
		}
		if (panelMenuLateral.getBtnEjer2().isSelected()) {
			lista.append("Ejercicio 2\n");
			contador++;
		}
		if (panelMenuLateral.getBtnEjer3().isSelected()) {
			lista.append("Ejercicio 3\n");
			contador++;
		}
		if (panelMenuLateral.getBtnEjer4().isSelected()) {
			lista.append("Ejercicio 4\n");
			contador++;
		}
		if (panelMenuLateral.getBtnEjer5().isSelected()) {
			lista.append("Ejercicio 5\n");
			contador++;
		}

		if (contador == 0) {
			lista.append("Ningún ejercicio activo.");
		}

		JOptionPane.showMessageDialog(this, lista.toString(), "EJERCICIOS ACTIVOS", JOptionPane.INFORMATION_MESSAGE);
	}
}