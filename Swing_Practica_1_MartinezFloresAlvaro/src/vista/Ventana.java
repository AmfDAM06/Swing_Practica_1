package vista;

import java.awt.Dimension;
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout;  
import java.awt.Insets;          
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JToggleButton;

public class Ventana extends JFrame implements ActionListener {

	private PanelTitulo panelTitulo;
	private PanelInferior panelInferior;
	
	private JToggleButton btnEjer1, btnEjer2, btnEjer3, btnEjer4, btnEjer5;
	private PanelEjercicio1 panelEjercicio1;
	private PanelEjercicio2 panelEjercicio2;
	private PanelEjercicio3 panelEjercicio3;
	private PanelEjercicio4 panelEjercicio4;
	private PanelEjercicio5 panelEjercicio5;

	public Ventana() {
		super("Practica01_Compendio (Parte 2 - GridBagLayout)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints(); 

		panelTitulo = new PanelTitulo();
		panelInferior = new PanelInferior();
		
		panelEjercicio1 = new PanelEjercicio1();
		panelEjercicio2 = new PanelEjercicio2();
		panelEjercicio3 = new PanelEjercicio3();
		panelEjercicio4 = new PanelEjercicio4();
		panelEjercicio5 = new PanelEjercicio5();
		
		btnEjer1 = new JToggleButton("Ejercicio1", true);
		btnEjer2 = new JToggleButton("Ejercicio2", true);
		btnEjer3 = new JToggleButton("Ejercicio3", true);
		btnEjer4 = new JToggleButton("Ejercicio4", true);
		btnEjer5 = new JToggleButton("Ejercicio5", true);

		btnEjer1.addActionListener(this);
		btnEjer2.addActionListener(this);
		btnEjer3.addActionListener(this);
		btnEjer4.addActionListener(this);
		btnEjer5.addActionListener(this);
		panelInferior.getBtnEjerciciosActivos().addActionListener(this);

		
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0; 
		gbc.weighty = 1.0; //aqui 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(panelTitulo, gbc);

		gbc.gridwidth = 1; 
		gbc.weightx = 0.0; 
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.anchor = GridBagConstraints.NORTH; 
		gbc.gridx = 0;
		
		gbc.gridy = 1; this.add(btnEjer1, gbc);
		gbc.gridy = 2; this.add(btnEjer2, gbc);
		gbc.gridy = 3; this.add(btnEjer3, gbc);
		gbc.gridy = 4; this.add(btnEjer4, gbc);
		gbc.gridy = 5; this.add(btnEjer5, gbc);

		gbc.gridx = 1;
		gbc.weightx = 1.0; 
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weighty = 0.0; 
		
		gbc.gridy = 1; this.add(panelEjercicio1, gbc);
		gbc.gridy = 2; this.add(panelEjercicio2, gbc);
		gbc.gridy = 3; this.add(panelEjercicio3, gbc);
		gbc.gridy = 4; this.add(panelEjercicio4, gbc);
		gbc.gridy = 5; this.add(panelEjercicio5, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2; 
		gbc.weighty = 0.0; 
		this.add(panelInferior, gbc);
		
        JPanel spacer = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; 
        gbc.fill = GridBagConstraints.BOTH; 
        this.add(spacer, gbc);

		this.pack(); 
		this.setMinimumSize(this.getSize()); 
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

	/**
	 * Muestra/oculta paneles usando setVisible.
	 */
	private void gestionarVisibilidadPaneles() {
		
		panelEjercicio1.setVisible(btnEjer1.isSelected());
		panelEjercicio2.setVisible(btnEjer2.isSelected());
		panelEjercicio3.setVisible(btnEjer3.isSelected());
		panelEjercicio4.setVisible(btnEjer4.isSelected());
		panelEjercicio5.setVisible(btnEjer5.isSelected());

		this.revalidate();
		this.repaint();
	}

	private void mostrarEjerciciosActivos() {
		StringBuilder lista = new StringBuilder();
		lista.append("Ejercicios activos:\n\n");
		int contador = 0;

		if (btnEjer1.isSelected()) { lista.append("Ejercicio 1\n"); contador++; }
		if (btnEjer2.isSelected()) { lista.append("Ejercicio 2\n"); contador++; }
		if (btnEjer3.isSelected()) { lista.append("Ejercicio 3\n"); contador++; }
		if (btnEjer4.isSelected()) { lista.append("Ejercicio 4\n"); contador++; }
		if (btnEjer5.isSelected()) { lista.append("Ejercicio 5\n"); contador++; }

		if (contador == 0) {
			lista.append("Ningún ejercicio activo.");
		}
		JOptionPane.showMessageDialog(this, lista.toString(), "EJERCICIOS ACTIVOS", JOptionPane.INFORMATION_MESSAGE);
	}
}