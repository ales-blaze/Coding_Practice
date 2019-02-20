package Queue;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class QueueArrayTest {
    QueueArray queueArray;
    @Before
    public void setUp() throws Exception {
        queueArray = new QueueArray(5);
    }

    @Test
    public void enqueueTest(){
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        //testin' the size function
        assertEquals( 2 , queueArray.getSize());

        assertEquals(10 , queueArray.front());
    }

    @Test(expected = EmptyStackException.class)
    public void dequeueExceptionTest(){
        queueArray.dequeue();
    }

    @Test(expected = StackOverflowError.class)
    public void enqueueException(){
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.enqueue(40);
        queueArray.enqueue(50);
        queueArray.enqueue(60);
    }

    @Test
    public void enqueueTst(){
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.enqueue(40);
        queueArray.enqueue(50);
//        queueArray.printQueue();
        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.enqueue(60);
        queueArray.enqueue(70);
        queueArray.enqueue(80);
        queueArray.printQueue();
    }
    @Test
    public void rearTest(){
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        assertEquals(20 , queueArray.rear());
    }
    @Test
    public void frontTest(){
        queueArray.enqueue(10);

        int result =(Integer) queueArray.front();
        assertEquals(10 , result);
    }
}