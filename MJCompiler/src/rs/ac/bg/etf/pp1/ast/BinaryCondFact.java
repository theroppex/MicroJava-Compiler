// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class BinaryCondFact extends Cond_fact {

    private Expr expr;
    private Relop relop;
    private Expr expr1;

    public BinaryCondFact (Expr expr, Relop relop, Expr expr1) {
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
        this.relop=relop;
        if(relop!=null) relop.setParent(this);
        this.expr1=expr1;
        if(expr1!=null) expr1.setParent(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public Relop getRelop() {
        return relop;
    }

    public void setRelop(Relop relop) {
        this.relop=relop;
    }

    public Expr getExpr1() {
        return expr1;
    }

    public void setExpr1(Expr expr1) {
        this.expr1=expr1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expr!=null) expr.accept(visitor);
        if(relop!=null) relop.accept(visitor);
        if(expr1!=null) expr1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
        if(relop!=null) relop.traverseTopDown(visitor);
        if(expr1!=null) expr1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expr!=null) expr.traverseBottomUp(visitor);
        if(relop!=null) relop.traverseBottomUp(visitor);
        if(expr1!=null) expr1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BinaryCondFact(\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(relop!=null)
            buffer.append(relop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(expr1!=null)
            buffer.append(expr1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BinaryCondFact]");
        return buffer.toString();
    }
}
