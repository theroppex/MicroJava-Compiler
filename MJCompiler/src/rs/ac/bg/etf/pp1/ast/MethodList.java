// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class MethodList extends Method_list {

    private Method_list method_list;
    private Method_decl method_decl;

    public MethodList (Method_list method_list, Method_decl method_decl) {
        this.method_list=method_list;
        if(method_list!=null) method_list.setParent(this);
        this.method_decl=method_decl;
        if(method_decl!=null) method_decl.setParent(this);
    }

    public Method_list getMethod_list() {
        return method_list;
    }

    public void setMethod_list(Method_list method_list) {
        this.method_list=method_list;
    }

    public Method_decl getMethod_decl() {
        return method_decl;
    }

    public void setMethod_decl(Method_decl method_decl) {
        this.method_decl=method_decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(method_list!=null) method_list.accept(visitor);
        if(method_decl!=null) method_decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(method_list!=null) method_list.traverseTopDown(visitor);
        if(method_decl!=null) method_decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(method_list!=null) method_list.traverseBottomUp(visitor);
        if(method_decl!=null) method_decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodList(\n");

        if(method_list!=null)
            buffer.append(method_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(method_decl!=null)
            buffer.append(method_decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodList]");
        return buffer.toString();
    }
}
