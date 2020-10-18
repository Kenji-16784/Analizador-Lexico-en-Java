package analizador;

public class Tokens {
    
    //ATRIBUTOS DE LA CLASE TOKENS
	private String token;
	private String lexema;
	private boolean palabraReservada;
	
        //METODO CONSTRUCTOR DE LA CLASE TOKENS
	public Tokens(String token, String lexema, boolean palabraReservada) {
		this.token = token;
		this.lexema = lexema;
		this.palabraReservada = palabraReservada;
	}
        
        //METODO PARA OBTENER EL TOKEN
	public String obtenerToken() {
		return token;
	}
        
        //METODO PARA ENVIAR EL TOKEN
	public void enviarToken(String token) {
		this.token = token;
	}
        
        //METODO PARA OBTENER EL LEXEMA
	public String obtenerLexema() {
		return lexema;
	}
        
        //METODO PARA ENVIAR EL LEXEMA
	public void enviarLexema(String lexema) {
		this.lexema = lexema;
	}
        
        //METODO BOOLEANO QUE NOS RETORNA SI ES UNA PALABRA RESERVADA DEL LENGUAJE
	public boolean esPalabraReservada() {
		return palabraReservada;
	}
        
        //SI ES PALABRA RESERVADA ENVIAMOS LA PALABRA POR MEDIO DE ESTE METODO
	public void enviarPalabraReservada(boolean palabraReservada) {
		this.palabraReservada = palabraReservada;
	}
}
