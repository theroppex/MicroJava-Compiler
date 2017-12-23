// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationPart extends Decl_part {

    private Const_decl const_decl;

    public ConstDeclarationPart (Const_decl const_decl) {
        this.const_decl=const_decl;
        if(const_decl!=null) const_decl.setParent(this);
    }

    public Const_decl getConst_decl() {
        return const_decl;
    }

    public void setConst_decl(Const_decl const_decl) {
        this.const_decl=const_decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(const_decl!=null) const_decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(const_decl!=null) const_decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(const_decl!=null) const_decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationPart(\n");

        if(const_decl!=null)
            buffer.append(const_decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationPart]");
        return buffer.toString();
    }
}
