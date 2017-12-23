// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ActualParsList extends Act_pars_list {

    private Act_pars_list act_pars_list;
    private Expr expr;

    public ActualParsList (Act_pars_list act_pars_list, Expr expr) {
        this.act_pars_list=act_pars_list;
        if(act_pars_list!=null) act_pars_list.setParent(this);
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
    }

    public Act_pars_list getAct_pars_list() {
        return act_pars_list;
    }

    public void setAct_pars_list(Act_pars_list act_pars_list) {
        this.act_pars_list=act_pars_list;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(act_pars_list!=null) act_pars_list.accept(visitor);
        if(expr!=null) expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(act_pars_list!=null) act_pars_list.traverseTopDown(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(act_pars_list!=null) act_pars_list.traverseBottomUp(visitor);
        if(expr!=null) expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParsList(\n");

        if(act_pars_list!=null)
            buffer.append(act_pars_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParsList]");
        return buffer.toString();
    }
}
