package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelTitulo extends JPanel {

	public PanelTitulo() {

		// Añadimos el borde de color rojo como en la captura
		this.setBorder(BorderFactory.createLineBorder(Color.RED));

		// --- 1. Cargar la imagen del logo ---
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/recursos/LogoInsti.png"));
		JLabel lblLogo = new JLabel(logoIcon);
		lblLogo.setBorder(new EmptyBorder(0, 0, 0, 20));

		// --- 2. Crear el panel para los textos (Layout vertical) ---
		JPanel panelTextos = new JPanel();
		panelTextos.setLayout(new BoxLayout(panelTextos, BoxLayout.Y_AXIS));

		// --- 3. Crear las etiquetas de texto ---
		JLabel lblTitulo = new JLabel("I.E.S. Al-Andalus");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

		// Añadimos tu nombre y el de la profesora
		JLabel lblAlumno = new JLabel("Alumno: Alvaro Martinez Flores"); // <-- TU NOMBRE
		lblAlumno.setForeground(Color.GREEN.darker()); // Color verde oscuro

		JLabel lblDireccion = new JLabel("Finca Santa Isabel, s/n 04008 - Almería (España)");
		JLabel lblTelefonos = new JLabel("Tlfno: 950 15 69 36 FAX: 950 15 69 42");

		// --- 4. Añadir los textos al panel de textos ---
		panelTextos.add(lblTitulo);
		panelTextos.add(lblAlumno); // <-- AÑADIDO
		panelTextos.add(lblDireccion);
		panelTextos.add(lblTelefonos);

		// --- 5. Añadir el logo y el panel de textos al PanelTitulo ---
		this.add(lblLogo);
		this.add(panelTextos);
	}
} // <-- YA NO HAY LLAVE EXTRA