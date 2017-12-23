// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private Designator_name designator_name;
    private Designator_list designator_list;

    public Designator (Designator_name designator_name, Designator_list designator_list) {
        this.designator_name=designator_name;
        if(designator_name!=null) designator_name.setParent(this);
        this.designator_list=designator_list;
        if(designator_list!=null) designator_list.setParent(this);
    }

    public Designator_name getDesignator_name() {
        return designator_name;
    }

    public void setDesignator_name(Designator_name designator_name) {
        this.designator_name=designator_name;
    }

    public Designator_list getDesignator_list() {
        return designator_list;
    }

    public void setDesignator_list(Designator_list designator_list) {
        this.designator_list=designator_list;
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
        if(designator_name!=null) designator_name.accept(visitor);
        if(designator_list!=null) designator_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(designator_name!=null) designator_name.traverseTopDown(visitor);
        if(designator_list!=null) designator_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(designator_name!=null) designator_name.traverseBottomUp(visitor);
        if(designator_list!=null) designator_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(designator_name!=null)
            buffer.append(designator_name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(designator_list!=null)
            buffer.append(designator_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
