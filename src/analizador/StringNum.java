package analizador;

public class StringNum {

	public static boolean esIdentificador(String lexema) {
		
            //ATRIBUTOS DE LA CLASE QUE CONTIENEN LOS SIMBOLOS A IDENTIFICAR
                String cadenaLetras = "[A-Za-z]";
		String digitoLetra = "[0-9A-Za-z]";
		String caracter = "";
		
                //BUCLE ENCARGADO DE RECORRER POR LETRA LAS CADENAS
                int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (caracter.matches(cadenaLetras))
					estado = 2;
				else
					estado = 3;
				break;
			case 2:
				if (caracter.matches(digitoLetra))
					estado = 2;
				else
					estado = 3;
				break;
			}
		}
		if (estado != 3)
			return true;
		return false;
	}
        
        //METODO BOOLEANO PARA SABER SI LA CADENA CONTIENE NUMEROS
	public static boolean esNumero(String lexema) {
		String digito = "[0-9]";
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (caracter.matches(digito))
					estado = 1;
				else
					estado = 2;
				break;
			}
		}
		if (estado != 2)
			return true;
		return false;
	}
        
        
	public static boolean esReal(String lexema) {
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (StringNum.esNumero(caracter))
					estado = 1;
				else {
					estado = 2;
					i--;
				}
				break;
			case 2:
				if (caracter.equalsIgnoreCase("."))
					if (i + 1 != lexema.length())
						estado = 3;
					else
						estado = 4;
				else
					estado = 4;
				break;
			case 3:
				if (StringNum.esNumero(caracter)) {
					estado = 3;
				} else
					estado = 4;
				break;
			}
		}
		if (estado != 4)
			return true;
		return false;
	}
}
