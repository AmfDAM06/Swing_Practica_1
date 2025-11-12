package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane; // <-- 1. IMPORTAR JOPTIONPANE
import javax.swing.JPanel;

public class Ventana extends JFrame implements ActionListener {

	// (Atributos de paneles...)
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
		// ... (super(), setDefaultCloseOperation()...)

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
		this.add(panelTitulo, BorderLayout.NORTH);
		this.add(panelMenuLateral, BorderLayout.WEST);
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelInferior, BorderLayout.SOUTH);

		// --- 3. AÑADIR LOS LISTENERS ---
		panelMenuLateral.getBtnEjer1().addActionListener(this);
		panelMenuLateral.getBtnEjer2().addActionListener(this);
		panelMenuLateral.getBtnEjer3().addActionListener(this);
		panelMenuLateral.getBtnEjer4().addActionListener(this);
		panelMenuLateral.getBtnEjer5().addActionListener(this);

		// 2. AÑADIR EL LISTENER AL NUEVO BOTÓN
		panelInferior.getBtnEjerciciosActivos().addActionListener(this);

		// --- 4. Configuración final y visibilidad ---
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		gestionarVisibilidadPaneles(); // Carga inicial
		this.setVisible(true);
	}

	// 3. ACTUALIZAR EL MÉTODO ACTIONPERFORMED
	@Override
	public void actionPerformed(ActionEvent e) {

		// Comprobamos QUÉ botón se ha pulsado
		Object fuenteDelEvento = e.getSource();

		if (fuenteDelEvento == panelInferior.getBtnEjerciciosActivos()) {
			// Si es el botón "Ejercicios Activos"...
			mostrarEjerciciosActivos();
		} else {
			// Si es cualquier otro botón (los JToggleButton)...
			gestionarVisibilidadPaneles();
		}
	}

	/**
	 * Muestra/oculta paneles en el panelCentral.
	 */
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

		if (panelCentral.getComponentCount() == 0) {
			panelCentral.add(new JLabel("Aquí se mostrarán los ejercicios"));
		}

		panelCentral.revalidate();
		panelCentral.repaint();
	}

	// 4. AÑADIR ESTE NUEVO MÉTODO
	/**
	 * Construye una lista de ejercicios activos y la muestra en un JOptionPane.
	 */
	private void mostrarEjerciciosActivos() {
		// Usamos StringBuilder para construir el texto eficientemente
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

		// Comprobamos si no había ninguno seleccionado
		if (contador == 0) {
			lista.append("Ningún ejercicio activo.");
		}

		// Mostramos el diálogo (Temario 3) [cite: 1478]
		JOptionPane.showMessageDialog(this, // El componente padre (la ventana)
				lista.toString(), // El mensaje
				"EJERCICIOS ACTIVOS", // Título de la ventana del diálogo
				JOptionPane.INFORMATION_MESSAGE // El icono (la 'i' azul)
		);
	}
}