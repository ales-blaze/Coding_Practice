package Queue;
public class DeQueue<T> {
    private Integer front;
    private Integer rear;
    private int capacity;
    private T queue[];

    DeQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return front == null && rear == null ? true : false;
    }

    public boolean isFull() {
        if (front == 0 && rear == capacity - 1) return true;
        return false;
    }

    public void insertAtBeinnin(T value) {
        if (isEmpty()) {
            front = rear = 0;
            queue[front] = value;
            return;
        }
        if (isFull()) {
            System.err.print("Queue Full , Insertion at be/'innin/' can/'t  be done!");
        }
        if (front > 0) {
            queue[--front] = value;
            return;
        } else {
            int tempCounter = rear + 1;
            //loop
            while (tempCounter != front) {
                queue[tempCounter] = queue[tempCounter - 1];
                tempCounter--;
            }
            queue[front] = value;
            rear++;
        }
    }

    public void insertAtEnd(T value) {
        if (isEmpty()) {
            front = rear = 0;
            queue[rear] = value;
        } else if (isFull()) {
            System.err.print("INsertion not possible!");
        } else if (rear != capacity - 1) {
            queue[++rear] = value;
        } else if (front > 0) {
            //shiftin' of the values in the queue
            int tempCounter = front - 1;
            while (tempCounter != rear) {
                queue[tempCounter] = queue[tempCounter + 1];
                tempCounter++;
            }
            front--;
            queue[rear] = value;
        }
    }

    public T removeFromBeinnnin() {
        if (isEmpty()) {
            System.err.print("Empty Queue , nothin' to remove!");
        } else {
            T result = queue[front++];
            if (front > rear) {
                front = rear = null;
            }
            return result;
        }
        return null;
    }

    public T removeFromEnd() {
        if (isEmpty()) {
            System.err.print("Queue is Empty , Nothin' to remove");
        } else {
            T result = queue[rear--];
            if (rear < front) {
                front = rear = null;
            }
            return result;
        }
        return null;
    }

    public void displayQueue(){
        for(int index = front ; index <= rear ; index++){
            System.out.print(queue[index] + " ");
        }
    }

    public T front() {
        return queue[front];
    }

    public T rear() {
        return queue[rear];
    }
}