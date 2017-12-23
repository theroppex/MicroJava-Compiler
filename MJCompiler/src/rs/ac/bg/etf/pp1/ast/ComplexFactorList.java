// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ComplexFactorList extends Factor_list {

    private Factor_list factor_list;
    private Mulop mulop;
    private Factor factor;

    public ComplexFactorList (Factor_list factor_list, Mulop mulop, Factor factor) {
        this.factor_list=factor_list;
        if(factor_list!=null) factor_list.setParent(this);
        this.mulop=mulop;
        if(mulop!=null) mulop.setParent(this);
        this.factor=factor;
        if(factor!=null) factor.setParent(this);
    }

    public Factor_list getFactor_list() {
        return factor_list;
    }

    public void setFactor_list(Factor_list factor_list) {
        this.factor_list=factor_list;
    }

    public Mulop getMulop() {
        return mulop;
    }

    public void setMulop(Mulop mulop) {
        this.mulop=mulop;
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
        if(factor_list!=null) factor_list.accept(visitor);
        if(mulop!=null) mulop.accept(visitor);
        if(factor!=null) factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(factor_list!=null) factor_list.traverseTopDown(visitor);
        if(mulop!=null) mulop.traverseTopDown(visitor);
        if(factor!=null) factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(factor_list!=null) factor_list.traverseBottomUp(visitor);
        if(mulop!=null) mulop.traverseBottomUp(visitor);
        if(factor!=null) factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ComplexFactorList(\n");

        if(factor_list!=null)
            buffer.append(factor_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(mulop!=null)
            buffer.append(mulop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(factor!=null)
            buffer.append(factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ComplexFactorList]");
        return buffer.toString();
    }
}
