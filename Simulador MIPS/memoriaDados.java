import java.util.ArrayList;

public class memoriaDados{
    ArrayList<Memoria_Valor> memo = new ArrayList<>();
    public  memoriaDados(){
        for (int i = 0; i < 30; i++) {
            memo.add(new Memoria_Valor(i, 0));
        }
    }
    public ArrayList<Memoria_Valor> getMemo(){
        return memo;
    }

}