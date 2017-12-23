// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationPart extends Decl_part {

    private Var_decl var_decl;

    public VarDeclarationPart (Var_decl var_decl) {
        this.var_decl=var_decl;
        if(var_decl!=null) var_decl.setParent(this);
    }

    public Var_decl getVar_decl() {
        return var_decl;
    }

    public void setVar_decl(Var_decl var_decl) {
        this.var_decl=var_decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(var_decl!=null) var_decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(var_decl!=null) var_decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(var_decl!=null) var_decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationPart(\n");

        if(var_decl!=null)
            buffer.append(var_decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationPart]");
        return buffer.toString();
    }
}
