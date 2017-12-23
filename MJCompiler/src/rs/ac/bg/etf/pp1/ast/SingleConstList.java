// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class SingleConstList extends Const_list {

    private Const_var const_var;

    public SingleConstList (Const_var const_var) {
        this.const_var=const_var;
        if(const_var!=null) const_var.setParent(this);
    }

    public Const_var getConst_var() {
        return const_var;
    }

    public void setConst_var(Const_var const_var) {
        this.const_var=const_var;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(const_var!=null) const_var.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(const_var!=null) const_var.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(const_var!=null) const_var.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConstList(\n");

        if(const_var!=null)
            buffer.append(const_var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleConstList]");
        return buffer.toString();
    }
}
