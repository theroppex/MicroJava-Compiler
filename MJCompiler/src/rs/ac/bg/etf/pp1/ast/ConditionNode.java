// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ConditionNode extends Condition {

    private Condition_list condition_list;

    public ConditionNode (Condition_list condition_list) {
        this.condition_list=condition_list;
        if(condition_list!=null) condition_list.setParent(this);
    }

    public Condition_list getCondition_list() {
        return condition_list;
    }

    public void setCondition_list(Condition_list condition_list) {
        this.condition_list=condition_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condition_list!=null) condition_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condition_list!=null) condition_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condition_list!=null) condition_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionNode(\n");

        if(condition_list!=null)
            buffer.append(condition_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionNode]");
        return buffer.toString();
    }
}
