package banco.codigos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Conta extends Cliente {

    public void Leitura(String aux, int conta) throws IOException {

        if (aux == null ? Acessar.acesso == null : aux.equals(Acessar.acesso)) {
            int cont = 0;

            //Arquivo A designa Nome do usuario
            FileReader arquivoA = new FileReader("../Banco/src/banco/arquivos/" + conta + "/nome.txt");
            BufferedReader lerA = new BufferedReader(arquivoA);
            String a = lerA.readLine();
            while (a != null) {
                switch (cont) {
                    case 0:
                        setNome(a);
                        break;
                    case 1:
                        setConta(Integer.parseInt(a));
                        break;
                }
                a = lerA.readLine();
                cont++;
            }
            arquivoA.close();

            //Arquivo B designa Saldo
            FileReader arquivoB = new FileReader("../Banco/src/banco/arquivos/" + conta + "/saldo.txt");
            BufferedReader lerB = new BufferedReader(arquivoB);
            String b = lerB.readLine();
            double valor = 0;
            while (b != null) {
                valor += Double.parseDouble(b);
                b = lerB.readLine();
            }
            setSaldo(valor);
            arquivoB.close();

            //Arquivo C designa Extrato
            FileReader arquivoC = new FileReader("../Banco/src/banco/arquivos/" + Acessar.Acconta + "/extrato.txt");
            BufferedReader lerC = new BufferedReader(arquivoC);
            String c = lerC.readLine();
            extrato = new ArrayList<String>();
            while (c != null) {
                this.extrato.add(c);
                c = lerC.readLine();
            }
            arquivoC.close();
        }
    }

    public ArrayList<String> depositar(int conta, double valor, Boolean resposta) throws IOException {
        ArrayList<String> deposito = new ArrayList<>();
        int cont = 0;
        if (!resposta) {
            FileReader arquivo = new FileReader("../Banco/src/banco/arquivos/" + conta + "/nome.txt");
            BufferedReader ler = new BufferedReader(arquivo);
            String dados = ler.readLine();
            while (dados != null) {
                switch (cont) {
                    case 0 -> deposito.add(dados);
                    case 1 -> deposito.add(dados);
                    case 2 -> deposito.add(dados);
                }
                dados = ler.readLine();
                cont++;
            }
            arquivo.close();
            return deposito;

        } else if (resposta) {
            FileWriter extratoA = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(conta) + "/extrato.txt", true);
            FileWriter saldoA = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(conta) + "/saldo.txt", true);

            BufferedWriter ExtratoNovo = new BufferedWriter(extratoA);
            BufferedWriter SaldoNovo = new BufferedWriter(saldoA);

            ExtratoNovo.write("Deposito de: R$ " + valor + "\n");
            SaldoNovo.write(String.valueOf(valor));
            ExtratoNovo.newLine();
            SaldoNovo.newLine();
            ExtratoNovo.close();
            SaldoNovo.close();
            extratoA.close();
            saldoA.close();
            deposito.add("Deposito efetuado com sucesso!");
            return deposito;
        } else {
            deposito.add("Erro");
            return deposito;
        }

    }

    public Boolean sacar(double valorSaque) throws IOException {

        System.out.print("Seu saldo é de: R$ " + getSaldo());
        if (Acessar.acesso != null) {
            if (getSaldo() >= valorSaque) {
                FileWriter extratoB = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(Acessar.Acconta) + "/extrato.txt", true);
                FileWriter saldoB = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(Acessar.Acconta) + "/saldo.txt", true);

                BufferedWriter ExtratoNovo = new BufferedWriter(extratoB);
                BufferedWriter SaldoNovo = new BufferedWriter(saldoB);

                ExtratoNovo.write("Saque de: R$ " + valorSaque);
                SaldoNovo.write("-" + String.valueOf(valorSaque));
                ExtratoNovo.newLine();
                SaldoNovo.newLine();
                ExtratoNovo.close();
                SaldoNovo.close();
                extratoB.close();
                saldoB.close();
                Leitura(Acessar.acesso, Acessar.Acconta);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public ArrayList<String> transferir(int contaT, double valor, Boolean auxA) throws IOException {
        Leitura(Acessar.acesso, Acessar.Acconta);
        ArrayList<String> transferir = new ArrayList<>();
        int cont = 0;
        if (Acessar.acesso != null) {
            if (!auxA) {

                FileReader arquivo = new FileReader("../Banco/src/banco/arquivos/" + contaT + "/nome.txt");
                BufferedReader ler = new BufferedReader(arquivo);
                String dados = ler.readLine();
                while (dados != null) {
                    switch (cont) {
                        case 0 -> transferir.add(dados);
                        case 1 -> transferir.add(dados);
                        case 2 -> transferir.add(dados);
                    }
                    dados = ler.readLine();
                    cont++;
                }
                arquivo.close();
                return transferir;

            } else if (auxA) {
                Leitura(Acessar.acesso, Acessar.Acconta);

                if (getSaldo() >= valor) {
                    FileWriter extratoC = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(Acessar.Acconta) + "/extrato.txt", true);
                    FileWriter saldoC = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(Acessar.Acconta) + "/saldo.txt", true);

                    BufferedWriter ExtratoNovo = new BufferedWriter(extratoC);
                    BufferedWriter SaldoNovo = new BufferedWriter(saldoC);

                    ExtratoNovo.write("Tranferência realizada no Valor de: R$ " + valor + "\n");
                    SaldoNovo.write("-" + String.valueOf(valor));
                    ExtratoNovo.newLine();
                    SaldoNovo.newLine();
                    ExtratoNovo.close();
                    SaldoNovo.close();
                    extratoC.close();
                    saldoC.close();

                    FileWriter extratoT = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(contaT) + "/extrato.txt", true);
                    FileWriter saldoT = new FileWriter("../Banco/src/banco/arquivos/" + String.valueOf(contaT) + "/saldo.txt", true);

                    BufferedWriter ExtratoNovoT = new BufferedWriter(extratoT);
                    BufferedWriter SaldoNovoT = new BufferedWriter(saldoT);

                    ExtratoNovoT.write("Tranferencia recebida: " + valor);
                    SaldoNovoT.write(String.valueOf(valor));
                    ExtratoNovoT.newLine();
                    SaldoNovoT.newLine();
                    ExtratoNovoT.close();
                    SaldoNovoT.close();
                    extratoT.close();
                    saldoT.close();
                }
                transferir.add("Tranferência com sucesso!");
                return transferir;
            } else {

            }
        }
        return transferir;
    }
}
