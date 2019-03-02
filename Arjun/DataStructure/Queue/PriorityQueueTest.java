package Queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    PriorityQueue priorityQueue;

    @Before
    public void setUp(){
        priorityQueue = new PriorityQueue(5);
    }

    @Test
    public void insertionTest(){
        priorityQueue.insert(10 , 1);
        priorityQueue.insert(20 , 2);
        priorityQueue.insert(30 , 3);
        priorityQueue.insert(5 , 0);
        priorityQueue.insert(2 , -1);
        priorityQueue.printQueue();
    }
}