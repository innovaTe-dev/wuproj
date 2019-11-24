import java.io.*;
import java.util.*;
public class P07Driver {
public static void main(String[] args) {
CM307Heap<String> list1 = new CM307Heap<>();
System.out.println("=======================");
System.out.println("Enqueueing strings...");
System.out.println("=======================");
list1.enQueue("E");
list1.enQueue("J");
list1.enQueue("A");
list1.enQueue("C");
list1.enQueue("F");
list1.enQueue("H");
list1.enQueue("B");
list1.enQueue("I");
list1.enQueue("D");
list1.enQueue("G");
System.out.println("=======================");
System.out.println("Dequeueing strings...");
System.out.println("=======================");
for (int k = 0; k < 10; k++) {
    System.out.println(list1.deQueue());
}
CM307Heap<Integer> list2 = new CM307Heap<>();
System.out.println("=======================");
System.out.println("Enqueueing integers...");
System.out.println("=======================");
list2.enQueue(10);
list2.enQueue(2);
list2.enQueue(7);
list2.enQueue(1);
list2.enQueue(6);
list2.enQueue(5);
list2.enQueue(8);
list2.enQueue(3);
list2.enQueue(4);
list2.enQueue(9);
System.out.println("=======================");
System.out.println("Dequeueing integers...");
System.out.println("=======================");
for (int i = 0; i < 10; i++) {
    System.out.println(list2.deQueue());
    
}
System.out.println("=======================");
System.out.println("All done!");
}
}
