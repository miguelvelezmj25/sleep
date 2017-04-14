package edu.cmu.cs.mvelezce.sleep.interpreter.visitor;

import edu.cmu.cs.mvelezce.sleep.ast.Program;
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
    public Expression visitBinaryExpression(BinaryExpression binaryExpression) {
        if(binaryExpression == null) {
            throw new IllegalArgumentException("The binaryExpression cannot be null");
        }

        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);

        return binaryExpression;
    }

    @Override
    public Expression visitConfigurationExpression(
            ConfigurationExpression configurationExpression) {
        if(configurationExpression == null) {
            throw new IllegalArgumentException("The configurationExpression cannot be null");
        }

        return configurationExpression;
    }

    @Override
    public Expression visitConstantIntExpression(ConstantIntExpression constantIntExpression) {
        if(constantIntExpression == null) {
            throw new IllegalArgumentException("The constantIntExpression cannot be null");
        }

        return constantIntExpression;
    }

    @Override
    public Expression visitUnaryExpression(UnaryExpression unaryExpression) {
        if(unaryExpression == null) {
            throw new IllegalArgumentException("The unaryExpression cannot be null");
        }

        unaryExpression.getExpression().accept(this);

        return unaryExpression;
    }

    @Override
    public Expression visitVariableExpression(VariableExpression variableExpression) {
        if(variableExpression == null) {
            throw new IllegalArgumentException("The variableExpression cannot be null");
        }

        return variableExpression;
    }

    @Override
    public Void visitAssignmentStatement(AssignmentStatement assignmentStatement) {
        if(assignmentStatement == null) {
            throw new IllegalArgumentException("The assignmentStatement cannot be null");
        }

        assignmentStatement.getVariable().accept(this);
        assignmentStatement.getRight().accept(this);
        return null;
    }

    @Override
    public Void visitBlockStatement(BlockStatement blockStatement) {
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
    public Void visitIfStatement(IfStatement ifStatement) {
        if(ifStatement == null) {
            throw new IllegalArgumentException("The ifStatement cannot be null");
        }

        ifStatement.getCondition().accept(this);
        ifStatement.getThenBlock().accept(this);
        return null;
    }

    @Override
    public Void visitSleepStatement(SleepStatement sleepStatement) {
        if(sleepStatement == null) {
            throw new IllegalArgumentException("The sleepStatement cannot be null");
        }

        sleepStatement.getTime().accept(this);
        return null;
    }

    @Override
    public Void visitWhileStatement(WhileStatement whileStatement) {
        if(whileStatement == null) {
            throw new IllegalArgumentException("The whileStatement cannot be null");
        }

        whileStatement.getCondition().accept(this);
        whileStatement.getBody().accept(this);
        return null;
    }

    @Override
    public Void visitProgram(Program program) {
        if(program == null) {
            throw new IllegalArgumentException("The program cannot be null");
        }

        program.getBlockStatement().accept(this);
        return null;
    }

}
