package vista;

//Importamos todo lo que vamos a necesitar
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder; // Para añadir márgenes

/**
 * Panel de cabecera (NORTE) con el logo y la información del centro.
 */
public class PanelTitulo extends JPanel {

	public PanelTitulo() {

		// --- 1. Cargar la imagen del logo ---
		// Usamos getClass().getResource() para cargar una imagen interna [cite: 66,
		// 3834-3846].
		// La práctica pide que sea un fichero interno.
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/recursos/LogoInsti.png"));
		JLabel lblLogo = new JLabel(logoIcon);

		// Añadimos un pequeño margen a la derecha del logo
		lblLogo.setBorder(new EmptyBorder(0, 0, 0, 20)); // 20px a la derecha

		// --- 2. Crear el panel para los textos (Layout vertical) ---
		JPanel panelTextos = new JPanel();
		// Usamos BoxLayout(Y_AXIS) para apilar los JLabels verticalmente [cite: 2664]
		panelTextos.setLayout(new BoxLayout(panelTextos, BoxLayout.Y_AXIS));

		// --- 3. Crear las etiquetas de texto ---
		JLabel lblTitulo = new JLabel("I.E.S. Al-Andalus");
		JLabel lblDireccion = new JLabel("Finca Santa Isabel, s/n 04008 - Almería (España)");
		JLabel lblTelefonos = new JLabel("Tlfno: 950 15 69 36 FAX: 950 15 69 42");

		// Damos un estilo al título (como en la captura)
		// (Esto lo vimos en el temario 4, "Componentes Atómicos") [cite: 366]
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

		// --- 4. Añadir los textos al panel de textos ---
		panelTextos.add(lblTitulo);
		panelTextos.add(lblDireccion);
		panelTextos.add(lblTelefonos);

		// --- 5. Añadir el logo y el panel de textos al PanelTitulo ---
		// (Este panel (this) usa FlowLayout por defecto, así que pondrá
		// el logo a la izquierda y el bloque de textos a la derecha)
		this.add(lblLogo);
		this.add(panelTextos);
	}
}