import AnalisadorLexico.Scanner;
import AnalisadorSintatico.Parser;
import Exceptions.LexicoException;
import Exceptions.SintaticoException;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner("input.sal");
			Parser parser = new Parser(scanner);
			
			parser.E();
			
			System.out.println("Sucesso na Compilação");
		} catch (LexicoException ex) {
			System.out.println("Erro Lexico " + ex.getMessage());
		}
		catch (SintaticoException ex) {
			System.out.println("Erro Sintatico " + ex.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro");
			System.out.println(ex.getClass().getName());
		}
	}
}
