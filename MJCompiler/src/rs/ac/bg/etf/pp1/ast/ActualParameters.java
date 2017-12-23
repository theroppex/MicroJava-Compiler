// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ActualParameters extends Act_pars {

    private Act_pars_list act_pars_list;

    public ActualParameters (Act_pars_list act_pars_list) {
        this.act_pars_list=act_pars_list;
        if(act_pars_list!=null) act_pars_list.setParent(this);
    }

    public Act_pars_list getAct_pars_list() {
        return act_pars_list;
    }

    public void setAct_pars_list(Act_pars_list act_pars_list) {
        this.act_pars_list=act_pars_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(act_pars_list!=null) act_pars_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(act_pars_list!=null) act_pars_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(act_pars_list!=null) act_pars_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParameters(\n");

        if(act_pars_list!=null)
            buffer.append(act_pars_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParameters]");
        return buffer.toString();
    }
}
