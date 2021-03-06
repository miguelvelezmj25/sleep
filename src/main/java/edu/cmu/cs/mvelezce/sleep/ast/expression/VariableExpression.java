package edu.cmu.cs.mvelezce.sleep.ast.expression;

import edu.cmu.cs.mvelezce.sleep.interpreter.visitor.Visitor;

/**
 * A variable expression.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class VariableExpression extends Expression {
    private String name;

    public VariableExpression(String name) {
        if(name == null) {
            throw new IllegalArgumentException("The name cannot be null");
        }

        if(name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }

        this.name = name;
    }

    /**
     * Returns the name of the variable.
     *
     * @return
     */
    public String getName() { return this.name; }


    @Override
    public <T,U> T accept(Visitor<T,U> visitor) {
        return visitor.visitVariableExpression(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VariableExpression that = (VariableExpression) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() { return this.name; }
}
