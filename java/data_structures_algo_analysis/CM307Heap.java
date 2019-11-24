import java.util.*;
public class CM307Heap<E extends Comparable<E>> {
    private E[] heap;
    private int size = 0;
    public CM307Heap() {
        heap = (E[])new Comparable[100];
    }
    public void enQueue(E data) {
        heap[size] = data;
        reheapUp(size);
        size++;
    }
    private void reheapUp(int n) {
        if(n == 0) return;
        int p = (n - 1) / 2;
        if(heap[n].compareTo(heap[p]) < 0) {
            E temp = heap[n];
            heap[n] = heap[p];
            heap[p] = temp;
            reheapUp(p);
        }
    }
    public E deQueue() {
        E temp = heap[0];
        size --;
        heap[0] = heap[size];
        reheapDown(0);
        return temp;
    }
    private void reheapDown(int n) {
        int l = (2 * n) + 1;
        int r = (2 * n) + 2;
        if(l >= size) return;
        if(r >= size) {
            if(heap[n].compareTo(heap[l]) > 0) {
                E temp = heap[n];
                heap[n] = heap[l];
                heap[l] = temp;
            }
        }
            else {
                if(heap[n].compareTo(heap[l]) > 0 || heap[n].compareTo(heap[r]) > 0) {
                    if(heap[l].compareTo(heap[r]) > 0) {
                        E temp = heap[n];
                        heap[n] = heap[r];
                        heap[r] = temp;
                        reheapDown(r);
                    }
                    else {
                        E temp = heap[n];
                        heap[n] = heap[l];
                        heap[l] = temp;
                        reheapDown(l);
                        
                    }
                }
            }
    }
}



