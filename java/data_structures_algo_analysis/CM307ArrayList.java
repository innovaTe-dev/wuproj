public class CM307ArrayList<E> implements CM307List<E> {
private int size = 0;
private E[] list;
public CM307ArrayList() {
list = (E[]) new Object[5];
}
public void add (E data) {
if (data == null) return;
if (size == list.length) reallocate();
list[size] = data;
size++;
}
public E get(int n) {
if (n < 0 || n >= size) return null;
return list[n];
}
public boolean isEmpty()
{
return size == 0;
}
public int size()
{
return size;
}
public boolean insert(int n, E data) {
if(n < 0 || n > size) return false;
if(data == null) return false;
if(size == list.length) reallocate();
if(n == size) {
    add(data);
    return true;
}
E temp = list[n];
for (int i = size - 1; i > n; i--)
{
list[i + 1] = list[i];
}
size++;
list[n + 1] = temp;
list[n] = data;
return true;
}
public E remove (int n)
{
if (n < 0 || n >= size) return null;
E temp = list[n];
for (int i = n; i < size - 1; i++)
{
list[i] = list[i + 1];
}
size--;
return temp;
}
private void reallocate()
{
E[] list2 = (E[]) new Object[2 * list.length];
for (int i = 0; i < size; i++)
{
list2[i] = list[i];
}
list = list2;
}
public String toString() {
    String print = "";
    String helper = "";
    for (int i = 0; i < size; i++)
    {
        helper = " " + list[i];
        print = print + helper;
    }
    return print;
}
}