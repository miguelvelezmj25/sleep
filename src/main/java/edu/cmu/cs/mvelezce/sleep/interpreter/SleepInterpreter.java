package edu.cmu.cs.mvelezce.sleep.interpreter;

import edu.cmu.cs.mvelezce.sleep.ast.expression.*;
import edu.cmu.cs.mvelezce.sleep.ast.statement.*;
import edu.cmu.cs.mvelezce.sleep.ast.value.IntValue;
import edu.cmu.cs.mvelezce.sleep.interpreter.visitor.Visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mvelezce on 4/13/17.
 */
public class SleepInterpreter implements Visitor<IntValue, Void> {
    private Set<String> activatedConfigurations;
    private Statement ast;
    private Map<String, IntValue> store;

    public SleepInterpreter(Statement ast) {
        this.store = new HashMap<>();
        this.ast = ast;
        this.activatedConfigurations = null;
    }

    public void evaluate(Set<String> activatedConfigurations) {
        this.activatedConfigurations = activatedConfigurations;
        this.ast.accept(this);
    }

    @Override
    public IntValue visitBinaryExpression(BinaryExpression binaryExpression) {
        IntValue left = binaryExpression.getLeft().accept(this);
        IntValue right =  binaryExpression.getRight().accept(this);

        if(binaryExpression.getOperation().equals("+")) {
            int result = left.getValue() + right.getValue();
            return new IntValue(result);
        }
        else if(binaryExpression.getOperation().equals("-")) {
            int result = left.getValue() - right.getValue();
            return new IntValue(result);
        }
        else if(binaryExpression.getOperation().equals("*")) {
            int result = left.getValue() * right.getValue();
            return new IntValue(result);
        }
        else if(binaryExpression.getOperation().equals("/")) {
            int result = left.getValue() / right.getValue();
            return new IntValue(result);
        }
        else if(binaryExpression.getOperation().equals("&&")) {
            if(left.getValue() == 1 && right.getValue() == 1) {
                return new IntValue(1);
            }

            return new IntValue(0);
        }
        else if(binaryExpression.getOperation().equals("||")) {
            if(left.getValue() == 0 && right.getValue() == 0) {
                return new IntValue(0);
            }

            return new IntValue(1);
        }

        // TODO do not return null
        return null;

    }

    @Override
    public IntValue visitConfigurationExpression(ConfigurationExpression configurationExpression) {
        int value = 0;

        if(this.activatedConfigurations.contains(configurationExpression.getName())) {
            value = 1;
        }

        return new IntValue(value);
    }

    @Override
    public IntValue visitConstantIntExpression(ConstantIntExpression constantIntExpression) {
        return new IntValue(constantIntExpression.getValue());
    }

    @Override
    public IntValue visitUnaryExpression(UnaryExpression unaryExpression) {
        IntValue result = unaryExpression.getExpression().accept(this);

        // TODO it seems like the "-" should be gotten from somewhere
        // TODO it seems weird how the int is generated
        // Negates ints
        if(unaryExpression.getOperation().equals("!")) {
            if(result.getValue() == 0) {
                return new IntValue(1);
            }
            return new IntValue(0);
        }

        return result;
    }

    @Override
    public IntValue visitVariableExpression(VariableExpression variableExpression) {
        return this.store.get(variableExpression.getName());
    }

    @Override
    public Void visitAssignmentStatement(AssignmentStatement assignmentStatement) {
        IntValue value = assignmentStatement.getRight().accept(this);
        this.store.put(assignmentStatement.getVariable().getName(), value);

        return null;
    }

    @Override
    public Void visitBlockStatement(BlockStatement blockStatement) {
        List<Statement> statements = blockStatement.getStatements();

        for(Statement statement : statements) {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visitIfStatement(IfStatement ifStatement) {
        IntValue condition = ifStatement.getCondition().accept(this);

        if(condition.getValue() > 0) {
            ifStatement.getThenBlock().accept(this);
        }

        return null;
    }

    @Override
    public Void visitSleepStatement(SleepStatement sleepStatement) {
        IntValue time = sleepStatement.getTime().accept(this);

        return null;
    }

    @Override
    public Void visitWhileStatement(WhileStatement whileStatement) {
        whileStatement.getCondition().accept(this);
        whileStatement.getBody().accept(this);

        return null;
    }

    public Map<String, IntValue> getStore() { return this.store; }
}

