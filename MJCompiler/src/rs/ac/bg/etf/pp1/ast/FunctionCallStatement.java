// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class FunctionCallStatement extends Designator_statement {

    private Designator designator;
    private Opt_actual_pars opt_actual_pars;

    public FunctionCallStatement (Designator designator, Opt_actual_pars opt_actual_pars) {
        this.designator=designator;
        if(designator!=null) designator.setParent(this);
        this.opt_actual_pars=opt_actual_pars;
        if(opt_actual_pars!=null) opt_actual_pars.setParent(this);
    }

    public Designator getDesignator() {
        return designator;
    }

    public void setDesignator(Designator designator) {
        this.designator=designator;
    }

    public Opt_actual_pars getOpt_actual_pars() {
        return opt_actual_pars;
    }

    public void setOpt_actual_pars(Opt_actual_pars opt_actual_pars) {
        this.opt_actual_pars=opt_actual_pars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(designator!=null) designator.accept(visitor);
        if(opt_actual_pars!=null) opt_actual_pars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(designator!=null) designator.traverseTopDown(visitor);
        if(opt_actual_pars!=null) opt_actual_pars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(designator!=null) designator.traverseBottomUp(visitor);
        if(opt_actual_pars!=null) opt_actual_pars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionCallStatement(\n");

        if(designator!=null)
            buffer.append(designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(opt_actual_pars!=null)
            buffer.append(opt_actual_pars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionCallStatement]");
        return buffer.toString();
    }
}
