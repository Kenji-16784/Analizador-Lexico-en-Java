package ficherosGrafica;

import compilador.Compilador;
import java.io.*;


public class fichero {
    
    //ATRIBUTOS PARA LECTURA Y ESCRITURA DE LOS FICHEROS
    private File codigoFuente;
    private String linea;
    
    //METODO CONSTRUCTOR DE LA CLASE
    public fichero() {
        codigoFuente = new File("compilerSQL.txt");  
    }
    
    //METODO PARA INGRESAR EL STRING AL FICHERO
    public void ingresar(String cadena) {
        
        //VARIABLES PARA LEER FICHERO
        FileWriter fw;
        BufferedWriter bw;
        
        try {
            fw = new FileWriter(codigoFuente, false);
            bw = new BufferedWriter(fw);
            linea = cadena;
            bw.write(linea);
            
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    } 
    
    //METODO PARA MOSTRAR EL TEXTO COMPILADO
    public void mostrar() {
        FileReader fr;
        BufferedReader br;
        
        //CREANDO INSTANCIA DE LA CLASE COMPILADOR
        Compilador compilador = new Compilador();
        
        try {
            fr = new FileReader(codigoFuente);
            br = new BufferedReader(fr);
            
            while((linea = br.readLine()) != null) {
               
                compilador.lexico(linea);
                  
            }
            
            br.close();
            fr.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
