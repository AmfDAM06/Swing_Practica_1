package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelEjercicio4 extends JPanel implements ChangeListener {

	private JLabel lblTexto;
	private JSlider sliderTamanio;
	private Font fuenteOriginal;

	private static final int FONT_MIN = 0;
	private static final int FONT_MAX = 50;
	private static final int FONT_INIT = 25;

	public PanelEjercicio4() {

		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Ejercicio4"));

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		lblTexto = new JLabel("En un lugar de la Mancha, de cuyo nombre...");
		fuenteOriginal = lblTexto.getFont();

		sliderTamanio = new JSlider(SwingConstants.HORIZONTAL, FONT_MIN, FONT_MAX, FONT_INIT);
		sliderTamanio.setMajorTickSpacing(10);
		sliderTamanio.setMinorTickSpacing(5);
		sliderTamanio.setPaintTicks(true);
		sliderTamanio.setPaintLabels(true);
		sliderTamanio.addChangeListener(this);

		this.add(sliderTamanio);
		this.add(lblTexto);

		actualizarTamanioFuente();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		actualizarTamanioFuente();
	}

	private void actualizarTamanioFuente() {
		int nuevoTamanio = sliderTamanio.getValue();
		if (nuevoTamanio == 0) {
			nuevoTamanio = 1;
		}
		lblTexto.setFont(new Font(fuenteOriginal.getName(), fuenteOriginal.getStyle(), nuevoTamanio));
	}
}