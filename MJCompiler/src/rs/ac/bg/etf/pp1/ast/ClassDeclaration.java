// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclaration extends Class_decl {

    private Class_name class_name;
    private Opt_extend opt_extend;
    private Method_list method_list;

    public ClassDeclaration (Class_name class_name, Opt_extend opt_extend, Method_list method_list) {
        this.class_name=class_name;
        if(class_name!=null) class_name.setParent(this);
        this.opt_extend=opt_extend;
        if(opt_extend!=null) opt_extend.setParent(this);
        this.method_list=method_list;
        if(method_list!=null) method_list.setParent(this);
    }

    public Class_name getClass_name() {
        return class_name;
    }

    public void setClass_name(Class_name class_name) {
        this.class_name=class_name;
    }

    public Opt_extend getOpt_extend() {
        return opt_extend;
    }

    public void setOpt_extend(Opt_extend opt_extend) {
        this.opt_extend=opt_extend;
    }

    public Method_list getMethod_list() {
        return method_list;
    }

    public void setMethod_list(Method_list method_list) {
        this.method_list=method_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(class_name!=null) class_name.accept(visitor);
        if(opt_extend!=null) opt_extend.accept(visitor);
        if(method_list!=null) method_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(class_name!=null) class_name.traverseTopDown(visitor);
        if(opt_extend!=null) opt_extend.traverseTopDown(visitor);
        if(method_list!=null) method_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(class_name!=null) class_name.traverseBottomUp(visitor);
        if(opt_extend!=null) opt_extend.traverseBottomUp(visitor);
        if(method_list!=null) method_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclaration(\n");

        if(class_name!=null)
            buffer.append(class_name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(opt_extend!=null)
            buffer.append(opt_extend.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(method_list!=null)
            buffer.append(method_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclaration]");
        return buffer.toString();
    }
}
