package banco.codigos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Cadastro extends Cliente {

    public final void conta() throws IOException {
        boolean aux = (new File("../Banco/src/banco/arquivos/" + String.valueOf(getConta()))).mkdir();

        if (aux) {
            FileWriter nome = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(getConta()) + "/nome.txt");
            new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(getConta()) + "/extrato.txt");
            FileWriter saldo = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(getConta()).trim() + "/saldo.txt");
            FileWriter senha = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(getConta()) + "/senha.txt");
            PrintWriter gravarNome = new PrintWriter(nome);
            PrintWriter gravarSenha = new PrintWriter(senha);
            PrintWriter gravarSaldo = new PrintWriter(saldo);
            gravarNome.printf(getNome().trim() + "\n");
            gravarSaldo.printf(getSaldo() + "\n");
            gravarNome.printf(String.valueOf(getConta()) + "\n");
            gravarSenha.printf(getSenha() + "\n");
            senha.close();
            saldo.close();
            nome.close();
        } else {
            System.out.println("Conta já cadastrada!");
        }
    }
    
    public Cadastro(String nome, String senha, double saldo) throws IOException {
        setNome(nome);
        setSenha(senha);
        setSaldo(saldo);

        try {
            conta();
        } catch (IOException e) {
            System.out.println("Erro!");
        }
    }
}
