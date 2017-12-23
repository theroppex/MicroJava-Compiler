// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclartionPart extends Decl_part {

    private Class_decl class_decl;

    public ClassDeclartionPart (Class_decl class_decl) {
        this.class_decl=class_decl;
        if(class_decl!=null) class_decl.setParent(this);
    }

    public Class_decl getClass_decl() {
        return class_decl;
    }

    public void setClass_decl(Class_decl class_decl) {
        this.class_decl=class_decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(class_decl!=null) class_decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(class_decl!=null) class_decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(class_decl!=null) class_decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclartionPart(\n");

        if(class_decl!=null)
            buffer.append(class_decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclartionPart]");
        return buffer.toString();
    }
}
