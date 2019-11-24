public class CM307LinkedList<E> implements CM307List<E>
{
    private int size = 0;
    private Node<E> head = null;
    private class Node<E> 
    {
        private E data = null;
        private Node<E> next = null;
    }
    public boolean isEmpty() 
    {
        return head == null;
    }
    public void add(E data)
    {
        Node<E> newNode =  new Node<E>();
        newNode.data = data;
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node<E> curr = head;
            for(int i = 0; i < size - 1; i++)
            {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }
    public E get(int n) {
        if (n < 0 || n >= size) return null;
        Node<E> curr = head;
        for(int i = 0; i < n; i++) {
            curr = curr.next;
        }
        return curr.data;
    }
    public E remove(int n) {
        if (n < 0 || n >= size) return null;
        if (n == 0) {
            E temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        else {
            Node<E> curr = head;
            for(int i = 0; i < n - 1; i++) {
                curr = curr.next;
            }
            E temp = curr.next.data;
            curr.next = curr.next.next;
            size--;
            return temp;
        }
    }
    public boolean insert(int n, E data) {
        if (n < 0 || n > size) return false;
        Node<E> newNode = new Node<E>();
        newNode.data = data;
        if (n == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }
        else {
            Node<E> prev = head;
            for(int i = 0; i < n - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
            return true;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if(curr.next != null) sb.append(",");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public int size() {
        return size;
    }
}