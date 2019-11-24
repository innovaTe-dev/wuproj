import java.io.*;
import java.util.*;
public class ArrayStack<E> {
        public int top = -1;
        private E[] stack;
    public ArrayStack() {
        stack = (E[])new Object[20];
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
    private void reallocate() {
        E[] newStack = (E[])new Object[2 * stack.length];
        int top2 = top;
        for(int i  = 0; i < top2; i++) {
            E data = pop();
            newStack[i] = data;
        }
        top = top2;
        stack = newStack;
    }
    }