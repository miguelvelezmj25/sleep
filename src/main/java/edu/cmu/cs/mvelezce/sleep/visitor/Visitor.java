package edu.cmu.cs.mvelezce.sleep.visitor;

import edu.cmu.cs.mvelezce.sleep.ast.expression.*;
import edu.cmu.cs.mvelezce.sleep.ast.statement.*;

/**
 * An interface that specifies the methods of the Visitor Pattern.
 *
 * @param <V> the type of elements returned by the Visitor.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public interface Visitor <V,W> {

    /**
     * Evaluates an BinaryExpression.
     *
     * @param binaryExpression
     * @return
     */
    V visitExpressionBinary(BinaryExpression binaryExpression);

    /**
     * Evaluates an ConfigurationConstantExpression.
     *
     * @param configurationConstantExpression
     * @return
     */
    V visitExpressionConstantConfiguration(ConfigurationConstantExpression configurationConstantExpression);

    /**
     * Evaluates an ConstantIntExpression.
     *
     * @param constantIntExpression
     * @return
     */
    V visitExpressionConstantInt(ConstantIntExpression constantIntExpression);

    /**
     * Evaluates an UnaryExpression.
     *
     * @param unaryExpression
     * @return
     */
    V visitExpressionUnary(UnaryExpression unaryExpression);

    /**
     * Evaluates an VariableExpression.
     *
     * @param variableExpression
     * @return
     */
    V visitExpressionVariable(VariableExpression variableExpression);

    /**
     * Visit a AssignmentStatement.
     *
     * @param assignmentStatement
     */
    W visitStatementAssignment(AssignmentStatement assignmentStatement);

    /**
     * Visit a BlockStatement.
     *
     * @param blockStatement
     */
    W visitStatementBlock(BlockStatement blockStatement);

    /**
     * Visit a IfStatement.
     *
     * @param ifStatement
     */
    W visitStatementIf(IfStatement ifStatement);

    /**
     * Visit a SleepStatement.
     *
     * @param sleepStatement
     */
    W visitStatementSleep(SleepStatement sleepStatement);

    /**
     * Visit a WhileStatement.
     *
     * @param whileStatement
     */
    W visitStatementWhile(WhileStatement whileStatement);

    /**
     * Visit a TimedStatement
     *
     * @param timedStatement
     */
    W visitStatementTimed(TimedStatement timedStatement);
}
