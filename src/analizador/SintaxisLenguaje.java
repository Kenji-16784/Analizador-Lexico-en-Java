package analizador;

import java.util.ArrayList;
import java.util.Arrays;

public class SintaxisLenguaje {
	
	private static SintaxisLenguaje INSTANCE;
	
	public static SintaxisLenguaje getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new SintaxisLenguaje();
		}
		return INSTANCE;
	}
	
	private ArrayList<Tokens> sintaxisLenguaje;
	
        //METODO CONSTRUCTOR QUE CONTIENE TODOS LOS TOKENS DE LA SINTAXIS 
        //DEL LENGUAJE
	public SintaxisLenguaje() {
		sintaxisLenguaje = new ArrayList<Tokens>(
				  Arrays.asList(new Tokens("reservada", "select", true), new Tokens("reservada", "*", true),
						new Tokens("variable", "int", true), new Tokens("reservada", "database", true),
						new Tokens("reservada", "from", true), new Tokens("reservada", ";", true), new Tokens("reservada", "table", true), 
						new Tokens("reservada", "show", true), new Tokens("reservada", "update", true), new Tokens("reservada", "*", true), 
						new Tokens("reservada", "databases", true), new Tokens("operador", "=", true), new Tokens("reservada", "use", true), 
						new Tokens("reservada", "drop", true), new Tokens("reservada", "truncate", true), new Tokens("reservada", ",", true),
						new Tokens("reservada", "mysql", true), new Tokens("reservada", "-u", true), new Tokens("reservada", "root", true),
						new Tokens("reservada", "full", true), new Tokens("reservada", "(", true), new Tokens("reservada", ")", true),
                                                new Tokens("reservada", "not", true), new Tokens("reservada", "null", true), new Tokens("variable", "double", true),
						new Tokens("variable", "nvarchar", true), new Tokens("reservada", "primary", true), new Tokens("reservada", "key", true),
						new Tokens("reservada", "create", true), new Tokens("reservada", "autoincrement", true),	new Tokens("reservada", "insert", true)));
	}
        
        //METODO PARA OBTENER LA SINTAXIS DEL LENGUAJE
	public ArrayList<Tokens> obtenerSintaxisLenguaje() {
		return sintaxisLenguaje;
	}
        
        //METODO PARA OBTENER LA CADENA DEL LEXEMA
	public Tokens obtenerSimboloLexema(String lexema){
		for(Tokens simbolo : this.sintaxisLenguaje)
			if(simbolo.obtenerLexema().equalsIgnoreCase(lexema))
				return simbolo;
		return null;
	}
	
        //SI EL LEXEMA CONTIENE SIMBOLOS
	public boolean esLexemaSimbolo(String lexema){
		for(Tokens simbolo : this.sintaxisLenguaje)
			if(simbolo.obtenerLexema().equalsIgnoreCase(lexema) && simbolo.esPalabraReservada())
				return true;
		return false;
	}
	
        
	public boolean existeLexemaId(String lexema) {
		for (Tokens simbolo : this.sintaxisLenguaje) {
			if ((lexema.equalsIgnoreCase(simbolo.obtenerLexema())) && (!simbolo.esPalabraReservada())) {
				return true;
			}
		}
		return false;
	}
}

