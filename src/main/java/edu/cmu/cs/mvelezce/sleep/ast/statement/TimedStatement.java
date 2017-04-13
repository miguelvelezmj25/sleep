package edu.cmu.cs.mvelezce.sleep.ast.statement;

import edu.cmu.cs.mvelezce.sleep.visitor.Visitor;

/**
 * A statement that should be timed.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class TimedStatement extends Statement {
    private Statement statements;

    /**
     * Instantiates a {@code TimedStatement}.
     *
     * @param statements
     */
    public TimedStatement(Statement statements) {
        if(statements == null) {
            throw new IllegalArgumentException("The statements cannot be null");
        }

        this.statements = statements;
    }

    @Override
    public <T,U> U accept(Visitor<T,U> visitor) {
        return visitor.visitStatementTimed(this);
    }

    public Statement getStatements() { return this.statements; }

    @Override
    public String toString() { return "Time: " + this.statements; }
}
