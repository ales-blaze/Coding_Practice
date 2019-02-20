import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackApplicationTest {
    StackApplication object;

    @org.junit.Before
    public void setUp() throws Exception {
        object = new StackApplication();
    }

    @org.junit.Test
    public void bracketMatch() {
        assertTrue(object.bracketMatch("[{()}]"));
    }

    @Test
    public void infixToPostfix() {
        assertEquals("ab+cd+*", object.infixToPostfix("(a+b)*(c+d)"));
    }

    @Test
    public void infixToPrefix() {
        String string = "(a+b^c)*d+e^5";
        String stringResult = "+*+a^bcd^e5";
        assertEquals(stringResult,object.infixToPrefix(string));
    }
    //Test for the postfix to prefix Function
    @Test
//    (expected = EmptyStackException.class)
    public void prefixToInfix(){
        String output = "a+b^c*d+e^5";
        String input = "+*+a^bcd^e5";

        assertEquals(output , object.prefixToInfix(input));
    }
}

