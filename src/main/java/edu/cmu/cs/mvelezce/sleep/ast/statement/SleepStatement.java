package edu.cmu.cs.mvelezce.sleep.ast.statement;

import edu.cmu.cs.mvelezce.sleep.visitor.Visitor;
import edu.cmu.cs.mvelezce.sleep.ast.expression.Expression;

/**
 * A sleep statement.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class SleepStatement extends Statement {
    private Expression time;

    /**
     * Instantiates a {@code SleepStatement}.
     *
     * @param time
     */
    public SleepStatement(Expression time) {
        this.time = time;
    }

    @Override
    public <T,U> U accept(Visitor<T,U> visitor) {
        return visitor.visitStatementSleep(this);
    }

    /**
     * Returns the time to sleep.
     *
     * @return
     */
    public Expression getTime() { return this.time; }

    @Override
    public String toString() { return "sleep(" + this.time + ")"; }
}
