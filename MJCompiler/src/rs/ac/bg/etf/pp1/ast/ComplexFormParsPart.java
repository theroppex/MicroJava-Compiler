// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ComplexFormParsPart extends Form_pars_part {

    private Form_pars_part form_pars_part;
    private Form_par form_par;

    public ComplexFormParsPart (Form_pars_part form_pars_part, Form_par form_par) {
        this.form_pars_part=form_pars_part;
        if(form_pars_part!=null) form_pars_part.setParent(this);
        this.form_par=form_par;
        if(form_par!=null) form_par.setParent(this);
    }

    public Form_pars_part getForm_pars_part() {
        return form_pars_part;
    }

    public void setForm_pars_part(Form_pars_part form_pars_part) {
        this.form_pars_part=form_pars_part;
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
        if(form_pars_part!=null) form_pars_part.accept(visitor);
        if(form_par!=null) form_par.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(form_pars_part!=null) form_pars_part.traverseTopDown(visitor);
        if(form_par!=null) form_par.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(form_pars_part!=null) form_pars_part.traverseBottomUp(visitor);
        if(form_par!=null) form_par.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ComplexFormParsPart(\n");

        if(form_pars_part!=null)
            buffer.append(form_pars_part.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(form_par!=null)
            buffer.append(form_par.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ComplexFormParsPart]");
        return buffer.toString();
    }
}
