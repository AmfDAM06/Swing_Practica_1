package vista;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;  // Usaremos JPanel para el centro y el inferior por ahora
import javax.swing.JLabel;  // Para el texto temporal

// (Aquí deberías tener también las clases PanelTitulo y PanelInferior,
// aunque estén vacías, para seguir la estructura de la práctica)

//... (imports) ...

public class Ventana extends JFrame {
 
 // Atributos para los paneles principales
 private PanelTitulo panelTitulo;
 private PanelMenuLateral panelMenuLateral;
 private JPanel panelCentral;
 
 // 1. Cambiamos el tipo de JPanel a nuestra nueva clase
 private PanelInferior panelInferior;    // El panel del SUR

		 public Ventana() {
		     // ... (super(), setDefaultCloseOperation(), etc.) ...
		
		     // --- 1. Instanciar los paneles especializados ---
		     panelTitulo = new PanelTitulo();
		     panelMenuLateral = new PanelMenuLateral();
		     panelCentral = new JPanel();
		     
		     // 2. Usamos el nuevo constructor
		     panelInferior = new PanelInferior(); 
		
		     // --- 2. Ensamblar la ventana (BorderLayout) ---
		     this.add(panelTitulo, BorderLayout.NORTH);
		     this.add(panelMenuLateral, BorderLayout.WEST);
		     this.add(panelCentral, BorderLayout.CENTER);
		     this.add(panelInferior, BorderLayout.SOUTH); // Ahora añade nuestro PanelInferior
		
		     // --- 3. (Temporal) Añadimos etiquetas para ver las zonas ---
		     
		     // 3. BORRAMOS esta línea, porque PanelInferior ya tiene su botón
		     // panelInferior.add(new JLabel("Aquí irá el botón 'Ejercicios Activos'"));
		     
		     panelCentral.add(new JLabel("Aquí se mostrarán los ejercicios"));
		
		     // --- 4. Configuración final de la ventana ---
		     // ... (setMinimumSize, setLocationRelativeTo, setVisible) ...
		 }
}