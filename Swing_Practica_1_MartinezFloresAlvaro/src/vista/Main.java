package vista;

import javax.swing.SwingUtilities; // Importa esto

public class Main {

    public static void main(String[] args) {
        
        // Ejecutar siempre la GUI en el Hilo de Despacho de Eventos (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 1. Crea la ventana
                Ventana ventana = new Ventana();
            }
        });
    }
}