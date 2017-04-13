package edu.cmu.cs.mvelezce.sleep.ast.statement;

import edu.cmu.cs.mvelezce.sleep.interpreter.visitor.Visitor;
import edu.cmu.cs.mvelezce.sleep.ast.Node;

/**
 * An abstract statement in the AST.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public abstract class Statement extends Node {

    /**
     *
     * Accept method of the Visitor Pattern that all Statements that extend this class must implement.
     *
     * @param visitor
     * @param <T>
     * @param <U>
     */
    public abstract <T,U> U accept(Visitor<T,U> visitor);

//    public abstract boolean myEquals(Object o);
//
//    public abstract int myHashCode();

}
