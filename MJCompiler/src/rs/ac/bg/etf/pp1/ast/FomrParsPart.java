// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class FomrParsPart extends Form_pars_part {

    private Form_par form_par;

    public FomrParsPart (Form_par form_par) {
        this.form_par=form_par;
        if(form_par!=null) form_par.setParent(this);
    }

    public Form_par getForm_par() {
        return form_par;
    }

    public void setForm_par(Form_par form_par) {
        this.form_par=form_par;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(form_par!=null) form_par.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(form_par!=null) form_par.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(form_par!=null) form_par.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FomrParsPart(\n");

        if(form_par!=null)
            buffer.append(form_par.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FomrParsPart]");
        return buffer.toString();
    }
}
