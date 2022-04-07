package AnalisadorLexico;

public class Token {
	public static final int TK_IDENTIFIER  = 0;
	public static final int TK_NUMBER      = 1;
	public static final int TK_OPERATOR    = 2;
	public static final int TK_PONCTUATION = 3;
	public static final int TK_ASSIGN      = 4;
	
	public static final String TK_TEXT[] = {
			"IDENTIFIER", "NUMBER", "OPERATOR", "PONCTUACTION", "ASSIGNMENT"
	};
	
	private int    tipo;
	private String texto;
	private int    linha;
	
	public Token(int tipo, String texto) {
		super();
		this.tipo = tipo;
		this.texto = texto;
	}

	public Token() {
		super();
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Token [tipo=" + tipo + ", texto=" + texto + "]";
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}
}
