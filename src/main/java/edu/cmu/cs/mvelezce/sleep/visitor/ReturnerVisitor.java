package edu.cmu.cs.mvelezce.sleep.visitor;

import edu.cmu.cs.mvelezce.sleep.ast.expression.*;
import edu.cmu.cs.mvelezce.sleep.ast.statement.*;

import java.util.List;

/**
 * A concrete implementation of the Visitor Pattern that returns the same expressions that are passed. The statements
 * are analyzed, but they do not return anything.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.1
 */
public class ReturnerVisitor implements Visitor<Expression, Void> {
    @Override
    public Expression visitExpressionBinary(BinaryExpression binaryExpression) {
        if(binaryExpression == null) {
            throw new IllegalArgumentException("The binaryExpression cannot be null");
        }

        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);

        return binaryExpression;
    }

    @Override
    public Expression visitExpressionConstantConfiguration(
            ConfigurationConstantExpression configurationConstantExpression) {
        if(configurationConstantExpression == null) {
            throw new IllegalArgumentException("The configurationConstantExpression cannot be null");
        }

        return configurationConstantExpression;
    }

    @Override
    public Expression visitExpressionConstantInt(ConstantIntExpression constantIntExpression) {
        if(constantIntExpression == null) {
            throw new IllegalArgumentException("The constantIntExpression cannot be null");
        }

        return constantIntExpression;
    }

    @Override
    public Expression visitExpressionUnary(UnaryExpression unaryExpression) {
        if(unaryExpression == null) {
            throw new IllegalArgumentException("The unaryExpression cannot be null");
        }

        unaryExpression.getExpression().accept(this);

        return unaryExpression;
    }

    @Override
    public Expression visitExpressionVariable(VariableExpression variableExpression) {
        if(variableExpression == null) {
            throw new IllegalArgumentException("The variableExpression cannot be null");
        }

        return variableExpression;
    }

    @Override
    public Void visitStatementAssignment(AssignmentStatement assignmentStatement) {
        if(assignmentStatement == null) {
            throw new IllegalArgumentException("The assignmentStatement cannot be null");
        }

        assignmentStatement.getVariable().accept(this);
        assignmentStatement.getRight().accept(this);
        return null;
    }

    @Override
    public Void visitStatementBlock(BlockStatement blockStatement) {
        if(blockStatement == null) {
            throw new IllegalArgumentException("The blockStatement cannot be null");
        }

        List<Statement> statements = blockStatement.getStatements();

        for(Statement statement : statements) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visitStatementIf(IfStatement ifStatement) {
        if(ifStatement == null) {
            throw new IllegalArgumentException("The ifStatement cannot be null");
        }

        ifStatement.getCondition().accept(this);
        ifStatement.getThenBlock().accept(this);
        return null;
    }

    @Override
    public Void visitStatementSleep(SleepStatement sleepStatement) {
        if(sleepStatement == null) {
            throw new IllegalArgumentException("The sleepStatement cannot be null");
        }

        sleepStatement.getTime().accept(this);
        return null;
    }

    @Override
    public Void visitStatementWhile(WhileStatement whileStatement) {
        if(whileStatement == null) {
            throw new IllegalArgumentException("The whileStatement cannot be null");
        }

        whileStatement.getCondition().accept(this);
        whileStatement.getBody().accept(this);
        return null;
    }

    @Override
    public Void visitStatementTimed(TimedStatement timedStatement) {
        if(timedStatement == null) {
            throw new IllegalArgumentException("The timedStatement cannot be null");
        }

        timedStatement.getStatements().accept(this);
        return null;
    }
}
