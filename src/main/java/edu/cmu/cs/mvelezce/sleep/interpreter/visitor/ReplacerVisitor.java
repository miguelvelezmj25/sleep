package edu.cmu.cs.mvelezce.sleep.interpreter.visitor;

import edu.cmu.cs.mvelezce.sleep.ast.Program;
import edu.cmu.cs.mvelezce.sleep.ast.expression.*;
import edu.cmu.cs.mvelezce.sleep.ast.statement.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO and also check usage of LinkedList
 */
public class ReplacerVisitor implements Visitor<Expression, Statement> {

    public ReplacerVisitor() { ; }

    @Override
    public Expression visitBinaryExpression(BinaryExpression binaryExpression) {
        if(binaryExpression == null) {
            throw new IllegalArgumentException("The binaryExpression cannot be null");
        }

        Expression left = binaryExpression.getLeft().accept(this);
        Expression right = binaryExpression.getRight().accept(this);

        if(binaryExpression.getLeft().equals(left) && binaryExpression.getRight().equals(right)) {
            return binaryExpression;
        }

        return new BinaryExpression(left, binaryExpression.getOperation(), right);
    }

    @Override
    public Expression visitConfigurationExpression(ConfigurationExpression configurationExpression) {
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

        Expression expression = unaryExpression.getExpression().accept(this);

        if(unaryExpression.getExpression().equals(expression)) {
            return unaryExpression;
        }

        return new UnaryExpression(unaryExpression.getOperation(), expression);
    }

    @Override
    public Expression visitVariableExpression(VariableExpression variableExpression) {
        if(variableExpression == null) {
            throw new IllegalArgumentException("The variableExpression cannot be null");
        }

        return variableExpression;
    }

    @Override
    public Statement visitAssignmentStatement(AssignmentStatement assignmentStatement) {
        if(assignmentStatement == null) {
            throw new IllegalArgumentException("The assignmentStatement cannot be null");
        }

        VariableExpression variable = (VariableExpression) assignmentStatement.getVariable().accept(this);
        Expression right = assignmentStatement.getRight().accept(this);

        if(assignmentStatement.getVariable().equals(variable) && assignmentStatement.getRight().equals(right)) {
            return assignmentStatement;
        }

        return new AssignmentStatement(variable, right);
    }

    @Override
    public Statement visitBlockStatement(BlockStatement blockStatement) {
        if(blockStatement == null) {
            throw new IllegalArgumentException("The  cannot be null");
        }

        List<Statement> statements = blockStatement.getStatements();
        List<Statement> newStatements = new ArrayList<>();

        boolean changed = false;
        for(Statement statement : statements) {
            Statement newStatement = statement.accept(this);
            newStatements.add(newStatement);
            if(!statement.equals(newStatement)) {
                changed = true;
            }
        }

        if(!changed) {
            return blockStatement;
        }
        
        return new BlockStatement(newStatements);
    }

    @Override
    public Statement visitIfStatement(IfStatement ifStatement) {
        if(ifStatement == null) {
            throw new IllegalArgumentException("The ifStatement cannot be null");
        }

        Expression condition = ifStatement.getCondition().accept(this);
        Statement thenBlock = ifStatement.getThenBlock().accept(this);

        if(ifStatement.getCondition().equals(condition) && ifStatement.getThenBlock().equals(thenBlock)) {
            return ifStatement;
        }

        return new IfStatement(condition, thenBlock);
    }

    @Override
    public Statement visitSleepStatement(SleepStatement sleepStatement) {
        if(sleepStatement == null) {
            throw new IllegalArgumentException("The sleepStatement cannot be null");
        }

        Expression time = sleepStatement.getTime().accept(this);

        if(sleepStatement.getTime().equals(time)) {
            return sleepStatement;
        }

        return new SleepStatement(time);
    }

    @Override
    public Statement visitWhileStatement(WhileStatement whileStatement) {
        if(whileStatement == null) {
            throw new IllegalArgumentException("The whileStatement cannot be null");
        }

        Expression condition = whileStatement.getCondition().accept(this);
        Statement body = whileStatement.getBody().accept(this);
        
        if(whileStatement.getCondition().equals(condition) && whileStatement.getBody().equals(body)) {
            return whileStatement;
        }
        
        return new WhileStatement(condition, body);
    }

    @Override
    public Statement visitProgram(Program program) {
        if(program == null) {
            throw new IllegalArgumentException("The program cannot be null");
        }

        BlockStatement blockStatement = (BlockStatement) program.getBlockStatement().accept(this);

        if(program.getBlockStatement().equals(blockStatement)) {
            return program;
        }

        return new Program(blockStatement);
    }

}
