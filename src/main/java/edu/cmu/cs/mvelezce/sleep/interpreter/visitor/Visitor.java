package edu.cmu.cs.mvelezce.sleep.interpreter.visitor;

import edu.cmu.cs.mvelezce.sleep.ast.Program;
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
    V visitBinaryExpression(BinaryExpression binaryExpression);

    /**
     * Evaluates an ConstantConfigurationExpression.
     *
     * @param constantConfigurationExpression
     * @return
     */
    V visitConstantConfigurationExpression(ConstantConfigurationExpression constantConfigurationExpression);

    /**
     * Evaluates an ConstantIntExpression.
     *
     * @param constantIntExpression
     * @return
     */
    V visitConstantIntExpression(ConstantIntExpression constantIntExpression);

    /**
     * Evaluates an UnaryExpression.
     *
     * @param unaryExpression
     * @return
     */
    V visitUnaryExpression(UnaryExpression unaryExpression);

    /**
     * Evaluates an VariableExpression.
     *
     * @param variableExpression
     * @return
     */
    V visitVariableExpression(VariableExpression variableExpression);

    /**
     * Visit a AssignmentStatement.
     *
     * @param assignmentStatement
     */
    W visitAssignmentStatement(AssignmentStatement assignmentStatement);

    /**
     * Visit a BlockStatement.
     *
     * @param blockStatement
     */
    W visitBlockStatement(BlockStatement blockStatement);

    /**
     * Visit a IfStatement.
     *
     * @param ifStatement
     */
    W visitIfStatement(IfStatement ifStatement);

    /**
     * Visit a SleepStatement.
     *
     * @param sleepStatement
     */
    W visitSleepStatement(SleepStatement sleepStatement);

    /**
     * Visit a WhileStatement.
     *
     * @param whileStatement
     */
    W visitWhileStatement(WhileStatement whileStatement);

    /**
     * Visit a Program.
     * @param program
     * @return
     */
    W visitProgram(Program program);
}
