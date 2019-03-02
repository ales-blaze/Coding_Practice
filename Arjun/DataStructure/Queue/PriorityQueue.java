package Queue;

public class PriorityQueue {
    private Integer front , tail;
    private int capacity;
    private QueueElement queue[];
    PriorityQueue(int capacity){
        this.capacity = capacity;
        queue = new QueueElement[capacity];
    }
    class QueueElement{
        private int data;
        private int priority;

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
    }

    public boolean isEmpty(){
        return front == null && tail == null;
    }
    public boolean isFull(){
        return tail == capacity - 1;
    }
    //insertion operation and deletion operation
    public void insert(int data , int priority){
        if(isEmpty()){
            front = tail = 0;
            queue[tail].setData(data);
            queue[tail].setPriority(priority);
            return;
        }
        else if (isFull()){
            System.err.print("Queue Full");
        }
        else{
            queue[++tail].setData(data);
            queue[tail].setPriority(priority);
        }
    }
    public QueueElement remove(){
        if(isEmpty()) {
            System.err.print("Empty Queue!");
//            return;
        }
        int larPriorityNumber = -1;
        int indexOfLarPNumebr = -1;
        for(int index = 0 ; index < queue.length ; index++){
            if(queue[index].getPriority() > larPriorityNumber){
                larPriorityNumber = queue[index].getPriority();
                indexOfLarPNumebr = index;
            }
        }
        QueueElement result = queue[indexOfLarPNumebr];
        //shiftin' of the elements will occur
        while(indexOfLarPNumebr < queue.length) {
            queue[indexOfLarPNumebr] = queue[indexOfLarPNumebr + 1];
            if(indexOfLarPNumebr == queue.length - 1){
                tail--;
            }
        }
        if(tail < front) front = tail = null;
        return result;
//        return null;
    }

    public void printQueue(){
        for(QueueElement number : queue){
            System.out.print(number + " ");
        }
    }
}
