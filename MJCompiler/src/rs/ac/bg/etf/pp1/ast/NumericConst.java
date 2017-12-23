// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:52


package rs.ac.bg.etf.pp1.ast;

public class NumericConst extends Const_var {

    private String id;
    private Integer c;

    public NumericConst (String id, Integer c) {
        this.id=id;
        this.c=c;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c=c;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NumericConst(\n");

        buffer.append(" "+tab+id);
        buffer.append("\n");

        buffer.append(" "+tab+c);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumericConst]");
        return buffer.toString();
    }
}
