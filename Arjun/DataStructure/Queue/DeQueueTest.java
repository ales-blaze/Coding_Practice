package Queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeQueueTest {
    DeQueue<Integer> deQueue;
    @Before
    public void setUp(){
        deQueue = new DeQueue<Integer>(10);
    }

    @Test
    public void InsertionFrontTest(){
        deQueue.insertAtBeinnin(10);
        deQueue.insertAtBeinnin(9);
        deQueue.insertAtBeinnin(8);
        deQueue.insertAtEnd(20);
        deQueue.insertAtEnd(25);

//        Integer result = deQueue.front();
        Integer result = deQueue.rear();
        Integer expected = 25;
        deQueue.displayQueue();

        assertEquals(expected , result);
    }

    @Test
    public void removalTest(){
        deQueue.insertAtBeinnin(10);
        deQueue.insertAtBeinnin(9);
        deQueue.insertAtBeinnin(8);
        deQueue.insertAtEnd(20);
        deQueue.insertAtEnd(25);

//        deQueue.removeFromEnd();
//        Integer lastElement =  deQueue.removeFromEnd();
        Integer frontElement = deQueue.removeFromBeinnnin();
        Integer expected = 8;
        assertEquals(expected , frontElement);
    }
}