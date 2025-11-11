package vista;

//Importamos los paquetes necesarios
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.BorderFactory; // Para poner un borde con espacio

/**
* Panel lateral (OESTE) que contiene los 5 botones de activación
* de los ejercicios.
*/
public class PanelMenuLateral extends JPanel {

 // Declaramos los botones como atributos para poder acceder a ellos más tarde
 // (por ejemplo, para añadirles 'Listeners')
 private JToggleButton btnEjer1;
 private JToggleButton btnEjer2;
 private JToggleButton btnEjer3;
 private JToggleButton btnEjer4;
 private JToggleButton btnEjer5;

 public PanelMenuLateral() {
     // 1. Establecemos el Layout de este JPanel
     // GridLayout(0, 1) significa: 0 filas (infinitas), 1 columna.
     // Los '5, 5' son el espacio (gap) horizontal y vertical entre componentes.
     this.setLayout(new GridLayout(0, 1, 5, 5));

     // 2. (Opcional pero recomendado) Añadimos un borde con un poco de "aire"
     // para que los botones no estén pegados al borde de la ventana.
     this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 10px de padding

     // 3. Creamos los JToggleButton [cite: 64]
     btnEjer1 = new JToggleButton("Ejercicio1");
     btnEjer2 = new JToggleButton("Ejercicio2");
     btnEjer3 = new JToggleButton("Ejercicio3");
     btnEjer4 = new JToggleButton("Ejercicio4");
     btnEjer5 = new JToggleButton("Ejercicio5");
     
     // Por defecto, queremos que estén seleccionados como en la captura [cite: 869]
     btnEjer1.setSelected(true);
     btnEjer2.setSelected(true);
     btnEjer3.setSelected(true);
     btnEjer4.setSelected(true);
     btnEjer5.setSelected(true);

     // 4. Añadimos los botones a este panel
     this.add(btnEjer1);
     this.add(btnEjer2);
     this.add(btnEjer3);
     this.add(btnEjer4);
     this.add(btnEjer5);
 }
 
 // (Más tarde añadiremos aquí los métodos para saber qué botones están activos)
}