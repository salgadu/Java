import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<String> cmd = new ArrayList<>();
        ArrayList<Regs_Valor> listRegs = new ArrayList<>();

        System.out.println("Simulador MIPS\n");

        Scanner entrada = new Scanner(System.in);
        String aux;
        do {
            System.out.print(">> ");
            aux = entrada.nextLine();
            cmd.add(aux); 
        }while (!aux.equals("next"));

        PC pc = new PC();
        memoriaDados memoriaD = new memoriaDados();
        ArrayList <Memoria_Valor> listMemo = memoriaD.getMemo();
        
        for (int i = 0; i < cmd.size()-1; i++) {
            memoriaInstrucao memoria = new memoriaInstrucao(cmd);
            Regs registrador = new Regs(listMemo, pc);
            registrador.receberInstrucao(memoria.selecionarInstrucao(pc));
            
            System.out.println();
            
            pc = registrador.getPC();
            listRegs = registrador.getRegs();
            listMemo = registrador.getMemoria();

            System.out.println("Valor PC: " + pc.getValor());
            System.out.println("--------------------------");
            System.out.println("Registradores\n");
            for (Regs_Valor r : listRegs) {
                System.out.println(r.getNome() + " " + r.getValor());
            }
            System.out.println("--------------------------");
            System.out.println("Memoria\n");
            for (Memoria_Valor m : listMemo) {
                System.out.println(m.getPosicao() + " " + m.getValor());
            }
            System.out.println("--------------------------");
            Controle ctr = registrador.getControle();
            System.out.println(ctr.toString());
        }    
    }
}                   
