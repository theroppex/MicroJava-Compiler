// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class Declarations extends Decl_list {

    private Decl_list decl_list;
    private Decl_part decl_part;

    public Declarations (Decl_list decl_list, Decl_part decl_part) {
        this.decl_list=decl_list;
        if(decl_list!=null) decl_list.setParent(this);
        this.decl_part=decl_part;
        if(decl_part!=null) decl_part.setParent(this);
    }

    public Decl_list getDecl_list() {
        return decl_list;
    }

    public void setDecl_list(Decl_list decl_list) {
        this.decl_list=decl_list;
    }

    public Decl_part getDecl_part() {
        return decl_part;
    }

    public void setDecl_part(Decl_part decl_part) {
        this.decl_part=decl_part;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(decl_list!=null) decl_list.accept(visitor);
        if(decl_part!=null) decl_part.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(decl_list!=null) decl_list.traverseTopDown(visitor);
        if(decl_part!=null) decl_part.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(decl_list!=null) decl_list.traverseBottomUp(visitor);
        if(decl_part!=null) decl_part.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Declarations(\n");

        if(decl_list!=null)
            buffer.append(decl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(decl_part!=null)
            buffer.append(decl_part.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Declarations]");
        return buffer.toString();
    }
}
