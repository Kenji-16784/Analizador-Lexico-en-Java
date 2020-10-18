
package compilador;

import ficherosGrafica.panelVentana;
import javax.swing.JFrame;

class Ventana extends JFrame{
    
        public Ventana(){
        super("SHELL SQL");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new panelVentana());   
    
        } 
}
