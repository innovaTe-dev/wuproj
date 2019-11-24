 import java.util.*;
 import java.io.*;
 public class P04Driver {

 public static void main(String[] args) throws FileNotFoundException {
     ArrayStack<Integer> stack1=new ArrayStack<Integer>();
     ArrayList<Integer> list1=new ArrayList<Integer>();
     int[] list2=new int[20];
     File file = new File("linkedArray.txt");
     Scanner reader = new Scanner(file);
     int element = 0;
     int index = 0;
     while (element != -1) {
         element = reader.nextInt();
         list1.add(element);
     }
     element = 0;
     while (element != -1) {
         element = list1.get(index);
         System.out.println(index);
         stack1.push(index);
         index = element;
     }
     System.out.println("");
     int prev = stack1.pop();
     int next = 0;
     while (!stack1.isEmpty()) {
         next = stack1.pop();
         System.out.println(next);
         list2[prev] = next;
         prev = next;
     }
     System.out.println("");
     for (int k = 0; k < 20; k++) {
         if (k == 0) list2[k] = -1;
         System.out.println(list2[k]);
     }
     reader.close();
 }
 }