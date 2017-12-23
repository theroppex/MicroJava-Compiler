// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList extends Var_decl_list {

    private Var_decl_list var_decl_list;
    private Var_decl var_decl;

    public VarDeclList (Var_decl_list var_decl_list, Var_decl var_decl) {
        this.var_decl_list=var_decl_list;
        if(var_decl_list!=null) var_decl_list.setParent(this);
        this.var_decl=var_decl;
        if(var_decl!=null) var_decl.setParent(this);
    }

    public Var_decl_list getVar_decl_list() {
        return var_decl_list;
    }

    public void setVar_decl_list(Var_decl_list var_decl_list) {
        this.var_decl_list=var_decl_list;
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
        if(var_decl_list!=null) var_decl_list.accept(visitor);
        if(var_decl!=null) var_decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(var_decl_list!=null) var_decl_list.traverseTopDown(visitor);
        if(var_decl!=null) var_decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(var_decl_list!=null) var_decl_list.traverseBottomUp(visitor);
        if(var_decl!=null) var_decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList(\n");

        if(var_decl_list!=null)
            buffer.append(var_decl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(var_decl!=null)
            buffer.append(var_decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclList]");
        return buffer.toString();
    }
}
