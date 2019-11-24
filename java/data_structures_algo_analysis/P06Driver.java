import java.util.*;
import java.io.*;
public class P06Driver {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("animals.txt");
        Scanner reader =  new Scanner(file);
        TreeMap list1 = new TreeMap();
        Set list2;
        Collection list3;
        Object[] array1 = new Object[100];
        Object[] array2 = new Object[100];
        while (reader.hasNextLine()) {
            int help = 0;
            Object count = new Object();
            String input = reader.nextLine();
            if(list1.get(input) == null) list1.put(input, 1);
            else {
                count = list1.get(input);
                help = (int)count;
                help++;
                count = (Object)help;
                list1.replace(input, count);
        }
    }
    list2 = list1.keySet();
    list3 = list1.values();
    array1 = list2.toArray();
    array2 = list3.toArray();
    for (int k = 0; k < list1.size(); k++) {
        System.out.println(array1[k] + " = " + array2[k]);
    }
}
}