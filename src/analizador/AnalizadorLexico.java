package analizador;

import java.util.ArrayList;


public class AnalizadorLexico {
        
	//ATRIBUTOS DE LA CLASE PARA ANALIZAR LA SINTAXIS DEL STRING cadenaCOMPILADA
	private String cadenaCompilada = "";
        private ArrayList<Tokens> sintaxis = new ArrayList<Tokens>();
        
        //METODO PARA ANALIZAR LA LINEA RECIBIDA POR PARAMETRO
	public void analizarLinea(String linea) {
		sintaxis.clear();
		cadenaCompilada = "";
                
		char[] caracteres = linea.toCharArray();
		String lexema = "";
		boolean flagChar = false;
		for (int i = 0; i < caracteres.length; i++) {
			String caracter = caracteres[i] + "";
			if (flagChar) {
				if (caracter.equalsIgnoreCase("\"")) {
					flagChar = false;
					Tokens simbolo = new Tokens("string", lexema, false);
					this.cadenaCompilada += "\tToken: " + simbolo.obtenerToken() + " SQL: " + simbolo.obtenerLexema() + "\n";
					this.sintaxis.add(simbolo);
					analizarLexema(caracter);
					lexema = "";
					continue;
				}
				lexema += caracter;
				continue;
			}
			if (SintaxisLenguaje.getInstance().esLexemaSimbolo(caracter)) {
				if (caracter.equalsIgnoreCase("\"")) {
					flagChar = true;
				}	
				if (!lexema.isEmpty()) {
					analizarLexema(lexema);
				}
				analizarLexema(caracter);
				lexema = "";
			} else if (caracter.equalsIgnoreCase(" ")) {
				if (!lexema.isEmpty()) {
					analizarLexema(lexema);
				}
				lexema = "";
			} else {
				lexema += caracter;
			}
		}
		if (!lexema.isEmpty()) {
			analizarLexema(lexema);
		}
	}
        
        //METODO PARA ANALIZAR EL LEXEMA
	private void analizarLexema(String lexema) {
		Tokens simbolo = SintaxisLenguaje.getInstance().obtenerSimboloLexema(lexema);
		if (null == simbolo) {
			if (StringNum.esIdentificador(lexema))
				simbolo = new Tokens("identificador", lexema, false);
			else if (StringNum.esNumero(lexema))
				simbolo = new Tokens("n_int", lexema, false);
			else if (StringNum.esReal(lexema))
				simbolo = new Tokens("n_float", lexema, false);
			
			if (!SintaxisLenguaje.getInstance().existeLexemaId(lexema)) {
				SintaxisLenguaje.getInstance().obtenerSintaxisLenguaje().add(simbolo);
			}			
		}
		if (null != simbolo) {
			this.cadenaCompilada += "\tToken: " + simbolo.obtenerToken() + " SQL: " + simbolo.obtenerLexema() + "\n";
			this.sintaxis.add(simbolo);
		} else {
			this.cadenaCompilada += "\tERROR: " + lexema + "\n";
		}
	}
	
        //METODO PARA OBTENER LA CADENA ANALIZADA LEXICAMENTE
        public String cadenaLexica() {
		return cadenaCompilada;
	}
}
