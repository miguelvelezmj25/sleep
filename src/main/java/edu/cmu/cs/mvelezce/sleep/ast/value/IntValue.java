package edu.cmu.cs.mvelezce.sleep.ast.value;

/**
 * A IntValue that represent the result of evaluating an expression
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class IntValue {
    private final int value;

    public IntValue(int value) { this.value = value; }

    /**
     * Returns the value.
     *
     * @return
     */
    public int getValue() { return this.value; }

    @Override
    public String toString() { return String.valueOf(this.value); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntValue intValue = (IntValue) o;

        return value == intValue.value;
    }

    @Override
    public int hashCode() { return this.value; }
}
