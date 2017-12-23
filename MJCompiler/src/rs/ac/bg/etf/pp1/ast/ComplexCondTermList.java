// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ComplexCondTermList extends Cond_term_list {

    private Cond_term_list cond_term_list;
    private Cond_fact cond_fact;

    public ComplexCondTermList (Cond_term_list cond_term_list, Cond_fact cond_fact) {
        this.cond_term_list=cond_term_list;
        if(cond_term_list!=null) cond_term_list.setParent(this);
        this.cond_fact=cond_fact;
        if(cond_fact!=null) cond_fact.setParent(this);
    }

    public Cond_term_list getCond_term_list() {
        return cond_term_list;
    }

    public void setCond_term_list(Cond_term_list cond_term_list) {
        this.cond_term_list=cond_term_list;
    }

    public Cond_fact getCond_fact() {
        return cond_fact;
    }

    public void setCond_fact(Cond_fact cond_fact) {
        this.cond_fact=cond_fact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(cond_term_list!=null) cond_term_list.accept(visitor);
        if(cond_fact!=null) cond_fact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(cond_term_list!=null) cond_term_list.traverseTopDown(visitor);
        if(cond_fact!=null) cond_fact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(cond_term_list!=null) cond_term_list.traverseBottomUp(visitor);
        if(cond_fact!=null) cond_fact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ComplexCondTermList(\n");

        if(cond_term_list!=null)
            buffer.append(cond_term_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(cond_fact!=null)
            buffer.append(cond_fact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ComplexCondTermList]");
        return buffer.toString();
    }
}
