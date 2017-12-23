// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ArrayElementDesignatorList extends Designator_list {

    private Expr expr;
    private Designator_list designator_list;

    public ArrayElementDesignatorList (Expr expr, Designator_list designator_list) {
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
        this.designator_list=designator_list;
        if(designator_list!=null) designator_list.setParent(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public Designator_list getDesignator_list() {
        return designator_list;
    }

    public void setDesignator_list(Designator_list designator_list) {
        this.designator_list=designator_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expr!=null) expr.accept(visitor);
        if(designator_list!=null) designator_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
        if(designator_list!=null) designator_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expr!=null) expr.traverseBottomUp(visitor);
        if(designator_list!=null) designator_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayElementDesignatorList(\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(designator_list!=null)
            buffer.append(designator_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayElementDesignatorList]");
        return buffer.toString();
    }
}
