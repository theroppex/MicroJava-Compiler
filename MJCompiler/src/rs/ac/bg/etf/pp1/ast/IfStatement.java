// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class IfStatement extends Statement {

    private Condition condition;
    private Statement statement;
    private Opt_else opt_else;

    public IfStatement (Condition condition, Statement statement, Opt_else opt_else) {
        this.condition=condition;
        if(condition!=null) condition.setParent(this);
        this.statement=statement;
        if(statement!=null) statement.setParent(this);
        this.opt_else=opt_else;
        if(opt_else!=null) opt_else.setParent(this);
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition=condition;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement=statement;
    }

    public Opt_else getOpt_else() {
        return opt_else;
    }

    public void setOpt_else(Opt_else opt_else) {
        this.opt_else=opt_else;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condition!=null) condition.accept(visitor);
        if(statement!=null) statement.accept(visitor);
        if(opt_else!=null) opt_else.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condition!=null) condition.traverseTopDown(visitor);
        if(statement!=null) statement.traverseTopDown(visitor);
        if(opt_else!=null) opt_else.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condition!=null) condition.traverseBottomUp(visitor);
        if(statement!=null) statement.traverseBottomUp(visitor);
        if(opt_else!=null) opt_else.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStatement(\n");

        if(condition!=null)
            buffer.append(condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statement!=null)
            buffer.append(statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(opt_else!=null)
            buffer.append(opt_else.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStatement]");
        return buffer.toString();
    }
}
