import java.io.*;
import java.util.*;
import java.*;
public class P05Driver {
public static void main(String[] args) throws FileNotFoundException {
    File file = new File("radixSortData.txt");
    Scanner reader = new Scanner(file);
    ArrayList<String> list1=new ArrayList<String>();
    LinkedList<String>[] queues= new LinkedList[10];
    int size = 0;
    while (reader.hasNextLine()) {
        String input = reader.nextLine();
        list1.add(input);
    }
    for (int i = 0; i < queues.length; i++) {
        queues[i] = new LinkedList<String>();
    }
    String temp = "";
    String check = "";
    int check2 = 0;
    for (int i = 0; i < list1.size(); i++) {
        temp = list1.get(i);
        check = temp.substring(2);
        check2 = Integer.parseInt(check);
        queues[check2].offer(temp);
    }
    list1.clear();
    for (int j = 0; j < 10;) {
        if (queues[j].isEmpty()) {
            j++;
            continue;
        }
        list1.add(queues[j].remove());
    }
    for (int i = 0; i < list1.size(); i++) {
        temp = list1.get(i);
        check = temp.substring(1);
        check2 = Integer.parseInt(check);
        check2 = check2 / 10;
        queues[check2].offer(temp);
    }
    list1.clear();
    for (int j = 0; j < 10;) {
        if (queues[j].isEmpty()) {
            j++;
            continue;
        }
        list1.add(queues[j].remove());
    }
    for (int i = 0; i < list1.size(); i++) {
        temp = list1.get(i);
        check2 = Integer.parseInt(temp);
        check2 = check2 / 100;
        queues[check2].offer(temp);
    }
    list1.clear();
    for (int j = 0; j < 10;) {
        if (queues[j].isEmpty()) {
            j++;
            continue;
        }
        list1.add(queues[j].remove());
    }
      for (int p = 0; p < list1.size(); p++) {
          System.out.println(list1.get(p));
    }
}
}