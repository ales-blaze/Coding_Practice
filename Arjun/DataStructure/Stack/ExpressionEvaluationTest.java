package DataStructure.Stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionEvaluationTest {
    ExpressionEvaluation expressionEvaluation;
    @Before
    public void setUp() throws Exception {
        expressionEvaluation = new ExpressionEvaluation();
    }

    @Test
    public void infixToPostfix() {
        String string = "a+b*(c^d-e)^(f+g*h)-i";

        expressionEvaluation.infixToPostfix(string);
    }
}