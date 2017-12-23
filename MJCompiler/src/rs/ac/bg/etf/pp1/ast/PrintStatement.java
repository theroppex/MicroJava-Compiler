// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement extends Statement {

    private Expr expr;
    private Opt_num_const opt_num_const;

    public PrintStatement (Expr expr, Opt_num_const opt_num_const) {
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
        this.opt_num_const=opt_num_const;
        if(opt_num_const!=null) opt_num_const.setParent(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public Opt_num_const getOpt_num_const() {
        return opt_num_const;
    }

    public void setOpt_num_const(Opt_num_const opt_num_const) {
        this.opt_num_const=opt_num_const;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expr!=null) expr.accept(visitor);
        if(opt_num_const!=null) opt_num_const.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
        if(opt_num_const!=null) opt_num_const.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expr!=null) expr.traverseBottomUp(visitor);
        if(opt_num_const!=null) opt_num_const.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(opt_num_const!=null)
            buffer.append(opt_num_const.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
