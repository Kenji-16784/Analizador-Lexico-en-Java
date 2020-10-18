package compilador;


import analizador.AnalizadorLexico;

public class Compilador {
        
        
/*********************************************************************************/
        //METODO ENCARGADO DE ANALIZAR NUESTRA CADENA LEIDA DEL TXT
	public void lexico(String linea) {
            
		AnalizadorLexico lexico = new AnalizadorLexico();
		String logSalida = "";
		
                
                //STRING QUE CONTENDRA TODO EL PROGRAMA A COMPILAR PERO DEBE
                //LEERSE POR LINEA
                //String linea = "use databases kenji;";
                
                
                        //ANALIZA LINEA POR LINEA
			lexico.analizarLinea(linea);
                        
                        //CONCATENA NUMERANDO LA LINEA Y AGREGANDO EL STRING LINEA
                    
			logSalida +=  " --> " + linea + "\n";
			logSalida += lexico.cadenaLexica();
                        System.out.println(logSalida);
	}

  
}


