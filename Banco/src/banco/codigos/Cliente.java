package banco.codigos;

import java.util.ArrayList;

public class Cliente {

    public ArrayList<String> extrato;
    public String nome;
    public int conta = (int) (1 + (Math.random() * 10000));
    public String senha;
    public double saldo;

    public Cliente(String nome, int conta, String senha, double saldo) {
        this.nome = nome;
        this.conta = conta;
        this.senha = senha;
        this.saldo = saldo;
    }
    
    public ArrayList<String> getExtrato() {
        return extrato;
    }

    public Cliente() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
