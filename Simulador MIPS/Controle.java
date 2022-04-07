public class Controle{
    private String instrucao;
    private String ALUOP;
    private boolean REGDST;
    private boolean JUMP;
    private boolean BRANCH;
    private boolean MEMREAD;
    private boolean MEMTOREG;
    private boolean MEMWRITE;
    private boolean ALUSRC;
    private boolean REGWRITE;

    public Controle(String instrucao){
        this.instrucao = instrucao;
        if (instrucao.equals("AND") || instrucao.equals("OR") || instrucao.equals("ADD")|| instrucao.equals("SUB")){
            this.REGDST = true;
            this.ALUSRC = false;
            this.JUMP = false;
            this.BRANCH = false;
            this.MEMREAD = false;
            this.MEMTOREG = false;
            this.MEMWRITE = false;
            this.REGWRITE = false;
            this.ALUOP = "10";
        }

        if (instrucao.equals("ADDI")){
            this.REGDST = false;
            this.ALUSRC = true;
            this.JUMP = false;
            this.BRANCH = false;
            this.MEMREAD = false;
            this.MEMTOREG = false;
            this.MEMWRITE = false;
            this.REGWRITE = false;
            this.ALUOP = "10";
        }

        if (instrucao.equals("LW")){
            this.REGDST = false;
            this.ALUSRC = false;
            this.JUMP = false;
            this.BRANCH = false;
            this.MEMREAD = false;
            this.MEMTOREG = false;
            this.MEMWRITE = true;
            this.REGWRITE = true;
            this.ALUOP = "00";
        }

        if (instrucao.equals("SW")){
            this.REGDST = false;
            this.ALUSRC = false;
            this.JUMP = false;
            this.BRANCH = false;
            this.MEMREAD = false;
            this.MEMTOREG = false;
            this.MEMWRITE = true;
            this.REGWRITE = false;
            this.ALUOP = "00";
        }

        if (instrucao.equals("BEQ")){
            this.REGDST = false;
            this.ALUSRC = false;
            this.JUMP = false;
            this.BRANCH = true;
            this.MEMREAD = false;
            this.MEMTOREG = false;
            this.MEMWRITE = false;
            this.REGWRITE = false;
            this.ALUOP = "01";
        }

        if (instrucao.equals("J")){
            this.REGDST = false;
            this.ALUSRC = false;
            this.JUMP = true;
            this.BRANCH = false;
            this.MEMREAD = false;
            this.MEMTOREG = false;
            this.MEMWRITE = false;
            this.REGWRITE = false;
            this.ALUOP = "11";
        }
    }

    public String getALUOP() {
        return ALUOP;
    }

    public boolean isREGDST() {
        return REGDST;
    }

    public boolean isJUMP() {
        return JUMP;
    }

    public boolean isBRANCH() {
        return BRANCH;
    }

    public boolean isMEMREAD() {
        return MEMREAD;
    }

    public boolean isMEMTOREG() {
        return MEMTOREG;
    }

    public boolean isMEMWRITE() {
        return MEMWRITE;
    }

    public boolean isALUSRC() {
        return ALUSRC;
    }

    public boolean isREGWRITE() {
        return REGWRITE;
    }

    @Override
    public String toString() {
        return 
                "Sinais gerados pela UNIDADE de controle\n"
                + "\n   ALUOp = " + ALUOP
                + "\n   RegDst = " + REGDST
                + "\n   Jump = " + JUMP
                + "\n   Branch = " + BRANCH
                + "\n   MemRead = " + MEMREAD
                + "\n   MemToReg = " + MEMTOREG
                + "\n   MemWrite = " + MEMWRITE
                + "\n   ALUSrc = " + ALUSRC
                + "\n   RegWrite = " + REGWRITE;
    }
}