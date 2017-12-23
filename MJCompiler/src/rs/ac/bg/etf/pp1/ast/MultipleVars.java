// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class MultipleVars extends Var_list {

    private Var_list var_list;
    private Var var;

    public MultipleVars (Var_list var_list, Var var) {
        this.var_list=var_list;
        if(var_list!=null) var_list.setParent(this);
        this.var=var;
        if(var!=null) var.setParent(this);
    }

    public Var_list getVar_list() {
        return var_list;
    }

    public void setVar_list(Var_list var_list) {
        this.var_list=var_list;
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var=var;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(var_list!=null) var_list.accept(visitor);
        if(var!=null) var.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(var_list!=null) var_list.traverseTopDown(visitor);
        if(var!=null) var.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(var_list!=null) var_list.traverseBottomUp(visitor);
        if(var!=null) var.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleVars(\n");

        if(var_list!=null)
            buffer.append(var_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(var!=null)
            buffer.append(var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleVars]");
        return buffer.toString();
    }
}
