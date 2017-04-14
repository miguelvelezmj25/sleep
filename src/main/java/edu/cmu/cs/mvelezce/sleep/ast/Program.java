package edu.cmu.cs.mvelezce.sleep.ast;

import edu.cmu.cs.mvelezce.sleep.ast.statement.BlockStatement;
import edu.cmu.cs.mvelezce.sleep.ast.statement.Statement;
import edu.cmu.cs.mvelezce.sleep.interpreter.visitor.Visitor;

import java.util.List;

/**
 * A Sleep program.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class Program extends Statement {
    private BlockStatement blockStatement;

    // TODO List<? extends Statement> ?

    /**
     * Instantiate a {@code Program}.
     *
     * @param blockStatement
     */
    public Program(BlockStatement blockStatement) {
        if(blockStatement == null) {
            throw new IllegalArgumentException("The block statement cannot be null");
        }

        this.blockStatement = blockStatement;
    }

    @Override
    public <T,U> U accept(Visitor<T,U> visitor) {
        return visitor.visitProgram(this);
    }

    public BlockStatement getBlockStatement() { return this.blockStatement; }


    @Override
    public String toString() {
        return "Program{" + this.blockStatement + '}';
    }
}
