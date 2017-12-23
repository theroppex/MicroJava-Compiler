// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatement extends Statement {

    private Opt_expresion opt_expresion;

    public ReturnStatement (Opt_expresion opt_expresion) {
        this.opt_expresion=opt_expresion;
        if(opt_expresion!=null) opt_expresion.setParent(this);
    }

    public Opt_expresion getOpt_expresion() {
        return opt_expresion;
    }

    public void setOpt_expresion(Opt_expresion opt_expresion) {
        this.opt_expresion=opt_expresion;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(opt_expresion!=null) opt_expresion.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(opt_expresion!=null) opt_expresion.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(opt_expresion!=null) opt_expresion.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStatement(\n");

        if(opt_expresion!=null)
            buffer.append(opt_expresion.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatement]");
        return buffer.toString();
    }
}
