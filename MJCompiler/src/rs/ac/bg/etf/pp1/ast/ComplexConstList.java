// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class ComplexConstList extends Const_list {

    private Const_var const_var;
    private Const_list const_list;

    public ComplexConstList (Const_var const_var, Const_list const_list) {
        this.const_var=const_var;
        if(const_var!=null) const_var.setParent(this);
        this.const_list=const_list;
        if(const_list!=null) const_list.setParent(this);
    }

    public Const_var getConst_var() {
        return const_var;
    }

    public void setConst_var(Const_var const_var) {
        this.const_var=const_var;
    }

    public Const_list getConst_list() {
        return const_list;
    }

    public void setConst_list(Const_list const_list) {
        this.const_list=const_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(const_var!=null) const_var.accept(visitor);
        if(const_list!=null) const_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(const_var!=null) const_var.traverseTopDown(visitor);
        if(const_list!=null) const_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(const_var!=null) const_var.traverseBottomUp(visitor);
        if(const_list!=null) const_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ComplexConstList(\n");

        if(const_var!=null)
            buffer.append(const_var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(const_list!=null)
            buffer.append(const_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ComplexConstList]");
        return buffer.toString();
    }
}
