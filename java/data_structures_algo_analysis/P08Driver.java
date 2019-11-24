import java.util.*;
import java.io.*;
public class P08Driver {
public static void main(String[] args) throws FileNotFoundException {
    CM307HashMap<Integer, Object> list1= new CM307HashMap<>();
    Scanner in = new Scanner(new File("animals.txt"));
    while (in.hasNextLine()) {
            int help = 0;
            Object count = new Object();
            String input = in.nextLine();
            if(list1.get(input) == null) list1.put(input, 1);
            else {
                count = list1.get(input);
                help = (int)count;
                help++;
                count = (Object)help;
                list1.put(input, count);
        }
    }
    System.out.println("====================");
    System.out.println("Printing list...");
    System.out.println("====================");
    list1.printObjects();
    System.out.println("====================");
    System.out.println("All done!");
}
}
