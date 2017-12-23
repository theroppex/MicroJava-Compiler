// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ComplexConditionList extends Condition_list {

    private Condition_list condition_list;
    private Cond_term cond_term;

    public ComplexConditionList (Condition_list condition_list, Cond_term cond_term) {
        this.condition_list=condition_list;
        if(condition_list!=null) condition_list.setParent(this);
        this.cond_term=cond_term;
        if(cond_term!=null) cond_term.setParent(this);
    }

    public Condition_list getCondition_list() {
        return condition_list;
    }

    public void setCondition_list(Condition_list condition_list) {
        this.condition_list=condition_list;
    }

    public Cond_term getCond_term() {
        return cond_term;
    }

    public void setCond_term(Cond_term cond_term) {
        this.cond_term=cond_term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condition_list!=null) condition_list.accept(visitor);
        if(cond_term!=null) cond_term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condition_list!=null) condition_list.traverseTopDown(visitor);
        if(cond_term!=null) cond_term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condition_list!=null) condition_list.traverseBottomUp(visitor);
        if(cond_term!=null) cond_term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ComplexConditionList(\n");

        if(condition_list!=null)
            buffer.append(condition_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(cond_term!=null)
            buffer.append(cond_term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ComplexConditionList]");
        return buffer.toString();
    }
}
