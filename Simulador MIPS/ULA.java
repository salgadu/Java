import java.util.ArrayList;

public class ULA{
    private String regGuardar;
    private String regOp1;
    private String regOp2;
    private String opcao;

    PC pc;

    public ULA(PC pc){
        this.pc = pc;
    }

    public ArrayList<Regs_Valor> realizarOps(String regGuardar, String regOp1, String regOp2, String opcao, ArrayList<Regs_Valor> regs){
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
            case "ADD":
                regGua.setValor(reg1.getValor() + reg2.getValor());
                pc.setValor(pc.getValor() + 1);
                break;
            case "SUB":
                regGua.setValor(reg1.getValor() - reg2.getValor());
                pc.setValor(pc.getValor() + 1);
                break;
            case "ADDI":
                regGua.setValor(reg1.getValor() + (Integer.parseInt(regOp2)));
                pc.setValor(pc.getValor() + 1);
                break;
            case "OR":
                regGua.setValor((reg1.getValor() == 1) || (reg2.getValor() == 1) ? 1 : 0);
                pc.setValor(pc.getValor() + 1);
                break;
            case "AND":
                regGua.setValor((reg1.getValor() == 1) && (reg2.getValor() == 1) ? 1 : 0);
                pc.setValor(pc.getValor() + 1);
                break;
            default:
                break;
        }
        return regs;
    }

    public PC getPC(){
        return pc;
    }
}