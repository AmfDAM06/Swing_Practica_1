package vista;

//Importamos los paquetes necesarios
import javax.swing.JButton;
import javax.swing.JPanel;

/**
* Panel inferior (SUR) que contiene el botón "Ejercicios Activos".
*/
public class PanelInferior extends JPanel {

 // Declaramos el botón como atributo para añadirle un listener más adelante
 private JButton btnEjerciciosActivos;

 public PanelInferior() {
     // 1. (Opcional) El layout por defecto de JPanel es FlowLayout(FlowLayout.CENTER),
     // así que no hace falta hacer un 'this.setLayout()'. El botón se centrará solo.

     // 2. Creamos el botón
     btnEjerciciosActivos = new JButton("Ejercicios Activos");

     // 3. Añadimos el botón a este panel
     this.add(btnEjerciciosActivos);
 }
 
 // (Más tarde añadiremos un método para que la Ventana pueda
 // "escuchar" cuándo se pulsa este botón)
}