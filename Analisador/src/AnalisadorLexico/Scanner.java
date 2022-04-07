package AnalisadorLexico;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import Exceptions.LexicoException;

public class Scanner {
	
	private char[] conteudo;
	private int    estado;
	private int    posicao;
	private int    linha;
	
	public Scanner(String filename) {
		try {
			linha = 1;
			String txtConteudo;
			txtConteudo = new String(Files
			.readAllBytes(Paths.get(filename)),StandardCharsets.UTF_8);

			conteudo = txtConteudo.toCharArray();
			posicao = 0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Token nextToken() {
		char currentChar;
		Token token;
		String term = "";
		if (isEOF()) {
			return null;
		}
		estado = 0;
		while (true) {
			currentChar = nextChar();
			
			switch(estado) {
			case 0:
				if (isChar(currentChar)) {
					term += currentChar;
					estado = 1;
				}
				else if (isDigit(currentChar)) {
					estado = 2;
					term += currentChar;
				}
				else if (isSpace(currentChar)) {
					estado = 0;
				}
				else if (isOperator(currentChar)) {
					term += currentChar;
					token = new Token();
					token.setTipo(Token.TK_OPERATOR);
					token.setTexto(term);
					token.setLinha(linha);
					return token;
				}
				else {
					throw new LexicoException("SÍMBOLO não reconhecido");
				}
				break;
			case 1:
				if (isChar(currentChar) || isDigit(currentChar)) {
					estado = 1;
					term += currentChar;
				}
				else if (isSpace(currentChar) || isOperator(currentChar) || isEOF(currentChar)){
					if (!isEOF(currentChar))
						back();
					token = new Token();
					token.setTipo(Token.TK_IDENTIFIER);
					token.setTexto(term);
					token.setLinha(linha);
					return token;
				}
				else {
					throw new LexicoException("Identificador malformado");
				}
				break;
			case 2:
				if (isDigit(currentChar) || currentChar == '.') {
					estado = 2;
					term += currentChar;
				}
				else if (!isChar(currentChar) || isEOF(currentChar)) {
					if (!isEOF(currentChar))
						back();
					token = new Token();
					token.setTipo(Token.TK_NUMBER);
					token.setTexto(term);
					token.setLinha(linha);
					return token;
				}
				else {
					throw new LexicoException("Número não reconhecido");
				}
				break;
			}
		}		
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	private boolean isChar(char c) {
		return (c >= 'a' && c <= 'z') || (c>='A' && c <= 'Z');
	}
	
	private boolean isOperator(char c) {
		return c == '>' || c == '<' || c == '=' || c == '!' || c == '+' || c == '-' || c == '*' || c == '/';
	}
	private boolean isSpace(char c) {
		if (c == '\n' || c== '\r') {
			linha++;
		}
		return c == ' ' || c == '\t' || c == '\n' || c == '\r'; 
	}
	
	private char nextChar() {
		if (isEOF()) {
			return '\0';
		}
		return conteudo[posicao++];
	}
	private boolean isEOF() {
		return posicao >= conteudo.length;
	}
	
    private void back() {
    	posicao--;
    }
    
    private boolean isEOF(char c) {
    	return c == '\0';
    }	
}
