import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {
    ArrayStack<Long> stack;
    @Before
    public void setUp(){
        stack = new ArrayStack<>(2);
    }
    @Test
    public void pushTest() {
        stack.Push(10l);
        stack.Push(20l);
        stack.Push(30L);
        assertEquals(java.util.Optional.of(30L), java.util.Optional.ofNullable(stack.Peek()));
    }

    @Test
    public void pop() {
        stack.Push(10l);
        stack.Push(20l);
        stack.Push(30L);
        assertEquals(java.util.Optional.of(30L) , java.util.Optional.ofNullable(stack.Pop()));
    }

    @Test
    public void peek() {
        stack.Push(10l);
        stack.Push(20l);
        stack.Push(30L);

        assertEquals(java.util.Optional.of(30L) , java.util.Optional.ofNullable(stack.Peek()));
    }
}