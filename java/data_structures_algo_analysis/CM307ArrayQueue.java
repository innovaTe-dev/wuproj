public class CM307ArrayQueue<E> {
        private int size = 0;
        private int rear = -1;
        private int front = 0;
        private E[] queue;
    public CM307ArrayQueue() {
        queue = (E[])new Object[10];
    }
    public void enQueue(E data) {
        if(size == queue.length) reallocate();
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
        size++;
    }
    public E deQueue() {
        if (size == 0) System.out.println("size error");
        E temp = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return temp;
    }
    private void reallocate() {
        E[] newQueue = (E[])new Object[2 * queue.length];
        int size2 = size;
        for(int i  = 0; i < size2; i++) {
            E data = deQueue();
            newQueue[i] = data;
        }
        size = size2;
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
}