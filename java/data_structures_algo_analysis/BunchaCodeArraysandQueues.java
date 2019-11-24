    public class ArrayStack<E> {
        public int top = -1;
        private E[] stack;
    public ArrayStack<E>() {
        stack = (E[])new Object[10];
    }
    public void push(E data) {
        if (top == stack.length - 1) reallocate();
        top++;
        stack[top] = data;
    }
    public E pop() throws NoSuchElementException {
        if(top == -1) throw new NoSuchElementException();
        return stack[top--];
    }
    public boolean isEmpty() {
        return top==-1;
    }
    }
    public class LinkedStack<E> {
        private Node<E> top = null;
    public void push(E data) {
        Node<E> newNode = new Node<E>();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
    }
    public E pop() throws NoSuchElementException {
        if(top == null) throw new NoSuchElementException();
        E temp = top.data;
        top = top.next;
        return temp;
    }
    public class CM307ArrayQueue<E> {
        private int size = 0;
        private int rear = -1;
        private int front = 0;
        private E[] queue;
    }
    public CM307ArrayQueue {
        queue = (E[])new Object[10];
    }
    public void enQueue(E data) {
        if(size == queue.length) reallocate();
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
        size++;
    }
    public E deQueue() throws NoSuchElementException {
        if (size == 0) throw new NoSuchElementException();
        E temp = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return temp;
    }
    private void reallocate() {
        E[] newQueue = (E[])newObject[2 * queue.length];
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
    public void enQueue(E data) {
        Node<E> newNode = new Node<E>();
        newNode.data = data;
        rear.next = newNode;
        if(rear == null) {
            front = rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    public E deQueue() throws NoSuchElementException {
        if(front == null) throw new NoSuchElementException();
        E temp = front.data;
        front = front.front;
        return temp;
    }