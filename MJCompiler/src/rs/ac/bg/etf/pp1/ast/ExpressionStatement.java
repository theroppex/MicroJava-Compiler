// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class ExpressionStatement extends Statement {

    private Designator_statement designator_statement;

    public ExpressionStatement (Designator_statement designator_statement) {
        this.designator_statement=designator_statement;
        if(designator_statement!=null) designator_statement.setParent(this);
    }

    public Designator_statement getDesignator_statement() {
        return designator_statement;
    }

    public void setDesignator_statement(Designator_statement designator_statement) {
        this.designator_statement=designator_statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(designator_statement!=null) designator_statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(designator_statement!=null) designator_statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(designator_statement!=null) designator_statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionStatement(\n");

        if(designator_statement!=null)
            buffer.append(designator_statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionStatement]");
        return buffer.toString();
    }
}
