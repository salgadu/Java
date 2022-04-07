package banco.codigos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Arquivos {

    public Boolean auxConta(int conta) {
        return new File("../Banco/src/banco/arquivos/" + conta).exists();
    }

    protected Boolean auxSenha(String senha, int conta) throws IOException {
        FileReader senhaA = new FileReader("../Banco/src/banco/arquivos/" + conta + "/senha.txt");
        BufferedReader lerA = new BufferedReader(senhaA);
        String a = lerA.readLine();
        if (senha.trim().equals(a)) {
            senhaA.close();
            return true;
        } else {
            senhaA.close();
            return false;
        }
    }
}
