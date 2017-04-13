package edu.cmu.cs.mvelezce.sleep.interpreter;

import edu.cmu.cs.mvelezce.sleep.Helper;
import edu.cmu.cs.mvelezce.sleep.ast.statement.Statement;
import edu.cmu.cs.mvelezce.sleep.ast.value.IntValue;
import edu.cmu.cs.mvelezce.sleep.lexer.Lexer;
import edu.cmu.cs.mvelezce.sleep.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mvelezce on 4/13/17.
 */
public class SleepInterpreterTest {

    public static final String PROGRAMS_PATH = "src/main/java/edu/cmu/cs/mvelezce/sleep/programs/";

    @Test
    public void testEvaluate1() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program1");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");
        activatedConfigurations.add("B");


        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(1));
        store.put("b", new IntValue(1));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate2() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program2");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(1));
        store.put("b", new IntValue(0));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate3() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program3");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");
        activatedConfigurations.add("B");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(1));
        store.put("b", new IntValue(1));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate4() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program4");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");
        activatedConfigurations.add("B");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(1));
        store.put("b", new IntValue(1));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate5() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program5");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");
        activatedConfigurations.add("B");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(1));
        store.put("b", new IntValue(1));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate6() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program6");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");
        activatedConfigurations.add("B");
        activatedConfigurations.add("C");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(1));
        store.put("b", new IntValue(1));
        store.put("c", new IntValue(1));
        store.put("x", new IntValue(6));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate7() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program7");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");
        activatedConfigurations.add("B");
        activatedConfigurations.add("D");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(1));
        store.put("b", new IntValue(1));
        store.put("c", new IntValue(0));
        store.put("d", new IntValue(1));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate8() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program8");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(0));
        store.put("b", new IntValue(0));
        store.put("c", new IntValue(0));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate9() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program9");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("A");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(2));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }

    @Test
    public void testEvaluate10() throws Exception {
        // Compile
        String program = Helper.loadFile(SleepInterpreterTest.PROGRAMS_PATH + "program10");

        Lexer lexer = new Lexer(program);
        Parser parser = new Parser(lexer);
        Statement ast = parser.parse();

        // Configurations
        Set<String> activatedConfigurations = new HashSet<>();
        activatedConfigurations.add("B");
        activatedConfigurations.add("C");
        activatedConfigurations.add("D");

        // Execute
        SleepInterpreter interpreter = new SleepInterpreter(ast);
        interpreter.evaluate(activatedConfigurations);

        // Store
        Map<String, IntValue> store = new HashMap<>();
        store.put("a", new IntValue(0));
        store.put("b", new IntValue(1));
        store.put("c", new IntValue(1));
        store.put("d", new IntValue(1));

        // Assert
        Assert.assertEquals(store, interpreter.getStore());
    }


}
