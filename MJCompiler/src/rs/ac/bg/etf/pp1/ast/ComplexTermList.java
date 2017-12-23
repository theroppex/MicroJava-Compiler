// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ComplexTermList extends Term_list {

    private Term_list term_list;
    private Adop adop;
    private Term term;

    public ComplexTermList (Term_list term_list, Adop adop, Term term) {
        this.term_list=term_list;
        if(term_list!=null) term_list.setParent(this);
        this.adop=adop;
        if(adop!=null) adop.setParent(this);
        this.term=term;
        if(term!=null) term.setParent(this);
    }

    public Term_list getTerm_list() {
        return term_list;
    }

    public void setTerm_list(Term_list term_list) {
        this.term_list=term_list;
    }

    public Adop getAdop() {
        return adop;
    }

    public void setAdop(Adop adop) {
        this.adop=adop;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term=term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(term_list!=null) term_list.accept(visitor);
        if(adop!=null) adop.accept(visitor);
        if(term!=null) term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(term_list!=null) term_list.traverseTopDown(visitor);
        if(adop!=null) adop.traverseTopDown(visitor);
        if(term!=null) term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(term_list!=null) term_list.traverseBottomUp(visitor);
        if(adop!=null) adop.traverseBottomUp(visitor);
        if(term!=null) term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ComplexTermList(\n");

        if(term_list!=null)
            buffer.append(term_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(adop!=null)
            buffer.append(adop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(term!=null)
            buffer.append(term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ComplexTermList]");
        return buffer.toString();
    }
}
