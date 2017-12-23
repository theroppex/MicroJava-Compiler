// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class BlockStatement extends Statement {

    private Statement_list statement_list;

    public BlockStatement (Statement_list statement_list) {
        this.statement_list=statement_list;
        if(statement_list!=null) statement_list.setParent(this);
    }

    public Statement_list getStatement_list() {
        return statement_list;
    }

    public void setStatement_list(Statement_list statement_list) {
        this.statement_list=statement_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(statement_list!=null) statement_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(statement_list!=null) statement_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(statement_list!=null) statement_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BlockStatement(\n");

        if(statement_list!=null)
            buffer.append(statement_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BlockStatement]");
        return buffer.toString();
    }
}
