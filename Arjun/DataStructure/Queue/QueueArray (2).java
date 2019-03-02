package Queue;

import sun.invoke.empty.Empty;

import java.util.EmptyStackException;

interface Queue<T>{
    public void enqueue(T data);
    public T dequeue();
    public T front();
    public T rear();
    public void printQueue();
    public boolean isFull();
    public boolean isEmpty();
    public int getSize();
}

/**
 * Circular Queue
 * @param <T>
 */
public class QueueArray<T> implements Queue<T>{
    private Integer front;
    private Integer rear;
    private int capacity;
    private int size;
    private T[] array;

    QueueArray(int capacity){
        front = rear = null;
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public boolean isFull(){
        return (rear + 1 == capacity && front == 0) || rear + 1 == front;
    }

    public void enqueue(T data) throws StackOverflowError {
        if(this.isEmpty()){
            front = rear = 0;
            array[rear] = data;
            return;
        }
        else if(this.isFull()){
            throw new StackOverflowError();
//            System.err.print("Queue is Full!");
        }
        else{
            if(rear + 1 == capacity && front > 0){
                rear = -1;
            }
            array[++rear] = data;
        }
    }

    public T dequeue() throws  EmptyStackException {
        if(this.isEmpty()){
            throw new EmptyStackException();
//            System.err.print("Empty Array , Nothin' to dequeue!");
        }
        else{
            T returnValue = array[front++];
            if(front > rear){
                front = rear = null;
            }
            else if(front == capacity){
                front = 0;
            }
            return returnValue;
        }
    }

    public T front(){
        return array[front];
    }
    public T rear(){
        return array[rear];
    }

    public boolean isEmpty() {
        return  front == null && rear == null;
    }
    public void printQueue(){
        if(rear > front){
            for(int index = front ; index <= rear ;index++){
                System.out.print(this.array[index] + " ");
            }
            System.out.println();
        }
        else{
            for(int index = front ; index < capacity ; index++){
                System.out.print(array[index] + " ");
            }

            for(int index = 0 ; index <= rear  ; index++){
                System.out.print(array[index] + " ");
            }
            System.out.println();
        }
    }
    public int getSize(){
        return Math.abs(front - rear) + 1;
    }
}
