// generated with ast extension for cup
// version 0.8
// 23/11/2017 2:24:53


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration extends Method_decl {

    private Method_ret_type method_ret_type;
    private Method_name method_name;
    private Form_pars_list form_pars_list;
    private Var_decl_list var_decl_list;
    private Statement_list statement_list;

    public MethodDeclaration (Method_ret_type method_ret_type, Method_name method_name, Form_pars_list form_pars_list, Var_decl_list var_decl_list, Statement_list statement_list) {
        this.method_ret_type=method_ret_type;
        if(method_ret_type!=null) method_ret_type.setParent(this);
        this.method_name=method_name;
        if(method_name!=null) method_name.setParent(this);
        this.form_pars_list=form_pars_list;
        if(form_pars_list!=null) form_pars_list.setParent(this);
        this.var_decl_list=var_decl_list;
        if(var_decl_list!=null) var_decl_list.setParent(this);
        this.statement_list=statement_list;
        if(statement_list!=null) statement_list.setParent(this);
    }

    public Method_ret_type getMethod_ret_type() {
        return method_ret_type;
    }

    public void setMethod_ret_type(Method_ret_type method_ret_type) {
        this.method_ret_type=method_ret_type;
    }

    public Method_name getMethod_name() {
        return method_name;
    }

    public void setMethod_name(Method_name method_name) {
        this.method_name=method_name;
    }

    public Form_pars_list getForm_pars_list() {
        return form_pars_list;
    }

    public void setForm_pars_list(Form_pars_list form_pars_list) {
        this.form_pars_list=form_pars_list;
    }

    public Var_decl_list getVar_decl_list() {
        return var_decl_list;
    }

    public void setVar_decl_list(Var_decl_list var_decl_list) {
        this.var_decl_list=var_decl_list;
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
        if(method_ret_type!=null) method_ret_type.accept(visitor);
        if(method_name!=null) method_name.accept(visitor);
        if(form_pars_list!=null) form_pars_list.accept(visitor);
        if(var_decl_list!=null) var_decl_list.accept(visitor);
        if(statement_list!=null) statement_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(method_ret_type!=null) method_ret_type.traverseTopDown(visitor);
        if(method_name!=null) method_name.traverseTopDown(visitor);
        if(form_pars_list!=null) form_pars_list.traverseTopDown(visitor);
        if(var_decl_list!=null) var_decl_list.traverseTopDown(visitor);
        if(statement_list!=null) statement_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(method_ret_type!=null) method_ret_type.traverseBottomUp(visitor);
        if(method_name!=null) method_name.traverseBottomUp(visitor);
        if(form_pars_list!=null) form_pars_list.traverseBottomUp(visitor);
        if(var_decl_list!=null) var_decl_list.traverseBottomUp(visitor);
        if(statement_list!=null) statement_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(method_ret_type!=null)
            buffer.append(method_ret_type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(method_name!=null)
            buffer.append(method_name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(form_pars_list!=null)
            buffer.append(form_pars_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(var_decl_list!=null)
            buffer.append(var_decl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statement_list!=null)
            buffer.append(statement_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
