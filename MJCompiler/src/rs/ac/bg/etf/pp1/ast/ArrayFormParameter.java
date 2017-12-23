// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ArrayFormParameter extends Form_par {

    private Type type;
    private Form_par_name form_par_name;

    public ArrayFormParameter (Type type, Form_par_name form_par_name) {
        this.type=type;
        if(type!=null) type.setParent(this);
        this.form_par_name=form_par_name;
        if(form_par_name!=null) form_par_name.setParent(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type=type;
    }

    public Form_par_name getForm_par_name() {
        return form_par_name;
    }

    public void setForm_par_name(Form_par_name form_par_name) {
        this.form_par_name=form_par_name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(type!=null) type.accept(visitor);
        if(form_par_name!=null) form_par_name.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(type!=null) type.traverseTopDown(visitor);
        if(form_par_name!=null) form_par_name.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(type!=null) type.traverseBottomUp(visitor);
        if(form_par_name!=null) form_par_name.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayFormParameter(\n");

        if(type!=null)
            buffer.append(type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(form_par_name!=null)
            buffer.append(form_par_name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayFormParameter]");
        return buffer.toString();
    }
}
