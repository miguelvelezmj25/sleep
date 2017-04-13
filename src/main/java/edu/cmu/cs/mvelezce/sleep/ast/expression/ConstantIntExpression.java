package edu.cmu.cs.mvelezce.sleep.ast.expression;

import edu.cmu.cs.mvelezce.sleep.interpreter.visitor.Visitor;

/**
 * A constant integer expression. This is different than the IntValue object since this is not the result of evaluating
 * expressions.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class ConstantIntExpression extends Expression {
    private final int value;

    public ConstantIntExpression(int value) {
        this.value = value;
    }

    /**
     * Returns the value of this constant.
     *
     * @return
     */
    public int getValue() { return this.value; }

    @Override
    public <T,U> T accept(Visitor<T,U> visitor) {
        return visitor.visitConstantIntExpression(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantIntExpression that = (ConstantIntExpression) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() { return String.valueOf(this.value); }
}
