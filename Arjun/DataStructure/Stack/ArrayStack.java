public class ArrayStack<E> {
    E stack[];
    Integer top;
    private static int defaultSize;

    {
      top = -1;
    }

    public ArrayStack(){
        defaultSize = 10;
        stack = (E[]) new Object[defaultSize];
    }
    public ArrayStack(int sizeOfTheStack){
        stack = (E[]) new Object[sizeOfTheStack];
    }

    //Operations : 1.Push 2.Pop 3.Peek 4.Print 5.isEmpty()
    public boolean isEmpty(){
       return top == -1 ? true : false;
    }

    public boolean isFull(){
        return top == stack.length - 1;
    }

    public void Push(E data){
        if(this.isFull()){
            E newStackArray[] =(E[]) new Object[stack.length * 2];
            int iterator = 0;
            for(/*int iterator = 0 */; iterator <= top ; iterator++){
                newStackArray[iterator] = stack[iterator];
            }
            newStackArray[++top] = data;
            stack = newStackArray;
            newStackArray = null;
        }
        else{
            //top++;
            stack[++top] = data;
        }
    }
    public E Pop(){
        if(this.isEmpty()) return null;
        else{
            E tempoStorage = stack[top];
            top--;
            return tempoStorage;
        }
    }
    public E Peek(){
        if(this.isEmpty()) return null;
        else{
            return stack[top];
        }
    }
}
