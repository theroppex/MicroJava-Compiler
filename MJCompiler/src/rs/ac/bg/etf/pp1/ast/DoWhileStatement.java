// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class DoWhileStatement extends Statement {

    private Statement statement;
    private Condition condition;

    public DoWhileStatement (Statement statement, Condition condition) {
        this.statement=statement;
        if(statement!=null) statement.setParent(this);
        this.condition=condition;
        if(condition!=null) condition.setParent(this);
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement=statement;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition=condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(statement!=null) statement.accept(visitor);
        if(condition!=null) condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(statement!=null) statement.traverseTopDown(visitor);
        if(condition!=null) condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(statement!=null) statement.traverseBottomUp(visitor);
        if(condition!=null) condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DoWhileStatement(\n");

        if(statement!=null)
            buffer.append(statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(condition!=null)
            buffer.append(condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DoWhileStatement]");
        return buffer.toString();
    }
}
