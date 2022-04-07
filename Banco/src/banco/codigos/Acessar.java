package banco.codigos;

import java.io.IOException;
import java.util.Date;

public class Acessar {

    public static int Acconta;
    private final String senha;
    public static String acesso = null;

    public Boolean acesso() throws IOException {

        Arquivos contaA = new Arquivos();
        if (contaA.auxConta(Acconta)) {
            if (contaA.auxSenha(senha, Acconta)) {
                Date data = new Date();
                acesso = (Acconta + String.valueOf(data.getTime()));
                Conta exemplo = new Conta();
                exemplo.Leitura(acesso, Acconta);
                return true;
            }
            return false;
        }
        return false;
    }

    public Acessar(int conta, String senha) throws IOException {
        Acessar.Acconta = conta;
        this.senha = senha;
    }

}
