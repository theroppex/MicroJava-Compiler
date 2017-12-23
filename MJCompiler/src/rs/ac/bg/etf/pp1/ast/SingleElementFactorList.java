// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class SingleElementFactorList extends Factor_list {

    private Factor factor;

    public SingleElementFactorList (Factor factor) {
        this.factor=factor;
        if(factor!=null) factor.setParent(this);
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor=factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(factor!=null) factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(factor!=null) factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(factor!=null) factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleElementFactorList(\n");

        if(factor!=null)
            buffer.append(factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleElementFactorList]");
        return buffer.toString();
    }
}
