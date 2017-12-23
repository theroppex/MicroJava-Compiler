// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class SingleElementCondList extends Condition_list {

    private Cond_term cond_term;

    public SingleElementCondList (Cond_term cond_term) {
        this.cond_term=cond_term;
        if(cond_term!=null) cond_term.setParent(this);
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
        if(cond_term!=null) cond_term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(cond_term!=null) cond_term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(cond_term!=null) cond_term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleElementCondList(\n");

        if(cond_term!=null)
            buffer.append(cond_term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleElementCondList]");
        return buffer.toString();
    }
}
