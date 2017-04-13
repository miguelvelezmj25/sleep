package edu.cmu.cs.mvelezce.sleep.ast.statement;

import edu.cmu.cs.mvelezce.sleep.ast.expression.VariableExpression;
import edu.cmu.cs.mvelezce.sleep.visitor.Visitor;
import edu.cmu.cs.mvelezce.sleep.ast.expression.Expression;

/**
 * An assignment statement of the form {@code exprVariable op expr}.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class AssignmentStatement extends Statement {
    private VariableExpression variable;
    private Expression right;

    public AssignmentStatement(VariableExpression variable, Expression right) {
        if(variable == null) {
            throw new IllegalArgumentException("The variable cannot be null");
        }

        if(right == null) {
            throw new IllegalArgumentException("The right cannot be null");
        }

        this.variable = variable;
        this.right = right;
    }

    @Override
    public <T,U> U accept(Visitor<T,U> visitor) {
        return visitor.visitStatementAssignment(this);
    }

    /**
     * Returns the variable of the assignment.
     *
     * @return
     */
    public VariableExpression getVariable() { return this.variable; }

    /**
     * Returns the expression of the assignment.
     *
     * @return
     */
    public Expression getRight() { return this.right; }

    @Override
    public String toString() { return this.variable + "=" + this.right; }

}
