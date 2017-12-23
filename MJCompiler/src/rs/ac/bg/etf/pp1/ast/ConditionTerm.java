// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ConditionTerm extends Cond_term {

    private Cond_term_list cond_term_list;

    public ConditionTerm (Cond_term_list cond_term_list) {
        this.cond_term_list=cond_term_list;
        if(cond_term_list!=null) cond_term_list.setParent(this);
    }

    public Cond_term_list getCond_term_list() {
        return cond_term_list;
    }

    public void setCond_term_list(Cond_term_list cond_term_list) {
        this.cond_term_list=cond_term_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(cond_term_list!=null) cond_term_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(cond_term_list!=null) cond_term_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(cond_term_list!=null) cond_term_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionTerm(\n");

        if(cond_term_list!=null)
            buffer.append(cond_term_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionTerm]");
        return buffer.toString();
    }
}
