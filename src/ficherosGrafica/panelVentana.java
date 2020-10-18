
package ficherosGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class panelVentana extends JPanel{
    
    private JTextArea areaTexto;
    private JButton compilar;
    private JButton cancelar;
       
        ActionListener action=new ActionListener(){
       
        public void actionPerformed(ActionEvent e) {
            JButton fuenteBoton = (JButton) e.getSource();
            if(compilar == fuenteBoton){
                fichero archivo = new fichero();
                String cadena = areaTexto.getText();  
                archivo.ingresar(cadena);
                archivo.mostrar();
            }else if(cancelar==fuenteBoton){
                System.exit(0);
            }
        }
    };
    
    //CONSTRUCTOR DE PANEL
    public panelVentana(){
        
        super();
        Font font = new Font("Agency FB", Font.BOLD, 20);
        
        areaTexto = new JTextArea(22,50);
        compilar = new JButton("ANALIZAR");
        cancelar = new JButton("CANCELAR");
        
        //AGREGANDO ACCION Y ESTILO A LOS BOTONES
        areaTexto.setLayout(new BorderLayout(10, 10));
        areaTexto.setFont(font);
        
        compilar.addActionListener(action);
        compilar.setBackground(Color.green);
        cancelar.addActionListener(action);
        cancelar.setBackground(Color.yellow);
        
        
        //AGREGANDO COMP0NENTES AL PANEL
        add(areaTexto);
        add(compilar);
        add(cancelar);
        
        setVisible(true);
       
    }
   
}

 
