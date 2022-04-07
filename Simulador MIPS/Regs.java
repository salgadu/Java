import java.util.ArrayList;

public class Regs{
    ArrayList<Regs_Valor> regs = new ArrayList<>();
    ArrayList<Memoria_Valor> memo = new ArrayList<>();
    PC pc;
    Controle controle;

    public Regs(ArrayList<Memoria_Valor> memoria, PC pc) {
        initRegs();
        this.memo = memoria;
        this.pc = pc;
    }
    
    public void initRegs(){
        regs.add(new Regs_Valor("s0", 10));
        regs.add(new Regs_Valor("s1", 3));
        regs.add(new Regs_Valor("s2", 5));
        regs.add(new Regs_Valor("s3", 1));
        regs.add(new Regs_Valor("s4", 0));
        regs.add(new Regs_Valor("s5", 7));
        regs.add(new Regs_Valor("s6", 2));
        regs.add(new Regs_Valor("s7", 3));        
    }

    public void receberInstrucao(String instrucao){
        String [] vetor = instrucao.split(" ");
        String regGuardar = vetor[1];
        String regOp1 = vetor[2];
        String regOp2 = vetor[3];
        String opcao = vetor[0];
        controle = new Controle(opcao);

        if (opcao.equals("AND") || opcao.equals("OR") || opcao.equals("ADDI") || opcao.equals("ADD")|| opcao.equals("SUB")){
            ULA ula = new ULA(pc);
            pc = ula.getPC();
            regs = ula.realizarOps(regGuardar, regOp1, regOp2, opcao, regs);
        }

        if (opcao.equals("LW") || opcao.equals("SW")){
            Regs_Valor reg1 = null;
            Regs_Valor reg2 = null;
            Regs_Valor regGua = null;
            
            for (Regs_Valor i : regs) {
                if (i.getNome().equals(regOp1)){
                    reg1 = i;
                }
                if (i.getNome().equals(regOp2)){
                    reg2 = i;
                }
                if (i.getNome().equals(regGuardar)){
                    regGua = i;
                }   
            }
            
            switch (opcao) {
                case "LW":
                    regGua.setValor(memo.get((Integer.parseInt(regOp1)) + reg2.getValor()).getValor());
                    pc.setValor(pc.getValor() + 1);
                    break;
                case "SW":
                    memo.get((Integer.parseInt(regOp1)) + regGua.getValor()).setValor(reg2.getValor());
                    pc.setValor(pc.getValor() + 1);
                    //SW s1 1 s2
                    break;
                case "J":
                    pc.setValor(Integer.parseInt(regGuardar));
                    break;
            }   
        }
    }
    
    public PC getPC(){
        return pc;
    }

    public ArrayList<Memoria_Valor> getMemoria(){
        return memo;
    }

    public ArrayList<Regs_Valor> getRegs(){
        return regs;
    }

    public Controle getControle(){
        return controle;
    }

}