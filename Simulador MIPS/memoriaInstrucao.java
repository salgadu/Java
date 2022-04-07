import java.util.ArrayList;

public class memoriaInstrucao {
    ArrayList<String> comandos = new ArrayList<>();
    ArrayList<String> instrucao = new ArrayList<>();

    public memoriaInstrucao(ArrayList<String> instrucao){
      this.instrucao = instrucao;
    }

	public String selecionarInstrucao(PC pc){
		return instrucao.get(pc.getValor());
	}
}
