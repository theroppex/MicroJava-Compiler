// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class MethodCallParameters extends Opt_actual_pars {

    private Act_pars act_pars;

    public MethodCallParameters (Act_pars act_pars) {
        this.act_pars=act_pars;
        if(act_pars!=null) act_pars.setParent(this);
    }

    public Act_pars getAct_pars() {
        return act_pars;
    }

    public void setAct_pars(Act_pars act_pars) {
        this.act_pars=act_pars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(act_pars!=null) act_pars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(act_pars!=null) act_pars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(act_pars!=null) act_pars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodCallParameters(\n");

        if(act_pars!=null)
            buffer.append(act_pars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodCallParameters]");
        return buffer.toString();
    }
}
