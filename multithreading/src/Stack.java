public class Stack {
    private int[] array;
    private int stackTop;
    final Object lock;
    public Stack(int capacity){
        array= new int[capacity];
        stackTop=-1;
        lock = new Object();
    }
    public boolean isEmpty(){
        return stackTop<0;
    }

    public void push(int element){
        synchronized (lock){
            array[++stackTop]=element;
        }

    }
    public synchronized int pop(){
            return 1;
    }


}
