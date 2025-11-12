package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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

		JPanel wrapperBotones = new JPanel();
		wrapperBotones.add(panelMenuLateral);

		this.add(panelTitulo, BorderLayout.NORTH);
		this.add(wrapperBotones, BorderLayout.WEST);
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelInferior, BorderLayout.SOUTH);

		panelMenuLateral.getBtnEjer1().addActionListener(this);
		panelMenuLateral.getBtnEjer2().addActionListener(this);
		panelMenuLateral.getBtnEjer3().addActionListener(this);
		panelMenuLateral.getBtnEjer4().addActionListener(this);
		panelMenuLateral.getBtnEjer5().addActionListener(this);
		panelInferior.getBtnEjerciciosActivos().addActionListener(this);

		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		gestionarVisibilidadPaneles();
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

		panelCentral.add(Box.createVerticalGlue());

		if (panelCentral.getComponentCount() == 1) {
			panelCentral.removeAll();
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