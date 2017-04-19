package edu.cmu.cs.mvelezce.sleep.ast.expression;

import edu.cmu.cs.mvelezce.sleep.interpreter.visitor.Visitor;

/**
 * A constant configuration expression. If this object is instantiated, we assume that it's value is true.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class ConstantConfigurationExpression extends Expression {
    private String name;

    /**
     * Initialize an {@code ConstantConfigurationExpression}.
     *
     * @param name
     */
    public ConstantConfigurationExpression(String name) {
        if(name == null) {
            throw new IllegalArgumentException("The name cannot be null");
        }

        if(name.isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }

        this.name = name;
    }

    /**
     * Returns the name of this configuration.
     * 
     * @return
     */
    public String getName() { return this.name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantConfigurationExpression that = (ConstantConfigurationExpression) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public <T,U> T accept(Visitor<T,U> visitor) {
        return visitor.visitConstantConfigurationExpression(this);
    }

    @Override
    public String toString() { return this.name; }
}
