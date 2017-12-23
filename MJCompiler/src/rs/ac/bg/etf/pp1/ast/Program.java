// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private Prog_id prog_id;
    private Decl_list decl_list;
    private Method_list method_list;

    public Program (Prog_id prog_id, Decl_list decl_list, Method_list method_list) {
        this.prog_id=prog_id;
        if(prog_id!=null) prog_id.setParent(this);
        this.decl_list=decl_list;
        if(decl_list!=null) decl_list.setParent(this);
        this.method_list=method_list;
        if(method_list!=null) method_list.setParent(this);
    }

    public Prog_id getProg_id() {
        return prog_id;
    }

    public void setProg_id(Prog_id prog_id) {
        this.prog_id=prog_id;
    }

    public Decl_list getDecl_list() {
        return decl_list;
    }

    public void setDecl_list(Decl_list decl_list) {
        this.decl_list=decl_list;
    }

    public Method_list getMethod_list() {
        return method_list;
    }

    public void setMethod_list(Method_list method_list) {
        this.method_list=method_list;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(prog_id!=null) prog_id.accept(visitor);
        if(decl_list!=null) decl_list.accept(visitor);
        if(method_list!=null) method_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(prog_id!=null) prog_id.traverseTopDown(visitor);
        if(decl_list!=null) decl_list.traverseTopDown(visitor);
        if(method_list!=null) method_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(prog_id!=null) prog_id.traverseBottomUp(visitor);
        if(decl_list!=null) decl_list.traverseBottomUp(visitor);
        if(method_list!=null) method_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(prog_id!=null)
            buffer.append(prog_id.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(decl_list!=null)
            buffer.append(decl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(method_list!=null)
            buffer.append(method_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
