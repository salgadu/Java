package AnalisadorSintatico;

import Exceptions.SintaticoException;
import AnalisadorLexico.Scanner;
import AnalisadorLexico.Token;

public class Parser {

	private Scanner scanner;
	private Token token;

	public Parser(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void E() { T(); El(); }
	
	public void El() {
		token = scanner.nextToken();
		if (token != null) {
			OP();
			T();
			El();
		}
	}
	
	public void T() {
		token = scanner.nextToken();
		if (token.getTipo() != Token.TK_IDENTIFIER && token.getTipo() != Token.TK_NUMBER) {
			throw new SintaticoException("ID ou Numero esperado!, econtrado "
            + Token.TK_TEXT[token.getTipo()] + " (" + token.getTexto() + ") na LINHA "
            + token.getLinha());
		}
	}
	
	public void OP() {
		if (token.getTipo() != Token.TK_OPERATOR) {
			throw new SintaticoException("Operador esperado, econtrado "
            + Token.TK_TEXT[token.getTipo()] + " (" + token.getTexto() + ")  na LINHA "
            + token.getLinha());
		}
	}
}
